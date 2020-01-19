import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
 
public class Screen extends JPanel implements Runnable, KeyListener {
 
    private static final long serialVersionUID = 1L;
 
    public static final int WIDTH = 800, HEIGHT = 800;
   
    private Thread thread;
    private boolean running = false;
 
    private BodyPart b;
    private ArrayList<BodyPart> snake;
 
    private Apple apple;
    private ArrayList<Apple> apples;
    
    private Trap trap;
    private ArrayList<Trap> traps;
   
    private Random r;
   
    private int xCoor = 2, yCoor = 2;
    private int size = 5;
    private static int score=0;
    
    private boolean right = true, left = false, up = false, down =false;
   
    private int ticks = 0,moves=0;
    private Image grass;
    
    public Screen() {
    	
//    	JPanel scoreboard = new JPanel();
       setFocusable(true);
//        //ScoreBoard scoreboard = new ScoreBoard();
       addKeyListener(this);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
//        
//        JLabel lblScore = \new JLabel("Score:");
//        lblScore.setVisible(true);
//        lblScore.setForeground(Color.yellow);
//        lblScore.setFont(new Font("Source Sans Pro ExtraLight", Font.PLAIN, 33));
//        add(lblScore);
 
        r = new Random();
       
        snake = new ArrayList<BodyPart>();
        apples = new ArrayList<Apple>();
        traps = new ArrayList<Trap>();
       
        start();
    }

    public void tick() {
        if (snake.size() == 0) {
            b = new BodyPart(xCoor, yCoor, 40);
            snake.add(b);
        }
        if(traps.size()==0) 
        {
        	int xCoor = r.nextInt(9);
        	int yCoor = r.nextInt(9);
        	trap = new Trap(xCoor,yCoor,40);
        	traps.add(trap);
        }
        for(int i = 0; i < traps.size(); i++) {
            if(xCoor == traps.get(i).getxCoor() &&
                yCoor == traps.get(i).getyCoor()) 
            	{
            		trap.generateQuiz();
            		size++;
            		traps.remove(i);
            		i++;
            		}}
        
        if(apples.size() == 0) {
            int xCoor = r.nextInt(9);
            int yCoor = r.nextInt(9);
            apple = new Apple(xCoor, yCoor, 40);
            apples.add(apple);
            
            xCoor = r.nextInt(9);
            yCoor = r.nextInt(9);
            apple = new Apple(xCoor, yCoor, 40);
            apples.add(apple);
        }
        if(apples.size() == 1) {
            apples.remove(0);
            int xCoor = r.nextInt(9);
            int yCoor = r.nextInt(9);
            apple = new Apple(xCoor, yCoor, 40);
            apples.add(apple);
            
            xCoor = r.nextInt(9);
            yCoor = r.nextInt(9);
            apple = new Apple(xCoor, yCoor, 40);
            apples.add(apple);
        }
       
        for(int i = 0; i < apples.size(); i++) {
            if(xCoor == apples.get(i).getxCoor() &&
                yCoor == apples.get(i).getyCoor()) 
            	{
            		if(apples.get(i).getColor()!=BodyPart.color) {
            			PlayMusic.playSound("src/soundtrack/die.wav");
            			stop();
            		}
            		else {
		                size++;
		                apples.remove(i);
		                i++;
		                PlayMusic.playSound("src/soundtrack/score.wav");
		                Apple.getRandom();
	                }
            	}
        }
       
        for(int i =0; i < snake.size(); i++) {
            if(xCoor == snake.get(i).getxCoor() &&
                    yCoor == snake.get(i).getyCoor()) {
                if(i != snake.size() - 1) {
                	PlayMusic.playSound("src/soundtrack/die.wav");
                    stop();
                }
            }
        }
        if(xCoor < 0 || xCoor > 19 || yCoor < 0 || yCoor > 19) {
        	PlayMusic.playSound("src/soundtrack/die.wav");
            stop();
        }
       
       
        ticks++;
       
        if(ticks > 500000) {
            if(right) xCoor++;
            if(left) xCoor--;
            if(up) yCoor--;
            if(down) yCoor++;
           
            ticks = 0;
            moves++;
            if(moves>20) {
            	moves=0;
            	BodyPart.changeColor();//change color every 20 moves
            }
           
            b = new BodyPart(xCoor, yCoor, 40);
            snake.add(b);
           
            if(snake.size() > size) {
                snake.remove(0);
            }
        }
    }
    public void loadImage(Graphics g) {
    	ImageIcon d = new ImageIcon("src/pictures/grass.jpg");
    	grass = d.getImage();
    }
    public void paint(Graphics g) {
    	
       g.clearRect(0, 0, WIDTH, HEIGHT);
       // g.fillRect(0, 0, WIDTH, HEIGHT);
        loadImage(g);
    	g.drawImage(grass,0,0,800,800,null);
        for (int i = 0; i < snake.size(); i++) {
            snake.get(i).draw(g);
        }
        for(int i = 0; i < apples.size(); i++) {
            apples.get(i).draw(g);
        }
        for (int i=0; i<traps.size();i++)
		{
			traps.get(i).draw(g);
		}
 
    }
 
    public void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }
 
    public void stop() {
        running = false;
        
        try {
            thread.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    public void run() {
        while (running) {
            tick();
            repaint();
        }
    }
 
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT && !left) {
            up = false;
            down = false;
            right = true;
        }
        if(key == KeyEvent.VK_LEFT && !right) {
            up = false;
            down = false;
            left = true;
        }
        if(key == KeyEvent.VK_UP && !down) {
            left = false;
            right = false;
            up = true;
        }
        if(key == KeyEvent.VK_DOWN && !up) {
            left = false;
            right = false;
            down = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent arg0) {   
    }
    public void keyTyped(KeyEvent arg0) {  
    }    
}
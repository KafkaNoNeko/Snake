import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
 
public class Apple {
	private Image b1;
	private Image b2;
	private Image b3;
	private Image b4;
	private Image b5;
	private Image g1;
	private Image g2;
	private Image g3;
	private Image g4;
	private Image g5;
	private Image g6;
	private Image g7;
	private Image g8;
	private Image y1;
	private Image y2;
	private Image y3;
	private Image y4;
	public static Image blueList[]=new Image[10];
	public static Image greenList[]=new Image[10];
	public static Image yellowList[]=new Image[10];
	public static int rand[]= {0,1,2,3};
	
    private int xCoor, yCoor, width, height;
    private int appleColor=(int)(Math.random()*3+1);
    public Apple(int xCoor, int yCoor, int tileSize) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = tileSize;
        height = tileSize;
    }
    public void tick() {
       
    }
    public int getColor() {
    	return appleColor;
    }
    public void loadImage(Graphics g) {
        ImageIcon d = new ImageIcon("src/pictures/blue/b1.jpg");
        b1 = d.getImage();
        d = new ImageIcon("src/pictures/blue/b2.jpg");
        b2 = d.getImage();
        d = new ImageIcon("src/pictures/blue/b3.jpg");
        b3 = d.getImage();
        d = new ImageIcon("src/pictures/blue/b4.jpg");
        b4 = d.getImage();
        d = new ImageIcon("src/pictures/blue/b5.jpg");
        b5 = d.getImage();
        d = new ImageIcon("src/pictures/green/g1.jpg");
        g1 = d.getImage();
        d = new ImageIcon("src/pictures/green/g2.jpg");
        g2 = d.getImage();
        d = new ImageIcon("src/pictures/green/g3.jpg");
        g3 = d.getImage();
        d = new ImageIcon("src/pictures/green/g4.jpg");
        g4 = d.getImage();
        d = new ImageIcon("src/pictures/green/g5.jpg");
        g5 = d.getImage();
        d = new ImageIcon("src/pictures/green/g6.jpg");
        g6 = d.getImage();
        d = new ImageIcon("src/pictures/green/g7.jpg");
        g7 = d.getImage();
        d = new ImageIcon("src/pictures/green/g8.jpg");
        g8 = d.getImage();
        d = new ImageIcon("src/pictures/yellow/y1.jpg");
        y1 = d.getImage();
        d = new ImageIcon("src/pictures/yellow/y2.jpg");
        y2 = d.getImage();
        d = new ImageIcon("src/pictures/yellow/y3.jpg");
        y3 = d.getImage();
        d = new ImageIcon("src/pictures/yellow/y4.jpg");
        y4 = d.getImage();
        blueList[0] = b1;
        blueList[1] = b2;
        blueList[2] = b3;
        blueList[3] = b4;
        blueList[4] = b5;
        greenList[0] = g1;
        greenList[1] = g2;
        greenList[2] = g3;
        greenList[3] = g4;
        greenList[4] = g5;
        greenList[5] = g6;
        greenList[6] = g7;
        greenList[7] = g8;
        yellowList[0] = y1;
        yellowList[1] = y2;
        yellowList[2] = y3;
        yellowList[3] = y4;
    }
    public static void getRandom() {
    	int r[] = new int[4];
    	r[0] = (int)(Math.random()*5);
    	r[1] = (int)(Math.random()*4);
    	r[2] = (int)(Math.random()*8);
    	rand = r;
    }
    public void draw(Graphics g) {
    	loadImage(g);
    	//Image a=cardboard2;
    	if(this.appleColor==1) {
    		g.drawImage(blueList[rand[0]],xCoor*width,yCoor*height,null);
    	}
        else if(this.appleColor==2){
    		g.drawImage(yellowList[rand[1]],xCoor*width,yCoor*height,null);
    	}
        else if(this.appleColor==3){
    		g.drawImage(greenList[rand[2]],xCoor*width,yCoor*height,null);
    	}
    	//g.drawImage(a,xCoor*width,yCoor*height,null);
    }
    public int getxCoor() {
        return xCoor;
    }
    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }
    public int getyCoor() {
        return yCoor;
    }
    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }
   
}
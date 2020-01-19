//Life is hard, so is JFrame
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class Frame {
	
    public Frame() {
       
        JFrame frame = new JFrame();
//        public void loadImage(Graphics g) {
//        	ImageIcon d = new ImageIcon("src/pictures/grass.jpg");
//        	grass = d.getImage();
//        }
//        loadImage(g);
//        frame.getContentPane().setLayout(null);
        
        Screen screen = new Screen();
        screen.setBounds(0, 0, 996, 710);
        frame.getContentPane().add(screen);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Snake it out");
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); 
//        frame.getContentPane().add(scoreboard);
        
        
 
       
    }
    public static void main(String[] args) {
        new Frame();
    }
}
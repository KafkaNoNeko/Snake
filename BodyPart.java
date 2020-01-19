import java.awt.Color;
import java.awt.Graphics;
 
public class BodyPart {
   
    private int xCoor, yCoor, width, height;
    public static int color=1;//blue=1,yellow=2,green=3,grey=4
    
    public BodyPart(int xCoor, int yCoor, int tileSize) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.width = tileSize;
        this.height = tileSize;
    }
    public void tick() {
       
    }
    public static void changeColor() {
    	color=(int)(Math.random()*3+1);//generate random color
    }
    public void draw(Graphics g) {
        if(this.color==1)
        	g.setColor(new Color(107,185,240));
        else if(this.color==2)
        	g.setColor(new Color (255,236,139));
        else if(this.color==3)
        	g.setColor(new Color(135, 211, 124));
        g.fillRect(xCoor * width, yCoor * height, width, height);
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
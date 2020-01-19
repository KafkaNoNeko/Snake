import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Trash {
	
	private int xCoor, yCoor, width, height;
	private Color[] colours = {Color.blue, Color.yellow, Color.green,Color.gray};
	/* Colour code: 
	 * blue = recycling
	 * yellow = compost
	 * green = refundables
	 * gray = waste
	 */
	
	public Trash(int xCoor, int yCoor, int tileSize) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = tileSize;
        height = tileSize;
        
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
	
	
    public void draw(Graphics g) {
    	Random rand = new Random();
        g.setColor(colours[rand.nextInt(colours.length)]);  //randomly assigns a category (based on the color) to the trash
        g.fillRect(xCoor * width , yCoor * height, width, height);
    }
}

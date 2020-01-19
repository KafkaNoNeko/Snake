import java.awt.Color;
import java.awt.Graphics;

public class Trap {
	
	private int xCoor, yCoor, width, height;
	
	public Trap(int xCoor, int yCoor, int tileSize) {
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
    	g.setColor(Color.red);  
        g.fillRect(xCoor * width , yCoor * height, width, height);
    }
    
    public void generateQuiz() {

    	String[] question = generateQuestion();
    	
    	String answer = GameElements.createPopUp(question[0]);
    	if(question[1].equalsIgnoreCase(answer)) {
    		GameElements.correct();		
		}
		else {
			GamePanel.stop();
		}
    	
    }
    
    	
    /*enters trap - generates quiz
     * asks one random question
     * correct - > continue
     * incorrect - > call end program
     */
    
    public String[] generateQuestion() {
    	String[] generatedQA = new String [2];
    	String[] questions = {"aa"," bb"};   //add questions and answers later
    	String[] answers = {"aa", "bb"};
    	int x  = (int)(Math.random() * questions.length); 
    	
    	shuffleQuestions(questions, answers);
    	
    	generatedQA[0] = questions[x];
    	generatedQA[1] = answers[x];
    	
    	return generatedQA;
    	
    	}
    
    public static void shuffleQuestions(String[] q, String[] a) {  
		int random;
		String temp;
		for (int i = q.length-1; i > 0; i--) {
			random = (int) (Math.random()*(i+1));
			//swap question
			temp =  q[i];
			q[i] = q[random];
			q[random] = temp;
			
			//swap answer
			temp =  a[i];
			a[i] = a[random];
			a[random] = temp;
			
		}
	}
    
    
    
}
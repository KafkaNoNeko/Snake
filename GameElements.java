
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameElements {
	
	public static String createPopUp(String msg) {
		JFrame frame = new JFrame("Oops! Almost there!");
		 Font font = new Font("Arial", Font.BOLD, 20);
		 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200,100,400,200);
		
		Container container = frame.getContentPane();
		container.setLayout(null);
		
		JLabel title = new JLabel();
		title.setText("Quiz Time! Will you survive?");
		title.setBounds(49,0,300,45);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(font);
		

		JLabel question = new JLabel(msg);
		question.setBounds(20, 40 , 250, 30);
		question.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel answer = new JLabel("Answer: ");
		answer.setHorizontalAlignment(SwingConstants.CENTER);
		answer.setBounds(20, 80 , 60, 30);
		
		JTextField answerField = new JTextField(100);
		answerField.setBounds(90,80,250,30);
		
		
		container.add(title);
		container.add(question);
		container.add(answer);
		container.add(answerField);
		
		String result = answerField.getText();
		
		
		frame.setVisible(true);
		
		return result;
	}
	
	
}


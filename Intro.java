import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.SwingConstants;

import com.sun.tools.javac.Main;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Intro {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Intro window = new Intro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Intro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("SNAKE IT OUT");
		frame.setBounds(100, 100, 500, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setBackground(new Color(200, 247, 197));
		
		JLabel lblNewLabel_1 = new JLabel("How to \"Snake\" ?");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(183, 177, 129, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("SNAKE IT OUT");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 500, 51);
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea Big = new JTextArea();
		Big.setFont(new Font("AppleGothic", Font.BOLD, 14));
		Big.setForeground(Color.white);
		Big.setBackground(new Color(102, 204, 153));
		Big.setEditable(false);
		Big.setText("    \n\n                                    \nYellow Snake (Compost):        + Fruits & Vegetables\n                                                +Tea bags\n Blue Snake (Recycling):        + Coffee cups \n                                    + Plastics #1-3 & 5-7\n                                    + Paper\n                                    + Cardboard\nGreen Snake (Returnables): + Juice boxes, tetra packs\n                                    + Bottles\n                                    + Cans\n                                    + Glass containers");
		Big.setBounds(38, 150, 423, 270);
		frame.getContentPane().add(Big);
		
		JTextArea small = new JTextArea();
		small.setFont(new Font("AppleGothic", Font.BOLD | Font.ITALIC, 13));
		small.setForeground(new Color(46, 204, 113));
		small.setText("\nIt is just a classic snake game !!!\nThe snake will change color representing which type of trash it wants\nMove the snake to the right type of trash using ¡ü¡ý¡û¡ú arrow keys\n\r");
		small.setEditable(false);
		small.setBounds(38, 55, 422, 90);
		frame.getContentPane().add(small);
		
		JButton btnNewButton = new JButton("Let's play");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Frame main = new Frame();
			}
		});
		btnNewButton.setBounds(380, 400, 91, 42);
		frame.getContentPane().add(btnNewButton);
	}
}

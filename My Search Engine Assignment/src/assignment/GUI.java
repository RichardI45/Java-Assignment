package assignment;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {

	public static void main(String[] args) {
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		JLabel label = new JLabel("Enter Word");
		label.setBounds(10,20,80,25);
		panel.add(label);
		
		JTextField userText = new JTextField(20);
		userText.setBounds(100,20,165,25);
		panel.add(userText);
		
		JButton button = new JButton("Search");
		button.setBounds(10,110,300,25);
		panel.add(button);
		
		frame.setVisible(true);
		
	}

}

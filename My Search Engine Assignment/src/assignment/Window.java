package assignment;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window extends JFrame{
	
	Window(){
	
	this.setTitle("My Search Engine");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(400,400);
	this.setLayout(new FlowLayout(FlowLayout.LEFT));
	
	JLabel label = new JLabel("Enter Word");
	label.setBounds(10,20,80,50);
	this.add(label);
	
	JTextField userText = new JTextField(20);
	userText.setBounds(100,20,165,50);
	this.add(userText);
	
	JButton button = new JButton("Search");
	button.setBounds(10,110,300,50);
	this.add(button);
	
	
	this.setVisible(true);
	}

}

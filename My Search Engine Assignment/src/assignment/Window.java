package assignment;




import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Window extends JFrame{
	
	
	
	Window(){
		
	
	
	this.setTitle("My Search Engine");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(400,400);
	this.setLayout(null);
	
	JPanel panel = new JPanel();
	this.add(panel);
	
	JLabel Title = new JLabel("Find Word");
	Title.setBounds(140,25,300,50);
	Title.setFont(new Font("Calibri",Font.BOLD,20));
	this.add(Title);
	
	JLabel label = new JLabel("Enter Word");
	label.setBounds(10,65,80,50);
	this.add(label);
	
	JTextField searchBox = new JTextField(20);
	searchBox.setBounds(100,80,165,25);
	this.add(searchBox);
	
	JButton searchButton = new JButton("Search");
	searchButton.setBounds(100,140,150,25);
	this.add(searchButton);
	
	JButton addFileButton = new JButton("Add File");
	addFileButton.setBounds(70,110,110,25);
	this.add(addFileButton);
	
	JButton clearFileButton = new JButton("Clear File");
	clearFileButton.setBounds(180,110,110,25);
	this.add(clearFileButton);
	
	
	
	this.setVisible(true);
	
	}
}
				
							
						
					
	



package assignment;




import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import assignment.InvertedIndex;
import assignment.Search;






public class Window extends JFrame{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6639714292448749672L;
	private InvertedIndex invertedIndex;
	JPanel panel = new JPanel();
	public Window(InvertedIndex invertedIndex) {
		this.invertedIndex = invertedIndex;
		Window();
		
	}
	
	
	
	
	
	private void Window(){
		
	
	/*setting up the GUI */
	this.setTitle("My Search Engine");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(500,700);
	this.setLayout(null);
	
	JPanel panel = new JPanel();
	this.add(panel);
	
	JLabel Title = new JLabel("Find Word");
	Title.setBounds(140,25,300,50);
	Title.setFont(new Font("Calibri",Font.BOLD,20));
	this.add(Title);
	
	JLabel label = new JLabel("Enter Word:");
	label.setBounds(15,65,80,50);
	this.add(label);
	
	JTextField searchBox = new JTextField(20);
	searchBox.setBounds(100,80,165,25);
	this.add(searchBox);
	
	JButton searchButton = new JButton("Search");
	searchButton.setBounds(70,140,110,25);
	this.add(searchButton);
	
	JButton addFileButton = new JButton("Add File");
	addFileButton.setBounds(70,110,110,25);
	this.add(addFileButton);
	
	JButton clearFileButton = new JButton("Clear File");
	clearFileButton.setBounds(180,110,110,25);
	this.add(clearFileButton);
	
	JTextArea ResultBox = new JTextArea();
	ResultBox.setEditable(false);
	ResultBox.setSize(150,150);
	ResultBox.setBounds(75,200,200,60);
	
	JLabel label3 = new JLabel("Results:");
	this.add(label3);
	label3.setBounds(75,150,200,60);
	
	JScrollPane scroll = new JScrollPane (ResultBox);
	
	this.add(ResultBox);
	this.add(scroll);
	
	JLabel label2 = new JLabel("Searching the Files:");
	JTextField fileBox = new JTextField(24);
	this.add(fileBox);
	fileBox.setBounds(75,300,200,60);
	fileBox.setEditable(false);
	this.add(label2);
	label2.setBounds(75,250,200,60);
	
	
	this.setVisible(true);
	
	
	searchButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			String wordArr[] = searchBox.getText().split(",");
			//Clear the text box.
			ResultBox.setText("");
			for(int index = 0; index < wordArr.length; index++){
				String word = wordArr[index].trim();
				Set<Search> results = invertedIndex.get(word);	
				if(results != null && !results.isEmpty()) {
					List<Search> list = new ArrayList<Search>(results);
					
					//Sort the text locations.
					Collections.sort(list, new Comparator<Search>() {
						public int compare(Search o1, Search o2) {
							int nameCompare = o1.getFilename().compareTo(o2.getFilename());
							if(nameCompare == 0){
								if(o1.getLineNumber() < o2.getLineNumber()){
									return -1;
								}else if(o1.getLineNumber() > o2.getLineNumber()){
									return 1;
								}else{
									return 0;
								}
							}else{
								return nameCompare;
							}
						}
					});
	

					//Handles the foundBox results. 
					
					String previous = "";
					for(int i = 0; i < list.size(); i++){
						Search search = list.get(i);
						if(i == 0){
							previous = search.getFilename();
							ResultBox.setText(ResultBox.getText()+word+" found in "+previous+"\n"+search.toString()+"\n");
						}else{
							String currentFileName = search.getFilename();
							if(previous.equals(currentFileName)){
								ResultBox.setText(ResultBox.getText()+search.toString()+"\n");
							}else{
								previous = currentFileName;
								ResultBox.setText(ResultBox.getText()+word+" found in "+previous+"\n"+search.toString()+"\n");
							}
						}
					}
				}else{
					//Clear the text box.
					ResultBox.setText(ResultBox.getText()+"None of the Files contain the text "+word+".\n");
				}
			}
		}
	});

	/*
	 * Adds a files or files to the list of files were searching a word in.
	 */
	addFileButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			JFileChooser fc = new JFileChooser();
			//Lets the user select multiple files.
			fc.setMultiSelectionEnabled(true);
			int returnVal = fc.showOpenDialog(Window.this);
			if (returnVal == JFileChooser.APPROVE_OPTION){
				File files[] = fc.getSelectedFiles();
				for(int i = 0; i < files.length; i++){
					File file = files[i];
					try{
						BufferedReader br = new BufferedReader(new FileReader(file));
						String filename = file.getName();
						String line = br.readLine();
						int lineNumber = 1;
						while(line != null){
							String arr[] = line.split(" ");
							for(int a = 0; a < arr.length; a++){
								String word = arr[a];
								Search search = new Search(filename, lineNumber, line);
								
							}
							lineNumber++;
							line = br.readLine();
						}
						//Update the searching the following files file box. 
						String currentText = fileBox.getText();
						if(currentText.length() != 0){
							fileBox.setText(currentText+", "+filename);
						}else{
							fileBox.setText(filename);
						}
					}catch(FileNotFoundException e){
						e.printStackTrace();
						
					} catch (IOException e) {
						e.printStackTrace();
						
					}
				}
			}

		}
	});

	/*
	 * Clears the invertedIndex and the loaded files.
	 */
	clearFileButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			//Clears the file box.
			fileBox.setText("");
			//Clears the invertedIndex.
			invertedIndex.clear();
			
			
		}
	});
	
	
	}
}
				
							
						
					
	



package assignment;

import java.util.Arrays;

public class Search  {
	
	/*
	 * filename -> Contains the name of the file.
	 * lineNumber -> This is the line number that this word this text location is mapped to was found on. 
	 * lineOfText -> Contains the line of text the word that this text location is mapped too is on. 
	 */
	private final String filename;
	private final int lineNumber;
	private final String lineOfText;
	
	public Search(String filename, int lineNumber, String lineOfText){
		this.filename = filename;
		this.lineNumber = lineNumber;
		this.lineOfText = lineOfText;
	}
	//Text locations are only equal if they are from the same file, on the same line, and have the same text. 
	@Override public boolean equals(Object o){
		if(o == this){
			return true;
		}
		if (!(o instanceof Search)){
			return false;
		}
		Search search = (Search) o;
		return search.filename.equals(filename) && search.lineNumber == lineNumber && search.lineOfText.equals(lineOfText);
	}
	
	
	@Override public int hashCode(){
		return Arrays.hashCode(new Object[] {
		        filename, lineNumber, lineOfText});
	}
	
	//Prints Line #: string. Example: Line 1: This is a test
	@Override public String toString(){
		return String.format("Line %d: %s", lineNumber, lineOfText);
	}
	
	public String getFilename(){
		return filename;
	}
	
	public int getLineNumber(){
		return lineNumber;
	}
	
	public String getLineOfText(){
		return lineOfText;
	}

}

package assignment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class InvertedIndex {
	
	private final HashMap<String, Set<Search>> invertedIndex;
	
	public InvertedIndex(){
		this.invertedIndex = new HashMap<String, Set<Search>>();
	}
	
	/*
	 * Adds a word and the location of that word in a file to the index.
	 */
	public void add(String word, Search search){
		//remove the word of periods, question marks, etc.
		word = word.replaceAll("\\W", "");
		//If the index doesn't have the word, add it. Otherwise update the set attached to the word.
		if(invertedIndex.containsKey(word)){
			Set<Search> set = invertedIndex.get(word);
			set.add(search);
			invertedIndex.put(word, set);
		}else{
			//Since its a set, there should never be any duplicate text locations.
			Set<Search> set = new HashSet<Search>();
			set.add(search);
			invertedIndex.put(word, set);
		}
	}
	
	/*
	 * Retrieves a set of text locations that contain the given word.
	 * If the word is not in the inverted index, returns null.
	 * These text locations are not in sorted order.
	 */
	public Set<Search> get(String word){
		return invertedIndex.get(word);
	}
	
	/*
	 * Prints out every word followed by a group of its text locations.
	 */
	@Override public String toString(){
		String printedString = "";
		Set<String> set = invertedIndex.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String word = it.next();
			Set<Search> searches = invertedIndex.get(word);
			Iterator<Search> it2 = searches.iterator();
			String locationText = "";
			while(it2.hasNext()){
				Search search = it2.next();
				if(it2.hasNext()){
					locationText += search.toString()+ ", ";
				}else{
					locationText += search.toString();
				}
			}
			
			printedString += String.format("\"%s\":    %s\n", word, locationText);
		}
		return printedString;
	}
	
	/*
	 * Clears the inverted index of all entries. The index will be empty after this call.
	 */
	public void clear(){
		invertedIndex.clear();
	}
}

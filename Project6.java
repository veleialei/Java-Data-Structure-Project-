import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 
 * @author  *********  YOUR NAME HERE *************** 
 *
 */

public class Project6 {
	
	/*
	 * ******************************** Part 1 ******************************
	 */
	/*
	 * DO NOT MODIFY THE NODE CLASS
	 */
	static class Node {
		Node(int data) {
			this.data = data;
		}
		int data;
		Node left;
		Node right;
	}	
	
	static void flip(Node root) {
		
		// ****************** Your code here **********************
		// if the root is null;
		if(root == null) {
    		return;
    	}
		// if there is no child
    	if((root.left == null) && (root.right == null)) {
    		return;
    	}
    	//swap
    	Node temp = root.left;
    	root.left = root.right;
    	root.right = temp;
    	//continue
    	flip(root.left);
    	flip(root.right);		
		
	}
	
	// preOrder to test
	static void preOrder(Node n) {
		if (n == null) return;
		System.out.println(n.data);
		preOrder(n.left);
		preOrder(n.right);		
		}
	
	/*
	 * ******************************** Part 2 ******************************
	 */
	
	static class MinMaxQueue {		
		// ****************** Your code here **********************
		// the basic container
		TreeMap<String,Integer> queue = new TreeMap<String, Integer>();
		// the size of the queue
		int size = 0;		
		//add function
		void push(String val) {
			// ****************** Your code here **********************
			//add the element
			queue.put(val,0);
			//increase the size
			size++;			
		}

		String popMin() {
			// ****************** Your code here **********************				
			//store the small one
			String min = queue.firstKey();
			//remove it
			queue.remove(min);
			size--;
			return min;
		}

		String popMax() {
			// ****************** Your code here **********************			
			//store the large one
			String max = queue.lastKey();
			//remove it
			queue.remove(max);
			return max;			
		}
		// return the size
		int size() {
			// ****************** Your code here **********************
			return size;
		}		
	}
	
	/*
	 * ******************************** Part 3 ******************************
	 */
	// experiment with this size to see how it affects efficiency
	private final int TABLE_SIZE = 26117;
	@SuppressWarnings("unchecked")
	private List<String>[] table = new LinkedList[TABLE_SIZE];
	
	/**
	 * Constructs a word matcher based on the given dictionary.
	 * 
	 * @param filename The dictionary file name
	 */
	public Project6(String filename) {
		
		// ****************** Your code here **********************
		// put the file into list
		List<String> wordfile = new ArrayList<String>();
		try (Scanner in = new Scanner(new File(filename))) {
			// if there exist new line write into file;
			while(in.hasNextLine()){
				String line = in.nextLine();
				wordfile.add(line.toLowerCase());
			}					
		}		
		catch (FileNotFoundException e) {
			e.printStackTrace();			
		}		
		
		//put into table		
		for(int i = 0; i<wordfile.size();i++){
			int index = hash(num(convert(wordfile.get(i))));
			if(index==TABLE_SIZE){
				index=0;
			}
			if(table[index]==null){
				table[index]=new LinkedList<String>();
			}
			table[index].add(wordfile.get(i));				
		}
		
	}
	
	
	// convert word into letter
	char[] convert(String word){
		//the container 
		char b[] = new char[word.length()];
		//change word into letters
		for(int i =0;i<word.length(); i++){
			b[i]=word.charAt(i);
		}
		//make sure they are in order so that different combination has the same letter array.
		Arrays.sort(b);
		return b;		
	}
	
	// find its hash number
	double num(char word[]) {
		//to contain the raw value
		double c = 0;
		//hash method
		for(int i =0;i<word.length; i++){
		if(word[i]=='\''){
			word[i]=96;
			}
		c=c*33+(word[i]-95);		
		}
		
		// make sure everything is long enough
		return c;		
		} 
	// find its hash number
		int hash(double c) {			
			double size = TABLE_SIZE;
			double result = c%size;		
			return (int) result;		
			}
	/**
	 * Return a list of dictionary words that have the same letters as the given word.
	 * Differences in letter cases are ignored.
	 * 
	 * @param word The word to find matches for. May or may not be in the dictionary.
	 * 
	 * @return The list of matching words from the dictionary, all in lower case.
	 * 		   The word itself is not included in the returned list.
	 * 		   e.g.: 	NAME -> [amen, mane, mean]
	 */
public List<String> getMatches(String word) {
		
		// ****************** Your code here **********************
		// make all lower case
		word=word.toLowerCase();
		//to store the real hash code
		double hashnum = num(convert(word));
		// make all lower case
		word=word.toLowerCase();
		// store the word matches
		List<String> matches = new LinkedList<String>();
		List<String> realmatches = new LinkedList<String>();
		//get the index
		int index = hash(hashnum);
		//get the list
		matches = table[index];			
		//compare the string hash code to avoid conflict in table
		for(int i =0; i<matches.size();i++){
			
			double hashnum2 = num(convert(matches.get(i)));
			//if the same add to the real matches
			if(hashnum==hashnum2){				
				realmatches.add(matches.get(i));
			}			
		}
		//remove the word from list
		realmatches.remove(word);
		//remove again in case there is any upper cases word repeat in the list
		realmatches.remove(word);
		return realmatches;
	}
	
	public static void main(String[] args) {
		
		/*
		 *    You can test your methods here but I will not grade the main
		 *    
		 *    Some part 3 tests below in case you find them useful.
		 */
				
		Project6 matcher = new Project6("words.txt");
		
		// test code for functionality
		String[] words = { "act", "hug", "cafe", "node", "canoe", "dusty",
				"friend", "silent", "meteor", "markers", "aStewSir",
				"dirtyRoom", "stampStore", "moonStarers", "theClassroom",
				"accordNotInIt"};
		for (String word : words) {
			System.out.println(word + " -> " + matcher.getMatches(word));
		}

		// Stress the application to ensure it runs efficiently under load.
		// All runs below should complete practically in an instant.
		final int RUNS = 100000;
		for (int i = 0; i <= RUNS; i++) {
			matcher.getMatches("noMoreStars");
			if (i % 1000 == 0) {
				System.out.print(".");
			}
		}
		System.out.println();
		System.out.println("noMoreStars" + " -> "
				+ matcher.getMatches("noMoreStars"));
		
	}
}
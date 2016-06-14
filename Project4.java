import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project4 {

	/**
	 * Read lines from the file and put each line into the list in reverse order
	 * 
	 * @param filename the filename
	 * @return A list containing the file contents in reverse order 
	 * (first line in file is last in list and last line in file is first in list)
	 */
	static ISimpleList<String> getFileContentsInReverse(String filename) {
		
		int size;
		// create a new list
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		// the reversed list
		SinglyLinkedList<String> list2 = new SinglyLinkedList<String>();
		//part 1
		//read the file
		try (Scanner in = new Scanner(new File(filename))) {
			// if there exist new line write into file;
			while(in.hasNextLine()){				
				list.add(in.nextLine());
			}					
		}		
		catch (FileNotFoundException e) {
			e.printStackTrace();		
		}		
		// get the size of list;
		size = list.size();		
		//part 2
		//reverser the list
		for(int i=0;i<size;i++){
			//add a element after the last element
			list2.add(list.get(size-i-1));
			//list.add(size,list.get(size-i-1));			
			//remove the last element
			//list.remove(size-i-1);
		}		
		return list2;
	}
	

	public static void main(String[] args) {
		// you can test your list and stack here but I will not grade this code 
		SinglyLinkedList<String> a = new SinglyLinkedList<String>();
		a.add("a");
		a.add("b");		
		a.add("c");
		a.add("d");
		a.add("c");
		System.out.println(a.remove("c"));
		System.out.println(a.get(0));
		System.out.println(a.get(1));
		System.out.println(a.size());
		
	}

}

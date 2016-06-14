/**
 * 
 * @author Shuangjiao Hu
 * @ID 1571979
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project3 {

	/**
	 * Read lines from the file and put each line into the list in reverse order
	 * 
	 * @param Shuangjiao Hu Project 3
	 * @return A list containing the file contents in reverse order 
	 * (first line in file is last in list and last line in file is first in list)
	 */
	
	static ISimpleList getFileContentsInReverse(String filename) {
		// to store the size of list
		int size;
		// create a new list
		ArrayBasedList list = new ArrayBasedList();
		// the reversed list
		ArrayBasedList list2 = new ArrayBasedList();
		// your code here should interact with the list using only the ISimpleList methods
		
		
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
		ArrayBasedList list = new ArrayBasedList();
		list.add("haha");
		list.add("heha");
		list.add("haha");
		list.add("hahe");
		System.out.println(list.remove("haha"));
		// you can test your list here but I will not grade this code 
	}
}

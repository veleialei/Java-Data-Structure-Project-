import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Iterator;


public class Project5 {

	/**
	 * Read students from file into a list
	 * 
	 * @param filename
	 * @return the list of students
	 */
	static ArrayList<Student> readFromFile(String filename) {
		ArrayList<Student> students = new ArrayList<Student>();
		try (Scanner in = new Scanner(new File(filename))) {
			while (in.hasNextLine()) {
				String[] fields = in.nextLine().split(",");
				students.add(new Student(Integer.parseInt(fields[1]), fields[0], fields[2]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return students;
	}

	/*
	 * ******************************** Part 1 ******************************
	 */
	
	/**
	 * Sorts the students list by school. Same school students are sorted by ID.
	 * 
	 * Performs two stable sorts with different criteria. One sort and then another sort.
	 * 
	 * @param students
	 */

	static void sortBySchoolById1(ArrayList<Student> students) {		
		//compare the name first
		Collections.sort(students,  new NameComparator());
		//compare the school second
		Collections.sort(students, new SchoolComparator());
	}
	//class for compare name
	 static class SchoolComparator implements Comparator<Student> {  
	        public int compare(Student student1, Student student2) { 
	            Student p1 = student1; 
	            Student p2 = student2; 	          
	            return p1.getSchool().compareTo(p2.getSchool());  
	        }  
	    }  
	//class for compare school
	 static class NameComparator implements Comparator<Student> {  
	        public int compare(Student student1, Student student2) { 
	            Student p1 = student1; 
	            Student p2 = student2; 	          
	            return p1.getName().compareTo(p2.getName());  
	        }  
	    }  

	/**
	 * Sorts the students list by school. Same school students are sorted by ID.
	 * 
	 * Performs only one sort that uses a comparator that takes both criteria
	 * into account.
	 * 
	 * @param students
	 */
	static void sortBySchoolById2(ArrayList<Student> students) {
		// compare both school and name
		Collections.sort(students, new AllComparator());
	}
	//class for compare school and name together
	static class AllComparator implements Comparator<Student> {  
        public int compare(Student student1, Student student2) { 
        	//two students for compare
            Student p1 = student1;  
            Student p2 = student2; 
            //result of school compare
            int s= p1.getSchool().compareTo(p2.getSchool());
            //result of name compare
            int n= p1.getName().compareTo(p2.getName()); 
            //we need to compare school first then name next
            if(s==0){
            	return n;
            }
            else
            	return s;
        }  
    } 
	
	/*
	 * ******************************** Part 2 ******************************
	 */
	/**
	 * Return all the first names which occur at least a given number of times
	 * 
	 * @param students
	 * @param threshold
	 * @return A list of first names (with no duplicates) occurring <threshold>
	 *         times or more in the student list
	 */

	static List<String> commonFirstNames(ArrayList<Student> students,
			int threshold) {
		//store all first name
		List<String> firstname=new ArrayList<String>();
		//store all frequent first name
		List<String> ffname=new ArrayList<String>();
		//get the first name array 
		for (int i = 0; i<students.size();i++){
			//select the first name from full name
			String[] name = students.get(i).getName().split(" ");
			//add into first name list
			firstname.add(i, name[0]);			
		}
		//store each name with no duplicates
        List<String> names = new ArrayList<String>();
        //store each names' appearance time
        List<Integer> times= new ArrayList<Integer>();
        //create two list of name and times related to each other
		for (int i = 0; i<firstname.size();i++){
			//test if contains that value
			//if have update the time
			if(names.contains(firstname.get(i))){
				int a =names.indexOf(firstname.get(i));
				times.set(a,times.get(a)+1);
			}
			//if not add the name and set time to 1
			else{
				names.add(firstname.get(i));
				times.add(1);
			}
		}
		//store all frequent name
		for(int j =0;j<names.size();j++){
			if(times.get(j)>=threshold){
				ffname.add(names.get(j));				
			}
		}
		return ffname;
	}
	
	public class nameArr{		
		int time=0;
		String fname;		
	}
	
	/*
	 * ******************************** Part 3 ******************************
	 */
	/**
	 * Return all the first names which occur at least a given number of times
	 * 
	 * @param students
	 * @param threshold
	 * @return A list of first names (with no duplicates) occurring <threshold>
	 *         times or more in the student list
	 */
	

	static List<String> commonFirstNames2(ArrayList<Student> students,
			int threshold) {
		//store all first name
		List<String> firstname=new ArrayList<String>();
		//store all frequent first name
		List<String> ffname=new ArrayList<String>();
		//get the first name array 
		for (int i = 0; i<students.size();i++){
			String[] name = students.get(i).getName().split(" ");				
			firstname.add(i, name[0]);			
		}
		//store name and its frequency;
		Map<String, Integer> nameMap = new TreeMap<String, Integer>();
		//put each name into tree map
		for(int i=0;i<firstname.size();i++){
			//if contains add the value
			if(nameMap.containsKey(firstname.get(i))){
				nameMap.put(firstname.get(i),nameMap.get(firstname.get(i))+1);
			}
			//else add it and set value to 1
			else{
				nameMap.put(firstname.get(i), 1);
			}
		}
		//use iterator to go through whole map
		//key iterator
		Iterator<String> ir1=nameMap.keySet().iterator();
		//value iterator
		Iterator<Integer> ir2=nameMap.values().iterator();
		while(ir1.hasNext()){
			int time=ir2.next();
			//if larger than threshold store it
			if(time>=threshold){
				ffname.add(ir1.next());
			}
			else{
				ir1.next();
			}
		}		
		return ffname;

	}
	public static void main(String[] args) {
		System.out.println(-12%5);
		/*
		 *    You can test your methods here but I will not grade the main
		 */
	}	
}
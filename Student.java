
public class Student implements Comparable<Student>{
	// create private variable
	private int id; 
	private String name; 
	private String school;
	Student(){		
	}
	//constructor
	Student(int _id, String _name, String _school){
		this.id = _id;
		this.name = _name;
		this.school = _school;
	}
	@Override

	public String toString(){
    // print name, id and school   
        return this.name + "," + this.id + "," + this.school + ", ";
    }
	
	@Override
    public boolean equals(Object obj) {
	// compare by id
		if (obj instanceof Student) {
			Student other = (Student) obj;
			 return (this.id==other.id);
			}
		return false;
    }
	
	@Override
	public int compareTo(Student obj) {
	// compare by id
		return this.id-obj.id;			
	}
	/*
	public static void main(String[] args) {
		Student A = new Student(123, "Alice", "Math");
		Student B = new Student(123, "Ben", "Math");
		Student C = new Student(223, "Ben2", "Math");
		System.out.println(A);
		System.out.println(A.equals(B));
		System.out.println(A.compareTo(C));	
	
      }
      */
}

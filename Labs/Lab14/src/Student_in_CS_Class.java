
public class Student_in_CS_Class {
	private String name;
	public Student_in_CS_Class(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString(){
		return("This CS student's name is "+name+".");
	}

}

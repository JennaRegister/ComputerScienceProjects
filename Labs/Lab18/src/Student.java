import java.util.Comparator;


public class Student {
	private String first;
	private String last;
	private int grad;
	public Student(String f, String l, int g){
		first=f;
		last=l;
		grad=g;
	}
	public String toString(){
		return("Name: " + first + " " + last + " // " + "Graduate year: " + grad);
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public int getGrad() {
		return grad;
	}
	public void setGrad(int grad) {
		this.grad = grad;
	}
	
		
	}

class Comp implements Comparator<Student>{
	public int compare(Student a, Student b){
		int n = a.getLast().compareTo(b.getLast());
		return n;
		}
}
class CompY implements Comparator<Student>{
	public int compare(Student a, Student b){
		if(a.getGrad()>b.getGrad()){
			return 1;
		}
		if(a.getGrad()<b.getGrad()){
			return -1;
		}
		return 0;
	}

}


	
	



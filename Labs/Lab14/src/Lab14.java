
public class Lab14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student_in_CS_Class [] s = new Student_in_CS_Class [10];
		s[0]= new Nerd("The dozen eggs joke","Jenny");
		s[1]= new Non_Nerd(27,"Nate");
		s[2]=new Lost("Daisy",34,true);
		s[3]=new Nerd_Plus( "the Einstein, Newton, and Pascal are playing Hide n' Seek... joke","Albert Winston V",true);
		s[4]=new Nerd("The Statistician goes hunting joke", "Tongxi");
		s[5]=new Non_Nerd(65,"Jackie");
		s[6]=new Lost("TJ",75,true);
		s[7]=new Nerd_Plus("'I'm So Meta Even This Acronym'","Sylvie",true);
		s[8]=new Student_in_CS_Class("Isabella Newton");
		s[9]=new Student_in_CS_Class("Alexandra Einstein");
		for(int i=0; i<s.length;i++){
			System.out.println(s[i]);
		}
		
		
		
		

	}

}

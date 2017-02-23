
public class TestHoneybee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//two instances (object) of Honeybee class
		Honeybee h1 , h2 ;
		
		//creating first instance
		h1 = new Honeybee();
		h1.beetype = "Worker" ; //setting beetype
		h1.distance = 35 ; //setting distance
		
		//creating second instance
		h2 = new Honeybee();
		h2.beetype = "Queen" ;
		h2.distance = 60 ;
		
		//displaying instances and their attributes
		System.out.println("This honeybee is a " + h1.beetype + " type, and the food is " + h1.distance + " yards from the hive.");
		if (h1.distance > 35)
			System.out.println("This bee will perform the Waggle dance.");
		else
			System.out.println("This bee will perform the Round dance.");
		System.out.println("This honeybee is a " + h2.beetype + " type, and the food is " + h2.distance + " yards from the hive.");
		if (h2.distance > 35)
			System.out.println("This bee will perform the Waggle dance.");
		else
			System.out.println("This bee will perform the Round dance.");
		//modifying object without setters
		h1.beetype = "Drone" ;
		h2.distance = 45 ;
		System.out.println("This honeybee is a " + h1.beetype + " type, and the food is " + h1.distance + " yards from the hive.");
		if (h1.distance > 35)
			System.out.println("This bee will perform the Waggle dance.");
		else
			System.out.println("This bee will perform the Round dance.");
		System.out.println("This honeybee is a " + h2.beetype + " type, and the food is " + h2.distance + " yards from the hive.");
		if (h2.distance > 35)
			System.out.println("This bee will perform the Waggle dance.");
		else
			System.out.println("This bee will perform the Round dance.");
	}

}

import java.io.File;
import java.util.ArrayList;


public class main {

	public static void main(String[] args) {
		//start the GUI where we input our filters
		//create the heap (read in file every time?)
		
		/*BRAINSTORMING
		 * GUI has different constraints: time, selective activities, mood(?), random
		 * We keep a file of anything we feel like doing. The file setup: Title of Activity, Type (book, physicalactivity), time (hours), Mood
		 * Parse it in the file and create a bunch of Activity objects to put in the heap
		 * Activity also has a rating of how much we want to do it (1-somevalue)
		 */
		ArrayList<String> types=new ArrayList<String>();
		types.add("reading");
		types.add("jenna's faves");
		ArrayList<String> moods=new ArrayList<String>();
		moods.add("thoughtful");
		moods.add("snuggly");
		
		Activity act=new Activity("Still Life With Woodpecker",types,2,moods,5);
		act.print();
	}
	
	
	public void readit(File file){
		
		
	}

}

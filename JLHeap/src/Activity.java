import java.util.ArrayList;


public class Activity {
	String title;
	ArrayList<String> types;
	int timetake;
	ArrayList<String> moods;
	int want;
	
	public Activity(String title, ArrayList<String> types, int timetake, ArrayList<String> moods,int want){
		this.title=title;
		this.types=types;
		this.timetake=timetake;
		this.moods=moods;
		this.want=want;
	}
	
	public void addmood(String m){
		moods.add(m);
	}
	public void addtype(String t){
		types.add(t);
	}
	public void print(){
		System.out.print("Activity:  [" + title + "]  Types: ");
		for(int i=0;i<types.size();i++){
			System.out.print(types.get(i)+" ");
		}
		System.out.print("  Time: " + timetake + " hours  Moods: ");
		for(int i=0;i<moods.size();i++){
			System.out.print(moods.get(i)+" ");
		}
		
	}

}

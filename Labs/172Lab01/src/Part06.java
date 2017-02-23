import java.util.Comparator;


public class Part06 {

	public static <AnyType>
	AnyType getMax(AnyType [] a, Comparator<? super AnyType> cmp){
		int max=0;
		for(int n =1; n<a.length; n++){
			if(cmp.compare(a[n],a[max])>0){
				max=n;
			}
		}
		return a[max];
			
	}
	public static class CharacterCompare implements Comparator<Character>{
		public int compare(Character lhs, Character rhs){
			return lhs.compareTo(rhs);
		}
	}
	
	public static void main( String [] args){
		Character [] arr = {'d','r','t','f','s','l','t'};
		System.out.println(getMax(arr,new CharacterCompare()));
			
			}
	}
	

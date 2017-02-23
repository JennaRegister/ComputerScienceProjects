import javax.swing.JOptionPane;
public class Lab10 {
	public static void main(String [] args){
		String n= JOptionPane.showInputDialog("Please enter an integer.");
		int N= Integer.parseInt(n);
		int[] arr = Rand(5,N);
		int []arr2 = Rand(7,N);
		Printarr(arr);
		Printarr(arr2);
		int[] copied=CopyCat(arr);
		Printarr(copied);
		int minimum =Min(arr);
		int maximum =Max(arr);
		System.out.println("The minimum is: "+ minimum +"\nThe maximum is: "+ maximum);
		
		
		
	}
	public static int[] Rand(int k,int n){
		int [] randarr = new int[k];
		for(int i=0;i<randarr.length;i++){
			randarr[i]= (int) Math.floor(Math.random()*n);
		}
		return randarr;
	}
	public static void Printarr(int[]a){
		for(int z=0;z<a.length;z++){
			System.out.print(a[z]+" ");	
		}
		System.out.println("\n");
	}
	public static int[] CopyCat(int[]m){
		int[] copy = new int[m.length];
		int j =0;
		while (j<m.length){
			copy[j] = m[j];
			j++;
		}
		return copy;
		
	}
	public static int Min(int[]array){
		int min = array[0];
		for(int g=0;g<array.length;g++){
			if(array[g]<min){
				min = array[g];
			}
		}
		return min;
		
	}
	public static int Max(int[]array){
		int max = array[0];
		for(int g=0;g<array.length;g++){
			if(array[g]>max){
				max = array[g];
			}
		}
		return max;
		
	}
	

}

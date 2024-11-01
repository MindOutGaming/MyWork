
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		int [] arr = new int[5];
		Scanner obj = new Scanner(System.in);
		int i;
		for(i=0;i<arr.length;i++){
			System.out.println("enter a number");
			arr[i]= obj.nextInt();
			}
		
	System.out.println("output\n");
		for(i=0;i<arr.length;i++)
		//for(int a:arr)//
		{
			System.out.println(arr[i]);
			}	
		
		System.out.println("enter a index of array 1 to 5 ");
		int num = obj.nextInt();
		try {
			System.out.println("value is "+arr[num]);
			}
		catch(Exception e){
			
			System.out.println("Error\n"+e);
			}
	}
}
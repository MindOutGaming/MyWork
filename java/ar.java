import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	
		System.out.print("enter length of array:");
		int n = sc.nextInt();
			int arr[] = new int[n];
		for(int i=0;i<=n-1;i++){
			System.out.print(i+"="); 
			 arr[i] = sc.nextInt();
			}
		
		System.out.println("your array is:");
		
			for(int i=0;i<=n-1;i++){
				System.out.println(arr[i]);
				}
				System.out.println("sorting");
			Arrays.sort(arr);
			for(int b:arr){
			System.out.println(b);	
				}
        System.out.println("second biger: "+arr[n-2]);
	

			

	}
}
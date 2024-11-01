import java.util.Scanner;
public class practice1 {
	public static void main(String[] args) {
		//1231 o/p = 6//
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number:\n");
		int num = sc.nextInt();
		int length = String.valueOf(num).length();
		System.out.println("length: "+length);
		int i;
		for(i=0;i<length;i++){
		num = num%10;
			System.out.println(num);
		}
		
	}
}

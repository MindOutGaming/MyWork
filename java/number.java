import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter your phone number:");
		String num = sc.nextLine();
if(num.length()>10 || num.length()<10){
	
	System.out.println("phone number is invalid!");
	}
	else{
		
	System.out.println("your phone number is : "+num);	
		}		
	}
}
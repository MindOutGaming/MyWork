import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans;
		System.out.println("enter a first number:");
		int num1 = sc.nextInt();
		System.out.println("enter a second number:");
		int num2 = sc.nextInt();
		System.out.println("\t\t\t\t**** mainu ****");
				
				for(int i=0;i<=2;i++){
				System.out.println("\n1.addition\n2.subtraction\n3.multipletion\n4.divition\n5.exit");
				System.out.print("choose your oparation:-  ");
				int ch = sc.nextInt();
				
					switch(ch){
					case 1:{
						ans=num1+num2;
						System.out.println("addition is: "+ans);
						}
					break;
						case 2:{
						ans=num1-num2;
						System.out.println("subtraction is: "+ans);
						}
					break;
						case 3:{
						ans=num1*num2;
						System.out.println("multiplection is: "+ans);
						}
					break;
						case 4:{
						ans=num1/num2;
						System.out.println("divition is: "+ans);
						}
					break;
					case 5:{
						System.out.println("exit program!");
						return;
						}
					
					default:{
						System.out.println("choose right opation!");	
						}
					
					}
					
				}	
					
					
				}
	}

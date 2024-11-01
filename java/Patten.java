public class Main {
	public static void main(String[] args) {
	//right space//
			for(int i =0;i<10;i++){
			for(int j=0;j<i;j++){
				System.out.print("*");
				}
				System.out.println(" ");
			}
			//left space//
		System.out.println("\t\t\t\t*****");
		
			for(int i =0;i<10;i++){
				for(int k=10-i;k>=1;k--){
					System.out.print(" ");
					}
			for(int j=0;j<i;j++){
				System.out.print("*");
				}
				System.out.println("");
			}
		System.out.println("\t\t\t\t*****");
		//piramit//
			System.out.println("\t\t\t\t*****");
		
			for(int i =0;i<10;i++){
				for(int k=10-i;k>=1;k--){
					System.out.print(" ");
					}
			for(int j=0;j<i;j++){
				System.out.print(" *");
				}
				System.out.println("");
			}
		System.out.println("\t\t\t\t*****");
		
		
		
	}
}
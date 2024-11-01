import java.util.Scanner;
public class one{
	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		int count[] = new int[5];
		String[] bad = new String[5];
		System.out.println("Enter 5 bad Words to not allowed: ");
		for(int i=0;i<bad.length;i++){
			System.out.print(i+1+":");
			bad[i] = obj.next();
		}
		System.out.println("\nEnter a your String: ");
		obj.next();
		String str = obj.nextLine();
		String[] str1 = str.split(" ");
		for (int i = 0; i < bad.length ; i++) {
            for (int j = 0; j < str1.length ; j++) {
                if (bad[i].equals(str1[j])) {
                    count[i]++;
                }
            }
        }
		System.out.println("\nbad Words is : ");
        for (int i = 0; i < 5; i++) {
            System.out.println(bad[i] + " = " + count[i]);
        }
	}
}

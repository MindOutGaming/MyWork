import java.util.Scanner;
public class six{
	public static void main(String[] args) {
        int sum=0;
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter number with pluse simbol : ");
        String str = obj.nextLine();
        String[] str1 = str.split("[+]");
        int[] num = new int[str1.length];
        for (int i = 0; i < str1.length; i++) {
            num[i] = Integer.parseInt(str1[i]);
        }
        for(Integer n: num){
            sum = sum + n;
        }
        System.out.println("The Sum is : "+sum);
	}
}

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		int sub1, sub2, sub3, tol;
		float per;
		Scanner obj = new Scanner(System.in);
		//input of tree subject//
		System.out.println("enter a subject 1 mark\n");
		sub1 = obj.nextInt();
		System.out.println("enter a subject 2 mark\n");
		sub2 = obj.nextInt();
		System.out.println("enter a subject 3 mark\n");
		sub3 = obj.nextInt();
		//addition of value//
		tol = sub1 + sub2 + sub3;
		System.out.println("addition of tree subject mark: " + tol);
		//percentage count//
		per = (tol /100f) * 3;
		System.out.println("percentage of tree subject mark: " + per);
	}
}
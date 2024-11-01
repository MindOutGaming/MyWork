import java.io.File;
import java.util.Scanner;
public class FileHedaling {
	public static void main(String[] args) {

		Scanner obj = new Scanner(System.in);
		System.out.println("enter a file path:\n");
		String path = obj.nextLine();
		File file = new File(path);
		if (file.exists()) {
			System.out.println("path is correct");
			if (file.isDirectory()) {
				System.out.println("file is folder");
				String[] arr = file.list();
				for (String a : arr) {
					System.out.println(a);
				}
			} else {
				System.out.println("file is not a folder");
			}


		} else {
			System.out.println("path is not correct");
		}
	}
}
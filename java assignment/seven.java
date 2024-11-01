import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

public class seven{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Path:");
        String path = sc.nextLine();
        File f = new File(path);
        listDir(f);
	}
	public static void listDir(File f){
		 if(f.exists()){
            System.out.println("File Exist");
            if(f.isDirectory()){
                System.out.println("This is Directory.");
                String[] files = f.list();
                for(String file : files){
                    System.out.println(file);
                }
                listDir(f.getAbsoluteFile());
            }
            else{
                System.out.println("Is File.");
                try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                 String s = br.readLine();
                  System.out.println(s);
                  
                } catch (FileNotFoundException e) {
                    System.out.println("error");
                
                }  catch (IOException e) {
                    
                    System.out.println("error");
                
                }           
            }
        }
        else{
            System.out.println("file Doesnt Exist");
        }
	}
}
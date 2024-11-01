import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class my{
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        System.out.println("enter a path \n");
        String str = obj.nextLine();
        File file = new File(str);
     if(file.exists()){
        System.out.println("path is available");
        try{ 
        FileReader fread = new FileReader(file);
        BufferedReader br= new BufferedReader(fread);
        try {
            String s = br.readLine();
            System.out.println(s);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        }catch(FileNotFoundException e){
           System.out.println("not found");    
        }
       if(file.isDirectory()){
        System.out.println("folder is available");
        String[] jj = file.list();
        for(String i: jj){
            System.out.println(i);
        }
        
        
       }
       else{
        System.out.println("folder is not found");
       }
     }
    else{
        System.out.println("path is not found");
    }

    }
}


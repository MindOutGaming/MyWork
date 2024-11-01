import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;
class eight{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Path : ");
        String path = sc.nextLine();
        File file = new File(path);
        if (file.isDirectory()){
            System.out.println("This is Directory");
        } else{
            String fileName = file.getName();
            String[] elements = fileName.split("\\.");
         
            
            try{
                    if(elements[1].equals("txt")){
                        System.out.println("This is Text File ");
                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);
                        String str = br.readLine();
                        System.out.println(str);
                    
                    }
                
                    else{
                       InvalidFileTypeException ex = new InvalidFileTypeException();
                    
                        throw ex;
                    }
              
            } catch(InvalidFileTypeException e){
                System.out.println("Invalid File Type.");
                System.out.println("The file type is "+elements[1]);
            } catch(Exception e){
               
            }
        } 
    }
}

class InvalidFileTypeException extends Exception{
    String message;
    
    public InvalidFileTypeException(){
        message = "This is not Prefered File Type";
    }
    public InvalidFileTypeException(String msg){
        message = msg;
    }
} 

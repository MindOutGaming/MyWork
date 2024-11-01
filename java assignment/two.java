import java.util.Scanner;
public class two{
  public static void main (String[] args) {
    Scanner obj = new Scanner(System.in);
    System.out.println("enter your string");
    String str = obj.nextLine();
    int count[] = new int[256];
    int max = str.length();
    int i;
    for (i=0;i<max;i++){
      count[(int)str.charAt(i)]++;
    }
    for (i=0;i<256;i++){
      if (count[i]!=0){
        System.out.println((char)i+"="+count[i]);
      } 
    } 
  }
}

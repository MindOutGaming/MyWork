import java.util.Scanner;
public class four{
  public static void main (String[] args) {
    Scanner obj = new Scanner(System.in);
    System.out.println("enter a number1");
    int n1 = obj.nextInt();
    System.out.println("enter a number2");
        int n2 = obj.nextInt();
        int i,j,sum=0;
        for (i=n1;i<=n2;i++){
          for(j=1;j<=i/2;j++){
            if (i%j==0){
              sum =sum + j;
            } 
          }
          if (sum==i){
            System.out.println("prime is"+i);
          } 
        } 
  }
}

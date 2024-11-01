import java.util.Scanner;
import java.util.LinkedHashSet;
 public class three{
  public static void main (String[] args) {
    int num,sum=0;
    Scanner obj = new Scanner(System.in);
    System.out.println("enter your number:\n");
    num = obj.nextInt();
    LinkedHashSet<Integer>set = new LinkedHashSet<Integer>();
    String str = Integer.toString(num);
    int[] nums = new int[str.length()];
    for(int i=0;i<str.length();i++){
      nums[i] = str.charAt(i)-'0';
    }
    for(int i=0;i<nums.length;i++){
      set.add(nums[i]);
    }
    for(Integer s:set){
      sum=sum+s;
    }
    System.out.println("addition is:"+sum);
    
  }
}
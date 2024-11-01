
public class Main {
	public static void main(String[] args) {
		String str = "25+25";
		System.out.println(str);
		int sum=0;
		String[] arr = str.split("[+]");
		int[] num= new int[arr.length];
		for(int i=0;i<arr.length;i++){
			
			 num[i] = Integer.parseInt(arr[i]);
			}
		
		for(int a:num){
			sum=sum+a;
		}
			System.out.println("addition is: "+sum);
			
		
	}
} "+sum);
			
		
	}
}
import java.util.*;
public class Main {
	public static void main(String[] args) {
		String n= "1213";
		int sum=0;
		String str[] = n.split("");
		 int a[]=new int[str.length];
		 for(int i=0;i<str.length;i++){
		 	
		 	a[i]=Integer.parseInt(str[i]);
		 	}
		Set<Integer>set = new HashSet<>();
		for(int i=0;i<str.length;i++){
			set.add(a[i]);
			}
		for(int j: set){
			 sum = sum+j;
			}
		System.out.println(sum);
	}
}	}
}
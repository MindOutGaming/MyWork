
import java.util.*;
public class hashset {
	public static void main(String[] args) {
			System.out.println("exmple of hashset:\n");
		Set<String>set = new HashSet<>();
		set.add("bhavesh");
		set.add("pavan");
		set.add("bhavesh");
		set.add("kuldeep");
		set.add("nakul");
		for (String a : set) {
			System.out.println(a);
		}
		System.out.println("exmple of hashmap:\n");
        Map<Integer,String>map=new HashMap<>();
        map.put(1,"bhavesh");
         map.put(2,"pavan");
          map.put(3,"nakul");
           map.put(4,"niraj");
            map.put(5,"kuldeep");
            
            Set<Integer> key = map.keySet();
            for(int b:key){
         System.out.println("key's "+b+" value is :"+map.get(b));
            }
	}
}
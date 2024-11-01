public class Main {
	public static void main(String[] args) {

		String str = "   bhavesh";
		System.out.println(str);

		int a = str.length();
		System.out.println(a);
		
		System.out.println(str.toUpperCase());
	System.out.println(str.toLowerCase());

		System.out.println(str.trim());
		
	System.out.println(str.substring(5, 10));

		System.out.println(str.replace('h', 'H'));

		System.out.println(str.startsWith("b"));
		System.out.println(str.endsWith("h"));

		System.out.println(str.charAt(4));

		System.out.println(str.indexOf("b"));

System.out.println(str.equals("   bhavesh"));

System.out.println(str.equalsIgnoreCase("   BHAVESH"));

	}
}
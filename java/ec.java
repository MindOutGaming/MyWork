
class myex extends Exception {
	public String toString() {

		return "number must be geter then zero";
	}
	public String getMessage() {
		return "ok";
	}
}
public class bhavesh {
	public static void main(String[] args) {
		int a = 10;
		int b = 8;
		if (b <= 0 || a <= 0) {
			try {

				throw new myex();
			} catch (Exception m) {
				System.out.println(m.toString());
				System.out.println(m.getMessage());
				System.out.println(m);

			}
		} else {

			int c = a + b;
			System.out.println("addition is : "+c);
		}
	}
}
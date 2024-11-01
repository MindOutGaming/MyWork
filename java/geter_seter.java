
class details {
	private int id;
	private String name;
	public void setId(int a) {
		id = a;
	}
	public int getId() {
		return id;
	}

	public void setName(String b) {
		name = b;
	}
	public String getName() {
		return name;
	}
}


public class Main {
	public static void main(String[] args) {
		details d = new details();
		d.setId(1);
		System.out.println(d.getId());
		d.setName("bhavesh");
		System.out.println(d.getName());


	}
}
		
	}
}
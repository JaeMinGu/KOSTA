
public class Bicycle /* extends Object */ {
	int id;
	String brand;

	public Bicycle() {
		//super();
		this(0, null);

	}

	public Bicycle(int id, String brand) {
		//super();
		this.id = id;
		this.brand = brand;
	}
	
	public void running() {
		System.out.println("자전거가 달립니다..");
	}

}

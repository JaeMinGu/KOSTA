
public class Foo {
	private int val;

	public Foo(int val) {
		this.val = val;
	}

	public static void main(String[] args) {
		Foo a = new Foo(10);
		Foo b = new Foo(10);
		Foo c = a;
		int d = 10;
		double e = 10.0;

		System.out.println(a == c); // true
		System.out.println(d == e); // true

		System.out.println(10 == 10.0); // true
		
		
	}
}

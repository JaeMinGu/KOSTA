
public class Circle extends Shape {
	private double radian;

	public Circle() {
		this(0.0, 0.0, 0.0);
	}

	public Circle(double x, double y, double radian) {
		this.x = x;
		this.y = y;
		this.radian = radian;
	}

	public double getRadian() {
		return radian;
	}

	public void setRadian(double radian) {
		this.radian = radian;
	}

	@Override
	public void draw() {
		System.out.println(x + ", " + y + ", " + getRadian() + "의 원입니다.");

	}

	@Override
	public double getLength() {
		return 2 * Math.PI * getRadian();
	}

	@Override
	public double getArea() {
//		return Math.PI * getRadian() * getRadian();
		return Math.PI * Math.pow(getRadian(), 2);
	}

	@Override
	public String toString() {
		return "Circle [radian=" + radian + ", getX()=" + x + ", getY()=" + y + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}

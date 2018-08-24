
public class ShapeApp {

	public static void main(String[] args) {
//		Shape shape = new Shape(12.5, 34.7);
		Shape shape = null;
		shape.draw();

		Circle circle = new Circle(15.0, 15.0, 30.0);
		circle.draw();
		System.out.println("원의 둘레: " + circle.getLength());
		System.out.println("원의 면적: " + circle.getArea());

		System.out.println(shape); // 아무 의미 없음(shape@16진수) --> Shape.java에서 toString 오버라이딩 
		System.out.println(shape.toString()); // 위와 같은 값 나옴 
		
		String str = "Java Programming";
		System.out.println(str); // String클래스에서 overriding 했기 때문에 String@16진수로 출력되지 않고 Java Programming으로 출력됨
		
		System.out.println(circle);
	}

}

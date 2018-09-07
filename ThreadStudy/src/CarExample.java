
public class CarExample {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("메인쓰레드에 의해 프로그램 시작됨......");

		Car car = new Car("방그리");
		Car car2 = new Car("홍길동");
		Car car3 = new Car("박지성");
		
		car.join();
		car2.join();
		car3.join();

		// car.run();
		car.start(); // 독립적으로 실행됨, 메인메소드 끝나도 본 쓰레드는 끝나지 않았을 수도 있음.
		car2.start();
		car3.start();

		System.out.println("메인쓰레드에 의해 프로그램 종료됨......");

	}

}

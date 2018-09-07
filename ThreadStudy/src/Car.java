import java.util.Random;

public class Car extends Thread {
// 쓰레드마다 이름 부여할 수 있음, name이란 속성 존재함 
//	String name; // thread name 오버라이딩한 것 

	public Car(String name) {
//		this.name = name;
//		super(name);
		setName(name);
	}

	public void run() { // 엔트리포인트
		Random random = new Random(); 
		System.out.println(getName() + "자동차 Start....");
		for (int i = 0; i <= 100; i++) {
			System.out.println(getName() + "자동차 " + i + "미터 전진");
			try {
				Thread.sleep(random.nextInt(100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(getName() + "자동차 Finish");
	}
}

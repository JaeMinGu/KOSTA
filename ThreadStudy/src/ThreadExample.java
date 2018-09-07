
public class ThreadExample {

	public static void main(String[] args) {
		System.out.println("프로그램 시작");

		for (int i = 0; i < 100; i++) {
			System.out.println("메인스레드에서 i값 출력 : " + i);
			if (i == 50) {
				new Thread() {
					@Override
					public void run() {
						for (int i = 0; i < 50; i++) {
							System.out.println("사용자 Thread i : " + i);
						}
					}
				}.start();

			}
		}

		System.out.println("프로그램 종료");
	}
}

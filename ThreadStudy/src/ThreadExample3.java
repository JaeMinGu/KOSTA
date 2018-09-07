
public class ThreadExample3 {

	static class MyThread extends Thread {
		public MyThread(String name) {
			setName(name);
		}

		@Override
		public void run() {
			System.out.println(getName() + " Thread 시작.....");
			for (int i = 0; i < 2000000000; i++) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(getName() + " Thread 종료.....");
			
		}
	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()); 
		
		System.out.println("프로그램 시작");

		MyThread t1 = new MyThread("방그리");
		t1.setPriority(Thread.MAX_PRIORITY);
		MyThread t2 = new MyThread("소연이");
		t2.setPriority(Thread.MIN_PRIORITY);

		t1.start();
		t2.start();

		System.out.println("프로그램 종료");
	}
}

public class Foo {

	public void someMethod() {
//		String message = null;
//		System.out.println(message.length()); // Exception 발생 지점 (JVM에 의해 new NullPointerException 생성)

//		System.out.println(10 / 0);
		int[] array = { 1, 2, 3 };
		System.out.println(array[3]); // Exception 발생 지점 (JVM에 의해 new ArrayIndexOutOfBoundsException 생성)
	}

	// 예외 직접처리 try-catch
	public void someMethod2() {

		try {
			String message = null;
			System.out.println(message.length());
//			System.out.println(10 / 0);
//			int[] array = { 1, 2, 3 };
//			System.out.println(array[3]);
		} catch (NullPointerException e) {
			System.out.println("인스턴스 생성 안됐음");
			System.out.println(e.getMessage());
//			e.printStackTrace();
			return; // return 있어도 finally는 항상 실행됨
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("예외 발생 여부와 상관 없이 항상 실행되는 코드");
		}

	}

	// 예외 간접처리 throws
	public void someMethod3() throws NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException {
		String message = null;
		System.out.println(message.length()); // Exception 발생 지점 (JVM에 의해 new NullPointerException 생성)

		System.out.println(10 / 0); // Exception 발생 지점 (JVM에 의해 new ArithmeticException 생성)
		int[] array = { 1, 2, 3 };
		System.out.println(array[3]); // Exception 발생 지점 (JVM에 의해 new ArrayIndexOutOfBoundsException 생성)
	}

	public static void main(String[] args) {

		System.out.println("JVM에 의해 프로그램 시작됨...");
		Foo foo = new Foo();

//		foo.someMethod();
//		foo.someMethod2();
		try {
			foo.someMethod3();
		} catch (Exception e) {
			System.out.println("메인에서 모든 예외 처리 완료");
		}

		System.out.println("프로그램 종료됨...");

	}
}

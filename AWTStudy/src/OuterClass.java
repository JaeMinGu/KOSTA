public class OuterClass {

	enum Direction {
		A, B, C
	}

	class InnerClass { // 외부에서 접근하고 싶을 때 OuterClass를 먼저 생성해야 함
		public void foo() {
			System.out.println("foo 호출됨...");
		}
	}

	// static 내부 클래스
	static class SInnerClass {
		public void bar() {
			System.out.println("bar 호출됨...");
		}
	}
}

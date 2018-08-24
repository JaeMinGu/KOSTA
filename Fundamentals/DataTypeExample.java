/**
 * 자바 데이터유형 테스트 
 */

class DataTypeExample {
	public static void main(String[] args)	{
		//boolean
		boolean flag = true; //false 		
		//boolean flag2 = 10; //컴파일 에러 
		System.out.println(flag);


		//char
		char x = '\uD55C'; //한
		char y = '\uAE00'; //글
		
		System.out.println(x);
		System.out.println(y);


		//특수문자(제어 문자, 에스케이프 문자)
		System.out.println("최\b재민 \n학생\t입니다.");
		System.out.println("\"자바\"가 좋아요");
		

		//byte, short, int, long 
		long money = 50000000L; 
		System.out.println(money);
		System.out.print("원숭이");
		System.out.printf("%d", 100);

		//float, double
		float pi = 3.141592F; 
		double pi2 = 3.141592;
		
		//연산자 overLoading
		String info = "\n바나나" + 30 + 10;
		System.out.println(info);
	}
}

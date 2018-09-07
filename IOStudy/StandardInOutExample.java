import java.io.IOException;

public class StandardInOutExample {

	public static void main(String[] args) throws IOException {

//		System.out.println(System.in); // toString 반환 
//		System.out.println(System.out);

		/* 이름 입력받기 */
		System.out.print("당신의 이름 : ");

		byte[] buffer = new byte[100];
		int count = System.in.read(buffer);

		// 문자 디코딩 처리
		String name = new String(buffer, 0, count - 2); // 엔터값 포함하기 때문에 count-2 해줘야 한다.
		System.out.println("당신의 입력 이름은 " + name + "입니다.");

		/* 나이 입력받기 */
		System.out.println("당신의 나이 : ");

		count = System.in.read(buffer);
		String age = new String(buffer, 0, count - 2);

//		System.out.println(Integer.parseInt(age)+10);

		int yourAge = Integer.parseInt(age);
		System.out.println("당신의 나이는 " + yourAge + "입니다.");

	}

}

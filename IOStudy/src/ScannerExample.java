import java.io.IOException;
import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) throws IOException {

		/* 이름 입력받기 */
		System.out.print("당신의 이름 : ");

		Scanner sc = new Scanner(System.in);
		System.out.println(sc.nextLine());

		/* 나이 입력받기 */
		System.out.print("당신의 나이 : ");
		System.out.println(sc.nextInt());



	}

}

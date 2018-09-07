import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BridgeStreamExample {

	public static void main(String[] args) throws IOException {

		/* 이름 입력받기 */
		System.out.print("당신의 이름 : ");

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String name = br.readLine();
		System.out.println(name);
		
		// Scanner 사용 
		System.out.print("당신의 이름2 : ");
		Scanner sc = new Scanner(System.in);
		String name2 = sc.nextLine(); 
		System.out.println(name2);
	}

}

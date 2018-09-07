import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.omg.CORBA.portable.InputStream;

public class InputStreamExample {

	static final String path = "C:/KOSTA187/설치프로그램/epp500_0651_64bit.exe";

	public static void main(String[] args) {
		java.io.InputStream in = null; 
		try {
			in = new FileInputStream(path);
			System.out.println(in.available()); // 몇 개의 바이트 수가 들어있는지 확인

//			int b = in.read(); // 첫 번째 데이터 반환, 한 바이트 읽어들임 
//			System.out.println(b); // 77에 해당하는 이진코드가 저장되어 있음, 읽어들일 게 없으면 -1 반환함 

			int b = 0;
			while ((b = in.read()) != -1) { // -1이 아니면 읽어들일 게 있다는 뜻
//				System.out.println(b); // 과제 제출 시 debuging을 위함 코드는 지우고 제출할 것 
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

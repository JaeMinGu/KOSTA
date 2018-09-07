import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JOptionPane;


public class InputStreamExample2 {

	static final String path = "C:/KOSTA187/설치프로그램/epp500_0651_64bit.exe";

	public static void main(String[] args) {
		InputStream in = null;
		File file = new File(path); 
		if(!(file.exists())){
			JOptionPane.showMessageDialog(null, "파일이 존재하지 않습니다.");
			return;
		}
		
		
		try {
			in = new FileInputStream(path);
			System.out.println(in.available()); // 읽어들일 수 있는 바이트의 수, 나중에 읽어들일 게 없으면 0이 됨 

//			int b = in.read(); // 첫 번째 데이터 반환, 한 바이트 읽어들임 
//			System.out.println(b); // 77에 해당하는 이진코드가 저장되어 있음, 읽어들일 게 없으면 -1 반환함 

			// byte[](버퍼) 단위로 입력
			byte[] buffer = new byte[4 * 1024]; // 4키로바이트 주로 사용, 한 번에 4키로 바이트 읽음
//			int count = in.read(buffer); // 읽어들인 바이트 수

			/*
			 * System.out.println(count); for (byte b : buffer) { System.out.println(b); }
			 */
			int count = 0;
//			int totalCount = 0;
			while ((count = in.read(buffer)) != -1) { // -1의 의미 : 아무것도 없다는 의미, 3번째부터 buffer의 사이즈만큼
				System.out.println(count);
//				totalCount += count;
			}
			
			
			System.out.println(in.available()); // 파일 모두 다 읽었기 때문에 0이 출력됨
			System.out.println(file.length() + " 바이트 파일 다 읽었음");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

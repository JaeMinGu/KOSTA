package character;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {

	public static void main(String[] args) throws IOException {
		String path = "example5.txt"; //상대경로 
		
		String message = "배고파.........."; 
		FileWriter out = new FileWriter(path);
		
		// 참고
//		char[] chars = new char[100];
//		message.getChars(0, message.length(), chars, 0);
//		out.write(chars);
//		out.close();
		
		// 실제로 자주 활용 - 인코딩 기능 추가되어 있음 
		BufferedWriter bw = new BufferedWriter(out);
		bw.write(message);
		bw.close();
		
		
	}
}
package character;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {

	public static void main(String[] args) throws IOException {
		String path = "src/BufferedInputStreamExample.java";

		// 기본
		FileReader in = new FileReader(path);
//		System.out.println((char)in.read()); 

		/*
		 * char[] buffer = new char[1024]; int count = 0; while ((count =
		 * in.read(buffer)) != -1) { for (char c : buffer) { System.out.print(c); } }
		 */

		// 좀 더 편하게 - 가장 많이 사용 
		BufferedReader br = new BufferedReader(in);
//		String txt = br.readLine();
//		System.out.println(txt);

		String txt = null;
		while ((txt = br.readLine()) != null) {
			System.out.println(txt);
		}
		
		

	}
}
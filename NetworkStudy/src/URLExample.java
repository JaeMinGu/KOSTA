import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

public class URLExample {

	public static void main(String[] args) {
		String urlString = "https://news.naver.com/main/read.nhn?mode=LPOD&mid=sec&oid=015&aid=0004007455";
		try {
			URL url = new URL(urlString);
//			System.out.println(url.getProtocol());
//			System.out.println(url.getHost());

			InputStream in = url.openStream();
//			System.out.println(in.toString());
//			System.out.println(in.read()); // -1

			// 바이트 스트림으로 읽기
			/*
			 * byte[] buffer = new byte[1024]; int count = 0; while ((count =
			 * in.read(buffer)) != -1) { String text = new String(buffer, 0, count);
			 * System.out.println(text); }
			 */

			// 문자 스트림으로 읽기 
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8")); // BridgeStream 
			String text = null;
			while ((text = br.readLine()) != null) { // BufferedReader로는 line별로 읽을 수 있음 
				System.out.println(text);
			}

		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(null, "서버를 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

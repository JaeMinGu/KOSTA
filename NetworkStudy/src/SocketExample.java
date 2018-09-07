import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * TCP/IP 기반의 Socket 프로그래밍 원리
 * 
 * @author 최재민
 *
 */
public class SocketExample {
	// 연결 시 꼭 필요한 ip, port
//	public static final String domain = "www.naver.com"; // 도메인 이름
//	public static final String domain = "127.0.0.1"; // 자기 컴퓨터-localhost랑 같은 의미 
//	public static final String domain = "localhost"; // 자기 컴퓨터
	public static final String domain = "192.168.0.129"; // 호진 컴퓨터-ipconfig
	public static final int port = 7777; // 포트번호-임의로 지정

	public static void main(String[] args) {
		Socket socket = null;
		InputStream in = null;
		OutputStream out = null;

		try {
//			Socket socket = new Socket(InetAddress.getByName(domain), port); // naver와 연결할 때 
			socket = new Socket(domain, port); // localhost와 연결할 때
			System.out.println("서버와 연결됨.....");

			in = socket.getInputStream();
			out = socket.getOutputStream();

			/*
			 * out.write(10); System.out.println("서버에 데이터 전송....."); int data = in.read();
			 * System.out.println("서버로부터 echo된 데이터 " + data);
			 */

			PrintWriter pw = new PrintWriter(out);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			Scanner scanner = new Scanner(System.in);
			while (true) {
				String inputMessage = scanner.nextLine();
				pw.println(inputMessage); // 채팅의 시작
				pw.flush();
			
				if (inputMessage.equalsIgnoreCase("quit")) {
					
					break;
				}
				String serverMessage = br.readLine();
				System.out.println("서버로부터 에코된 데이터 : " + serverMessage);
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("서버와 연결할 수 없습니다.....");
		} finally {
			try {
//				out.close();
//				in.close();
				socket.close(); // socket을 닫으면 out과 in도 자동적으로 닫아짐
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}

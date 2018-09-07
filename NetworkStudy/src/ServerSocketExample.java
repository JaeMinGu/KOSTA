import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

// 자바로 서버 만들기 
public class ServerSocketExample {

	public static final int port = 7777;

	public static void main(String[] args) {
		boolean running = true;

		// 수신
		try {
			ServerSocket serverSocket = new ServerSocket(port); // port번호 임의로 지정
			System.out.println(port + "포트에서 서버 실행.....");

			while (running) {
				Socket socket = serverSocket.accept(); // serverSocket의 accept 메소드 활용 - client로부터 수신
				InetAddress ia = socket.getInetAddress();
				System.out.println(ia + "클라이언트가 연결해옴.....");

				Client client = new Client(socket);
				client.start();

				
				/*
				 * int data = in.read(); System.out.println("클라이언트 수신 데이터 : " + data);
				 * out.write(data);
				 */
				

//				pw.close();
//				br.close();
//				socket.close(); // 사실 socket만 닫아도 됨(pw, br)은 자동으로 닫히기 때문

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

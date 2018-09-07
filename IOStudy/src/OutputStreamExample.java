import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamExample {

	static final String path = "example.dat";

	public static void main(String[] args) throws IOException {
		OutputStream outputStream = new FileOutputStream(path, true); // true: append 하겠다는 의미
//		outputStream.write(-128);
//		outputStream.close();
//		System.out.println("파일에 1바이트 썼음");

		byte[] buffer = new byte[128];
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = (byte) i;
		}

		outputStream.write(buffer); // 똑같음
//		outputStream.write(buffer, 0, buffer.length); // 똑같음
		outputStream.close();
		System.out.println("파일에 128바이트 썼음");
	}

}

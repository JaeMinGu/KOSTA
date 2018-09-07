import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamExample {

	static final String path = "example3.dat";

	public static void main(String[] args) throws IOException {

		// 변수 초기화
		boolean flag = false;
		char c = 0;
		int age = 0;
		double weight = 0;
		String message = null;

		DataInputStream in = new DataInputStream(new FileInputStream(path));
		// DataOutputStreamExample에서 받아온 값을 읽어들임
		flag = in.readBoolean();
		c = in.readChar();
		age = in.readInt();
		weight = in.readDouble();
		message = in.readUTF();

		in.close();

		System.out.println(flag);
		System.out.println(c);
		System.out.println(age);
		System.out.println(weight);
		System.out.println(message);

	}

}

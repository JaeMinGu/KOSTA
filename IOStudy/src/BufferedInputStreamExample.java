import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class BufferedInputStreamExample {

	static final String path = "C:/KOSTA187/설치프로그램/epp500_0651_64bit.exe";

	public static void main(String[] args) throws IOException{
		// 노드 스트림
		InputStream fin = null; 
		fin = new FileInputStream(path);  
		
		// 필터 스트림 
		BufferedInputStream in = null; 
		in = new BufferedInputStream(fin); // 512 바이트 배열 자동으로 생성 (default) 
		in.mark(5); // 추가된 기능, 마킹, 첫 번째에 마킹 - 추후 설명 보완할 예정  
		System.out.println(in.read()); // 77 출력 
		System.out.println(in.read());  
		in.mark(1);
		in.read();
		in.read();
		in.read();
		in.read();
		in.skip(20); // 추가된 기능, 20개 바이트 스킵
		in.reset(); // 추가된 기능, 리셋, 마킹한 쪽으로 점프, 원위치
		System.out.println(in.read()); // 77 출력 
	}

}

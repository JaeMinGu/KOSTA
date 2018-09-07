import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class FileExample {

	public static void main(String[] args) throws IOException {
		/** 파일 존재여부 */
		String path = "c:/some.dat";
		File file = new File(path);
		boolean isExists = file.exists();
		System.out.println("존재여부: " + isExists);

		/** 파일용량, 변경날짜 */
		path = "C:\\KOSTA187\\설치프로그램\\epp500_0651_64bit.exe";
		file = new File(path);
		// 파일용량
		long fileSize = file.length();
		System.out.println("파일용량: " + fileSize + " 바이트");
		// 변경날짜
		long lastModifiedTime = file.lastModified();
		Calendar lastModified = Calendar.getInstance();
		lastModified.setTimeInMillis(lastModifiedTime);

		System.out.print("변경날짜: "); // 형식 : "2014-03-12"
		System.out.printf("%1$tF %1$tp %1$tT", lastModified);

		/** 디렉토리 파일인지 여부, 서브디렉토리 목록 출력 */
		path = "C:\\KOSTA187";
		file = new File(path);

		// 디렉토리 파일인지 여부
		boolean isDirectory = file.isDirectory();
		String result = null;
		if (isDirectory) {
			result = "디렉토리";
		} else {
			result = "파일";
		}
		System.out.println("\n패스가 디렉토리인지 파일인지 여부: " + result);

		// 서브디렉토리
		File[] list = file.listFiles();
		for (File f : list) {
			if (f.isDirectory()) {
				System.out.println("<DIR>        " + f.getName());
			} else {
				System.out.println(f.getName() + "         " + f.length());
			}
		}

		System.out.println("디렉토리의 경우, 서브디렉토리 목록: ");

		/** 절대경로 출력 */
		path = "example.dat";
		file = new File(path);
		String absolutePath = file.getAbsolutePath();
		System.out.println("절대경로 : " + absolutePath);

//		System.out.println(file.toURL());
		System.out.println(file.toURI()); // toURL보다 훨씬 광범위한 범위

		// 조작관련 기능들
		path = "xxx.dat";
		file = new File(path);
		System.out.println(file.createNewFile());

		File temp = File.createTempFile("some", ".dat");
		System.out.println(temp.getAbsolutePath());
		FileOutputStream out = new FileOutputStream(temp);
		out.write(10);

		temp.deleteOnExit();

		// 디렉토리 생성 및 삭제
		File dir = new File("c:/KOSTA187/xxx");
		System.out.println(dir.mkdirs());
		System.out.println(dir.delete());

		// 사용가능한 파일시스템의 루트
		File[] drives = File.listRoots();
		for (File file2 : drives) {
			System.out.println(file2.toString());
		}

	}

}

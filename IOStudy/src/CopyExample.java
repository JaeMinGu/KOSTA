import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {

	public static long copy(String srcPath, String destPath) throws IOException {
		InputStream in = null;
		OutputStream out = null;

		try {

			in = new FileInputStream(srcPath);
			out = new FileOutputStream(destPath);

			byte[] buffer = new byte[4 * 1024];
			int count = 0;
			long totalCount = 0;
			while ((count = in.read(buffer)) != -1) {
				out.write(buffer, 0, count);
				totalCount += count;
			}
			return totalCount;

		} finally {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}

		}

	}

	public static void main(String[] args) throws IOException {

		String src = "C:\\KOSTA187\\설치프로그램\\교육생 제공 4000개PNG아이콘.zip";
		String dest = "icon.zip";

		long copySize = copy(src, dest);
		System.out.println(copySize + " 바이트 파일 복사 완료....");

	}
}

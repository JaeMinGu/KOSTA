import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress 클래스 DNS와의 통신을 통해 IP <-> Domain 정보제공
 * 
 * @author 최재민
 *
 */
public class InetAddressExample {

	public static void main(String[] args) throws UnknownHostException {

		InetAddress ia = InetAddress.getLocalHost();
		System.out.println(ia.getHostAddress()); // 내 컴퓨터의 ip주소

//		String domain = "www.naver.com"; 
//		String domain = "www.daum.net";
		String domain = "www.google.com";
		InetAddress ia2 = InetAddress.getByName(domain);
		System.out.println(ia2.getHostAddress()); // domain 서버의 실제 address

		InetAddress[] ias = InetAddress.getAllByName(domain);
		for (InetAddress inetAddress : ias) {
			System.out.println(inetAddress.toString());
		}

	}

}

import java.util.Date;

public class DateExample {

	public static void main(String[] args) {
		Date today = new Date();
		System.out.println(today.getYear());
		System.out.println(today.toString());
		System.out.println(today.toLocaleString());
		System.out.println(today.getTime()); // 밀리세컨드로 반환	c.f.1000밀리세컨드 == 1초 
		
	}

}


public class StringExample {

	public static void main(String[] args) {
		// 명시적생성
		String str1 = new String("Java Programming");	
		String str2 = new String("Java Programming");
		// 레퍼런스 비교
		if(str1 == str2){
		     System.out.println("레퍼런스 같다.");
		}else{
		     System.out.println("레퍼런스 다르다.");
		}

		// 묵시적생성(효율적: String Pool에서 관리)
		String str3 = "Java Programming";		
		String str4 = "Java Programming";
		// 레퍼런스 비교
		// 문자열 상수를 이용한 생성시 StringPool에서 검색 후 존재하지 않을 경우 새로 생성
		if(str3 == str4){
		     System.out.println("레퍼런스 같다.");
		}else{
		     System.out.println("레퍼런스 다르다.");
		}
		System.out.println(str1 == str3);
		System.out.println(str1.equals(str3));
		
		
		// 주요 메소드 
		String message = "Java Programming";
		System.out.println(message.substring(5));
		System.out.println("Java Programming".substring(5));
		System.out.println(message);

		
		System.out.println("김기정 ".concat("바보"));
		System.out.println("JavaJava".replace('J', 'K'));
		System.out.println("JavaJava".replaceAll("Java", "김기정"));
		
		
		String ssn = "680313-1234567";
		char c = ssn.charAt(ssn.indexOf('-') + 1);
		switch(c) {
		case '1' : System.out.println("2000년 이전 출생 남자"); break; 
		case '2' : System.out.println("2000년 이전 출생 여자"); break; 
		case '3' : System.out.println("2000년 이후 출생 남자"); break; 
		case '4' : System.out.println("2000년 이전 출생 여자"); break; 
		default  : System.out.println("외국인"); break; 
		}		
		
		System.out.println("                     J a v a                   ");
		System.out.println("                     J a v a                   ".trim());
		
		int num = 100343434;
		System.out.println(String.valueOf(num).length());
		
	}

}

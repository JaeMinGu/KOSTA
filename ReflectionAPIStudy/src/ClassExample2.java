import java.util.Vector;

/**
 * Class를 이용하여 동적 객체(인스턴스) 생성
 * 
 * @author 김기정
 *
 */
public class ClassExample2 {

	public static void main(String[] args) {
		String className = "java.util.Vector";
		
		Object object = null;		
		try {
			Class cls = Class.forName(className); 
			// 디폴트생성자 호출
			object = cls.newInstance(); // 동적 객체 생성 
			System.out.println(object instanceof Vector); // true
			
			// 필요에 따라 Down Casting
			Vector vector = (Vector)object;
			vector.addElement("동적 객체 생성");
			System.out.println(vector.elementAt(0));
			
		} catch (ClassNotFoundException e) { // Class.forName 시 많은 예외 발생 
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}

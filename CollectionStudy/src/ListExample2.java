import java.util.Calendar;
import java.util.Enumeration;
import java.util.Vector;

/**
 * List는 순서를 통해 데이터를 관리하기 위한 규약(인터페이스). Set과 달리 요소가 순차적으로 관리되며, 중복을 허용하는 특징을 가짐.
 * ArrayList, Vector, LinkedList가 List 인터페이스를 구현한 대표적 클래스.
 * 
 * 
 * @author 최재민
 *
 */
public class ListExample2 {

	public static void main(String[] args) {
		Vector list = null;
//		list = new Vector();
		list = new Vector(10, 5); // (초기 생성 크기 , 증가치) 

		list.addElement("황의조");
		list.addElement("황의조"); // 중복
		list.addElement("손흥민");
		list.addElement("바나나");
		list.addElement(100); // Object obj = 100; (autoBoxing)
		list.addElement(new Integer(100)); // 중복
		list.addElement(Calendar.getInstance());

		System.out.println("담겨진 갯수: " + list.size()); // 7
		System.out.println("비어있는지 여부: " + list.isEmpty()); // false
		
		System.out.println(list.elementAt(0));
		System.out.println(list.elementAt(1));
		System.out.println(list.elementAt(2));
		
		System.out.println(list.removeElement("바나나"));
		System.out.println(list.elementAt(0));
		System.out.println(list.elementAt(1));
		System.out.println(list.elementAt(2));
		System.out.println(list.elementAt(3));
		
		// 확장 for문은 비동기 처리함, 따라서, 동기처리하는 Vector에서 for문 쓰면 안 됨 
//		for (Object object : list) {
//		}
		System.out.println();
		Enumeration e = list.elements();
		while (e.hasMoreElements()) {
			Object object = e.nextElement();
			System.out.println(object);
		}

	}

}

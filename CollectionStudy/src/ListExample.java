import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * List는 순서를 통해 데이터를 관리하기 위한 규약(인터페이스). Set과 달리 요소가 순차적으로 관리되며, 중복을 허용하는 특징을 가짐.
 * ArrayList, Vector, LinkedList가 List 인터페이스를 구현한 대표적 클래스.
 * 
 * 
 * @author 최재민
 *
 */
public class ListExample {

	public static void main(String[] args) {
		List list = null;
		list = new ArrayList();

		list.add("황의조");
		list.add("황의조"); // 중복
		list.add("손흥민");
		list.add("바나나");
		list.add(100); // Object obj = 100; (autoBoxing)
		list.add(new Integer(100)); // 중복
		list.add(Calendar.getInstance());

		System.out.println("담겨진 갯수: " + list.size()); // 7
		System.out.println("비어있는지 여부: " + list.isEmpty());

		Set boddari = new HashSet();
		boddari.add("AAAA");
		boddari.add("BBBB");
		boddari.add("CCCC");

		list.addAll(boddari);
		System.out.println("담겨진 갯수: " + list.size()); // 10

		boolean result = list.remove("바나나");
		System.out.println(result);
		System.out.println("담겨진 갯수: " + list.size()); // 7

		list.removeAll(boddari);
		System.out.println("담겨진 갯수: " + list.size()); // 4

		list.clear();
		System.out.println("담겨진 갯수: " + list.size()); // 0

		list.add("황의조");
		System.out.println("담겨진 갯수: " + list.size()); // 1

		boolean result2 = list.contains("황의조");
		System.out.println(result2); // true
		System.out.println(list.contains("바나나")); // false

		list.add(Calendar.getInstance());
		System.out.println(list.contains(Calendar.getInstance())); // true
		System.out.println();

		Object[] lists = list.toArray();
		for (Object object : lists) {
			if (object instanceof String) {
				System.out.println(((String) object).length());
			}
			System.out.println(object);
		}
		System.out.println();
		list.remove(Calendar.getInstance());

		list.add("바나나");
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object object = iterator.next();
			System.out.println(object);
		}
		System.out.println();
		System.out.println(list.size()); // 2
		System.out.println();
		for (Object object : list) {
			System.out.println(object);
		}
		System.out.println();

		// list에 추가된 메소드들
		list.add(0, "김기정");
		System.out.println(list.get(0));
		System.out.println(list.size());

		System.out.println(list.indexOf("김기정"));
//		list.remove("김기정");
		list.remove(0);
		System.out.println(list.size());

		System.out.println(list.get(0));
		list.set(0, "황희찬");
		System.out.println(list.get(0));

		System.out.println(list.size());
		
		List l = list.subList(0, 2);
		for (Object object : l) {
			System.out.println(object);
		}
		

	}

}

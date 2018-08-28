import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set은 데이터의 중복 저장 없이 데이터를 관리하기 위한 규약(인터페이스) 순서와 관련 없이 데이터를 관리 HashSet이 Set
 * 인터페이스를 구현한 대표적인 클래스
 * 
 * @author 최재민
 *
 */
public class SetExample {

	public static void main(String[] args) {
		Set set = null;
		set = new HashSet(10);

		set.add("황의조");
		set.add("황의조"); // 중복
		set.add("손흥민");
		set.add("바나나");
		set.add(100); // Object obj = 100; (autoBoxing)
		set.add(new Integer(100)); // 중복
		set.add(Calendar.getInstance());

		System.out.println("담겨진 갯수: " + set.size()); // 5
		System.out.println("비어있는지 여부: " + set.isEmpty());

		Set boddari = new HashSet();
		boddari.add("AAAA");
		boddari.add("BBBB");
		boddari.add("CCCC");

		set.addAll(boddari);
		System.out.println("담겨진 갯수: " + set.size()); // 8

		boolean result = set.remove("바나나");
		System.out.println(result);
		System.out.println("담겨진 갯수: " + set.size()); // 7

		set.removeAll(boddari);
		System.out.println("담겨진 갯수: " + set.size()); // 4

		set.clear();
		System.out.println("담겨진 갯수: " + set.size()); // 0

		set.add("황의조");
		System.out.println("담겨진 갯수: " + set.size()); // 1

		boolean result2 = set.contains("황의조");
		System.out.println(result2); // true
		System.out.println(set.contains("바나나")); // false

		set.add(Calendar.getInstance());
		System.out.println(set.contains(Calendar.getInstance())); // true
		System.out.println();
		
		Object[] list = set.toArray();
		for (Object object : list) {
			if (object instanceof String) {
				System.out.println(((String) object).length());
			}
			System.out.println(object);
		}
		System.out.println();
		set.remove(Calendar.getInstance()); 

		set.add("바나나"); 
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Object object = iterator.next();
			System.out.println(object);
		}
		System.out.println();
		System.out.println(set.size()); //2
		System.out.println();
		for (Object object : set) {
			System.out.println(object);
		}

	}

}

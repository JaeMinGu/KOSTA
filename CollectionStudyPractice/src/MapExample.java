import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		Map<String, String> student = new HashMap<>();

		student.put("A001", "김하나");
		student.put("A002", "김두울");
		student.put("A003", "김세엣");
		student.put("A004", "김네엣");
		student.put("A005", "김다섯");

		if (student.containsKey("A006")) {
			System.out.println("이미 존재하는 key입니다.");
		} else {
			student.put("A006", "김일곱");
		}

		System.out.println(student.get("A005"));

		Set<String> keyList = student.keySet();
		for (String keys : keyList) {
			System.out.println(keys);
		}

		Collection<String> values = student.values();
		for (String name : values) {
			System.out.println(name);
		}
	}
}

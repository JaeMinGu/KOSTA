import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();

		map.put("680313", "김기정");
		map.put("680314", "최기정");
		map.put("680315", "홍기정");
		map.put("680316", "박기정");
		map.put("680317", "이기정");
		map.put("680318", "손기정");

		if (map.containsKey("680313")) {
			System.out.println("존재하는 key입니다.");
		} else {
			map.put("680313", "조기정");
		}

		System.out.println(map.get("680313"));

		Set<String> list = map.keySet();
		for (String key : list) {
			System.out.println(key);
		}

		Collection<String> values = map.values();
		for (String name : values) {
			System.out.println(name);
		}

	}
}

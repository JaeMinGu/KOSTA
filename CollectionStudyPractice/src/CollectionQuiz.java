import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CollectionQuiz {

	public static void main(String[] args) {

		Set<Account> set = new HashSet<>();
		set.add(new Account("1111", "김기정", 1111, 1000));
		set.add(new Account("2222", "박기정", 2222, 2000));
		set.add(new Account("3333", "손기정", 3333, 30000));

		System.out.println(set.size());

		Map<String, String> map = System.getenv();

		Set<String> keySet = map.keySet();
		for (String name : keySet) {
			String value = map.get(name);
			System.out.println(name+"="+value);
		}
	}

}

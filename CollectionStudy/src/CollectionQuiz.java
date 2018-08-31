import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CollectionQuiz {

	public static void main(String[] args) {

		Set<Account> set = new HashSet<>();
		set.add(new Account("1111", "김기정", 1111, 1000));
		set.add(new Account("2222", "박기정", 2222, 2000));
		set.add(new Account("1111", "김기정", 1111, 1000));
		System.out.println(set.size());

		// getenv 
		Map<String, String> map = System.getenv();
		Set<String> keySet = map.keySet();

		for (String name : keySet) {
			String value = System.getenv(name);
			System.out.println(name + "=" + value);
		}
	}
}

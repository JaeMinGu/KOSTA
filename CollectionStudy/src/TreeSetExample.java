import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		Set<String> set = new TreeSet<String>();
		set.add("김기정");
		set.add("이기정");
		set.add("박기정");
		set.add("최기정");
		set.add("bbbb");
		set.add("aaaa");

		for (String string : set) {
			System.out.println(string);
		}
	}

}

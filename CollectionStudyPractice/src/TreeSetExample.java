import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {

		Set<String> treeSet = new TreeSet<>(); 
		
		treeSet.add("bread"); 
		treeSet.add("butter"); 
		treeSet.add("jam");
		treeSet.add("1");
		treeSet.add("한글");
		
		
//		System.out.println(treeSet);
		for (String string : treeSet) {
			System.out.println(string);
		}
	}

}

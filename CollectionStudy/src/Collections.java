import java.util.ArrayList;
import java.util.List;

public class Collections {

	public static void main(String[] args) {
		
		List<Account> list = new ArrayList<>();
		list.add(new Account("3333", "이기정", 1111, 3000));
		list.add(new Account("2222", "박기정", 1111, 2000));
		list.add(new Account("1111", "김기정", 1111, 5000));

//		java.util.Collections.sort(list);
/*		java.util.Collections.sort(list, new NumberCompare());
		for (Account account : list) {
			System.out.println(account);
		}*/
		
		java.util.Collections.sort(list, new MoneyCompare());
		for (Account account : list) {
			System.out.println(account);
		}
		
		
	}
}

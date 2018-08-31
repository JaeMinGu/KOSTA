import java.util.Enumeration;
import java.util.Hashtable;

public class MapExample2 {
	public static void main(String[] args) {
		Hashtable<String, Account> set = new Hashtable<>();

		Account account1 = new Account("1111", "김기정", 1111, 1000);
		Account account2 = new Account("2222", "박기정", 2222, 2000);

		set.put(account1.getAccountNum(), account1);
		set.put(account2.getAccountNum(), account2);

		System.out.println(set.get("1111"));

		Enumeration<String> e = set.keys();

		while (e.hasMoreElements()) {
			String keyList = (String) e.nextElement();
			System.out.println(keyList);
		}

		Enumeration<Account> e2 = set.elements();
		while (e2.hasMoreElements()) {
			Account account = (Account) e2.nextElement();
			System.out.println(account);
		}
		
	}
}

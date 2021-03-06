/**
 * AMS(Account Manager System) 은행 계좌 관리 애플리케이션
 * 
 * @author 최재민
 *
 */
public class AMS {

	public static void main(String[] args) {
//		AccountManager manager = new AccountManager(); 
		AccountManager manager = new AccountManager(100);

		Account account = new Account("1111-2222-3333", "최재민", 1111, 100000);
		manager.add(account);
		manager.add(new Account("2222-3333-4444", "박지성", 1111, 200000));
		manager.add(new Account("3333-4444-5555", "손흥민", 1111, 300000));

		// Up Casting
		manager.add(new MinusAccount("9999-1111-2222", "김대출", 1111, 1000, 1000000));
		manager.add(new MinusAccount("9999-2222-3333", "나대출", 2222, 2000, 2000000));

		manager.add(new Account("4444-5555-6666", "박찬호", 1111, 300000));

		Account[] list = manager.list();
		for (Account account2 : list) {
			if (account2 instanceof MinusAccount) {
				System.out.println("마이너스계좌\t" + account2.toString());
			}else {
				System.out.println("입출금계좌\t" + account2.toString());
				
			}

		}

		Account result = manager.get("1111-2222-3333");
		if (result != null) {
			System.out.println(result);
		} else {
			System.out.println("해당계좌가 없습니다.");
		}

	}

}

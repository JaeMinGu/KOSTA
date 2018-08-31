import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

/**
 * Collection을 이용한 은행 계좌 관리
 * 
 * @author 최재민
 *
 */

public class AccountManager3 {

	// 인스턴스 변수
	private Hashtable<String, Account> accounts;

	// 생성자
	public AccountManager3() {
		this(10);
	}

	public AccountManager3(int size) {
		accounts = new Hashtable<>();
	}

	// setter/getter 메소드
	public Hashtable<String, Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Hashtable<String, Account> accounts) {
		this.accounts = accounts;
	}

	// 계좌 개설
	public void add(Account account) {
		// 중복체크
		if (accounts.contains(account)) {
			System.out.println("이미 존재하는 계좌입니다.");
			return;
		}
		accounts.put(account.getAccountNum(), account);
	}

	// 계좌 반환
	public Enumeration<Account> listAll() {
		return accounts.elements();
	}

	// 계좌번호를 활용한 계좌조회
	public Account get(String accountNum) {
		return accounts.get(accountNum);
	}

	// 회원명을 활용한 계좌 검색
	public List search(String accountOwner) {
		List<Account> list = new ArrayList<>();
		Enumeration<Account> e = accounts.elements();
		while (e.hasMoreElements()) {
			Account ac = e.nextElement();
			if (ac.getAccountOwner().equals(accountOwner)) {
				list.add(ac);
			}
		}
		return list;
	}

	// 계좌 삭제
	public boolean remove(String accountNum) {
		return (accounts.remove(accountNum)) != null;
	}

}

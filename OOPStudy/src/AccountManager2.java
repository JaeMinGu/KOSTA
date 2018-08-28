import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * Collection을 이용한 은행 계좌 관리
 * 
 * @author 최재민
 *
 */

public class AccountManager2 {

	private Vector accounts;

	public AccountManager2() {
		this(10);
	}

	public AccountManager2(int size) {
		accounts = new Vector(size, 5);
	}

	public Vector getAccounts() {
		return accounts;
	}

	public void setAccounts(Vector accounts) {
		this.accounts = accounts;
	}

	// 계좌 개설
	public void add(Account account) {
		accounts.addElement(account);
	}

	// 계좌 반환
	public List list() {
//		return accounts;
		List list = new ArrayList(accounts.size());
		Enumeration e = accounts.elements();
		while (e.hasMoreElements()) {
			Object object = e.nextElement();
			list.add(accounts);
		}
		return list;

	}

	// 계좌번호를 활용한 계좌조회
	public Account get(String accountNum) {
		
		return null;
	}

	// 회원명을 활용한 계좌 검색
	public List search(String accountOwner) {
		return null;
	}

	// 계좌 삭제
	public boolean remove(String accountNum) {
		 Enumeration e = accounts.elements();
		 while(e.hasMoreElements()) {
			 
		 }
		return false; 
	}

}

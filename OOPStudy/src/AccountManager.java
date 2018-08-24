/**
 * 배열을 이용한 은행 계좌 관리
 * 
 * @author 최재민
 *
 */

public class AccountManager {
	/**
	 * field
	 */
	private Account[] accounts;
	private int count;

	/**
	 * constructor
	 */
	public AccountManager() {
		this(10);
	}

	public AccountManager(int size) {
		accounts = new Account[size];
	}


	/**
	 * method 
	 * @return
	 */
	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	/**
	 * 계좌개설
	 * 
	 * @param account
	 */
	public void add(Account account) {
		accounts[count] = account;
		count++;
	}

	/**
	 * 계좌 반환
	 * 
	 * @return
	 */
	public Account[] list() {
		Account[] account2;
		account2 = new Account[count];
		
		
		for (int i = 0; i < count; i++) {
			account2[i] = accounts[i];
		}
		return account2;
		
	}

	/**
	 * 계좌 조회(계좌번호)
	 * 
	 * @param accountNum
	 * @return
	 */
	public Account get(String accountNum) {
		Account account = null; 
		for (int i = 0; i < count; i++) {
			if(accounts[i].getAccountNum().equals(accountNum)) {
				account = accounts[i];
			}
			
		}
		return account;
	}

	/**
	 * 계좌 검색(회원명)
	 * 
	 * @param accountOwner
	 * @return
	 */
	public Account[] search(String accountOwner) {
		return null;
	}

	/**
	 * 계좌 삭제
	 * 
	 * @param accountNum
	 * @return
	 */
	public boolean remove(String accountNum) {
		return false;
	}

}

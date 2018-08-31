package kr.or.kosta.entity;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 * 효율적인 계좌관리를 위한 AccountManager
 * 
 * @author 최재민
 *
 */
public class AccountManager {

	// 인스턴스 변수
	private Hashtable<String, Account> accounts;

	// 생성자
	public AccountManager() {
		this(10);
	}

	public AccountManager(int size) {
		accounts = new Hashtable<>();
	}

	// setter, getter 메소드
	public Hashtable<String, Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Hashtable<String, Account> accounts) {
		this.accounts = accounts;
	}

	/**
	 * 계좌개설
	 * 
	 * @param account
	 */
	public void add(Account account) {
		// 중복체크
		if (accounts.contains(account)) {
			System.out.println("이미 존재하는 계좌입니다.");
			return;
		}
		accounts.put(account.getAccountNum(), account);
	}

	/**
	 * 계좌반환
	 * 
	 * @return
	 */
	public Enumeration<Account> listAll() {
		return accounts.elements();
	}

	/**
	 * 계좌번호를 활용한 계좌조회
	 * 
	 * @param accountNum
	 * @return
	 */
	public Account getAccount(String accountNum) {
		return accounts.get(accountNum);
	}

	/**
	 * 예금주를 활용한 계좌조회 
	 * 
	 * @param accountOwner
	 * @return
	 */
	public List<Account> searchAccount(String accountOwner) {
		List<Account> list = new ArrayList<>();
		Enumeration<Account> e = accounts.elements();
		while(e.hasMoreElements()) {
			Account account = e.nextElement();
			if(account.getAccountOwner().equals(accountOwner)) {
				list.add(account);
			}
		}
		return list;
	}
	
	
	/**
	 * 계좌번호를 활용한 계좌삭제 
	 * 
	 * @param accountNum
	 * @return
	 */
	public boolean remove(String accountNum) {
		return (accounts.remove(accountNum)) != null; 
	}

}

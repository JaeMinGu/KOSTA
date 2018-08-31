package kr.or.kosta.entity;

import javax.naming.spi.DirStateFactory.Result;
import javax.security.auth.login.AccountException;
/**
 * 계좌 클래스 
 * 
 * @author 최재민
 *
 */
public class Account {

	// static 변수 선언
	public static final String bankName = "KOSTA 은행";

	// 인스턴스 변수 선언
	private String accountNum; // 계좌번호 
	private String accountOwner; // 예금주 
	private int passwd; // 비밀번호
	private long restMoney; // 잔액 

	// 생성자
	public Account() {
		this(null, null);

	}

	public Account(String accountNum, String accountOwner) {
		this(accountNum, accountOwner, 0, 0);

	}

	public Account(String accountNum, String accountOwner, int passwd, long restMoney) {
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}

	// setter, getter 메소드
	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public int getPasswd() {
		return passwd;
	}

	public void setPasswd(int passwd) {
		this.passwd = passwd;
	}

	public void setRestMoney(long restMoney) {
		this.restMoney = restMoney;
	}

	// 인스턴스 메소드

	/**
	 * 예금 기능
	 * 
	 * @param money
	 * @return
	 */
	public long deposit(long money) /* throws AccountException */ {
		/*
		 * if (money <= 0) { throw new AccountException("0보다 적은 금액은 입력할 수 없습니다.", 3); }
		 */
		restMoney += money;
		return restMoney;
	}

	/**
	 * 출금 기능
	 * 
	 * @param money
	 * @return
	 */
	public long withdraw(long money) {
		restMoney -= money;
		return restMoney;
	}

	/**
	 * 잔액조회 기능
	 * 
	 * @return
	 */
	public long getRestMoney() {
		return restMoney;
	}

	/**
	 * 비밀번호확인 기능
	 * 
	 * @param pw
	 * @return
	 */
	public boolean checkPasswd(int pw) {
		return (this.passwd == pw);
	}

	// 결과표시
	@Override
	public String toString() {
		return getAccountNum() + "\t" + getAccountOwner() + "\t" + getRestMoney();
	}

}

package kr.or.kosta.entity;

/**
 * 계좌 정보 추상화
 * 
 * @author 최재민
 *
 */
public class Account {

	// static 변수 선언
	public static final String bankName = "KOSTA 은행";

	// 인스턴스 변수 선언
	private String accountNumber;
	private String accountOwner; 
	private int password; 
	private long restMoney; 

	// 생성자
	public Account() {
		this(null, null);

	}

	public Account(String accountNumber, String accountOwner) {
		this(accountNumber, accountOwner, 0, 0);

	}

	public Account(String accountNumber, String accountOwner, int password, long restMoney) {
		this.accountNumber = accountNumber;
		this.accountOwner = accountOwner;
		this.password = password;
		this.restMoney = restMoney;
	}

	// setter, getter 메소드
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNum) {
		this.accountNumber = accountNum;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int passwd) {
		this.password = passwd;
	}

	public void setRestMoney(long restMoney) {
		this.restMoney = restMoney;
	}

	// 인스턴스 메소드
	/**
	 * 예금 기능
	 * 
	 * @param money 입금금액 
	 * @return
	 */
	public long deposit(long money) throws AccountException {
		if (money <= 0) {
			throw new AccountException("0보다 적은 금액은 입금할 수 없습니다.", -1);
		}
		restMoney += money;
		return restMoney;
	}

	/**
	 * 출금 기능
	 * 
	 * @param money 출금금액 
	 * @return
	 */
	public long withdraw(long money) throws AccountException {
		if (money <= 0) {
			throw new AccountException("0보다 적은 금액은 출금할 수 없습니다.", -2);
		}
		if (money > restMoney) {
			throw new AccountException("잔액이 부족합니다.", -3);
		}
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
	 * @param pw 비밀번호
	 * @return
	 */
	public boolean checkPasswd(int pw) {
		return (this.password == pw);
	}

	// 결과표시
	@Override
	public String toString() {
		return getAccountNumber() + "\t" + getAccountOwner() + "\t" + getRestMoney();
	}

}

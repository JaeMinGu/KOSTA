
/**
 * 일상생활의 객체를 추상화하기 위한 모델링 클래스 정의 e.g.은행계좌 객체 c.f.어플리케이션 클래스(테스트를 하기 위해 main
 * 메소드_엔트리포인트를 가지고 있는 클래스)
 */
public class Account { // class는 public 이거나 default이거나 두 가지밖에 없음

	// static 초기화 블럭(특수한 목적의 명령어 실행)
	static {
		System.out.println("초기화 블럭 실행입니다.1");
		System.out.println("초기화 블럭 실행입니다.2");
	}

	// 클래스(static) 변수
	public static final String BANKNAME = "하나은행";

	// 인스턴스 변수 선언
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;

	// 생성자
	public Account() {
		this(null, null);
	}

	public Account(String accountNum, String accountOwner) {
		// this.accountNum = accountNum;
		// this.accountOwner = accountOwner;
		this(accountNum, accountOwner, 0, 0);
	}

	public Account(String accountNum, String accountOwner, int passwd, long restMoney) {
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}

	// setter/getter 메소드
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setPasswd(int passwd) {
		this.passwd = passwd;
	}

	public int getPasswd() {
		return passwd;
	}

	public void setRestMoney(long restMoney) {
		this.restMoney = restMoney;
	}

	// 인스턴스 메소드
	public long deposit(long money) throws AccountException {
		if(money <= 0) {
			throw new AccountException("양수의 값을 입금해주세요.", -3);
		}
		
		restMoney += money;
		return restMoney;
	}

	public long withdraw(long money) throws AccountException {
		if (money <= 0) {
			throw new AccountException("출금하고자 하는 금액은 음수일 수 없습니다.", -1);
		}

		if (money > restMoney) {
			throw new AccountException("잔액이 부족합니다.", -2);
		}

		restMoney -= money;
		return restMoney;
	}

	public long getRestMoney() {
		return restMoney;
	}

	public boolean checkPasswd(int passwd) {
		return (this.passwd == passwd);
	}

	public String toString() {
		return getAccountNum() + "\t" + getAccountOwner() + "\t" + "****" + "\t" + getRestMoney();
	}

	@Override
	public boolean equals(Object obj) {

//			return account1.toString().equals(account2.toString());
		boolean eq = false;
		if (obj instanceof Account) {
			eq = toString().equals(obj.toString());
		}
		return eq;
	}

	// 클래스(static) 메소드
	public static int sum(int a, int b) {
		return a + b;
	}

}

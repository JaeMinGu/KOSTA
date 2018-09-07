package kr.or.kosta.entity;

/**
 * 마이너스 통장 클래스
 * 
 * @author 최재민
 *
 */
public class MinusAccount extends Account {
	// 인스턴스 변수
	private long borrowMoney; // 대출금액

	// 생성자
	public MinusAccount() {
		this(null, null, 0, 0, 0);
	}

	public MinusAccount(String accountNumber, String accountOwner, int passwd, long restMoney, long borrowMoney) {
		super(accountNumber, accountOwner, passwd, restMoney);
		this.borrowMoney = borrowMoney;
	}

	// setter, getter 메소드
	public long getBorrowMoney() {
		return borrowMoney;
	}

	public void setBorrowMoney(long borrowMoney) {
		this.borrowMoney = borrowMoney;
	}

	// 잔액조회(+ 대출금액 추가)
	@Override
	public long getRestMoney() {
		return super.getRestMoney();
	}

	// 결과표시(+ 대출금액 추가)
	@Override
	public String toString() {
		return super.toString() + "\t" + getBorrowMoney();
	}

}

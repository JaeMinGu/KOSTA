package kr.or.kosta.entity;
/**
 * 계좌 예외처리 
 * 
 * @author 최재민
 *
 */
public class AccountException extends Exception {

	// 인스턴스 변수
	private int errorCode; 

	// 생성자
	public AccountException() {
		this("예기치 않은 에러가 발생했습니다.", 0);
	}

	public AccountException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	// setter, getter 메소드
	public int getErrorCode() {
		return errorCode;
	}

	// 에러코드를 문자열로 출력 
	@Override
	public String toString() {
		return "AccountException [errorCode=" + errorCode + ", getErrorCode()=" + getErrorCode() + "]";
	}

}

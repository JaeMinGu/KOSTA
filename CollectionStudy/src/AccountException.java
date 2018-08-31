public class AccountException extends Exception {
	// String message;
	private int errorCode;

	public AccountException() {
		this("계좌처리 중 예기치 않은 에러가 발생했습니다. 다시 한 번 시도해주세요.", -9);
	}

	public AccountException(String arg0, int errorCode) {
		super(arg0);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	@Override
	public String toString() {
		return "AccountException [errorCode=" + errorCode + ", getErrorCode()=" + getErrorCode() + "]";
	}

}

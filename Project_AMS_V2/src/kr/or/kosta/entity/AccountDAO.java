package kr.or.kosta.entity;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * RandomAccessFile을 이용하여 Account 정보를 레코드 단위로 파일에 저장/읽기 처리
 * 
 * @author 최재민
 *
 */
/**
 * @author 최재민
 *
 */
public class AccountDAO {

	private Hashtable<String, Account> accounts;

	/** 저장 파일 경로 */
	private static final String FILE_PATH = "accounts.dbf";

	/** 레코드(Account)수 저장을 위한 파일 컬럼 사이즈 고정 */
	private static final int RECORD_COUNT_LENGTH = 4;

	/** 레코드(계좌번호, 예금주, 비밀번호, 잔액) 저장을 위한 컬럼별 사이즈 고정 */
	private static final int ACCOUNT_NUMBER_LENGTH = 30; // 계좌번호(30바이트)
	private static final int ACCOUNT_OWNER_LENGTH = 20; // 예금주(20바이트)
	private static final int ACCOUNT_PASSWORD_LENGTH = 4; // 비밀번호(4바이트)
	private static final int ACCOUNT_RESTMONEY_LENGTH = 8; // 잔액(8바이트)
	private static final int ACCOUNT_BORROWMONEY_LENGTH = 8; // 대출금액(8바이트)

	/** Account 저장을 위한 레코드 사이즈 : 70바이트 */
	public static final int RECORD_LENGTH = ACCOUNT_NUMBER_LENGTH + ACCOUNT_OWNER_LENGTH + ACCOUNT_PASSWORD_LENGTH
			+ ACCOUNT_RESTMONEY_LENGTH + ACCOUNT_BORROWMONEY_LENGTH;

	private RandomAccessFile file;

	/** 저장된 레코드 수 */
	private int recordCount = 0;

	/** 생성자 */
	public AccountDAO() throws IOException {
		file = new RandomAccessFile(FILE_PATH, "rw");

		// 저장된 파일이 있는 경우
		if (file.length() != 0) {recordCount = file.readInt();} 
		
	}

	/** getter */
	public int getRecordCount() {
		return recordCount;
	}

	/**
	 * 중복체크
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean doubleCheck(String accountNumber) throws IOException {
		for (int i = 0; i < recordCount; i++) {

			if (read(i).getAccountNumber().equals(accountNumber)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 신규등록
	 * 
	 * @throws IOException
	 */

	public boolean create(Account account) throws IOException {

		if (!doubleCheck(account.getAccountNumber())) {
			return false;
		}

		// 파일의 마지막 레코드끝으로 파일 포인터 이동.
		file.seek(RECORD_COUNT_LENGTH + (recordCount * RECORD_LENGTH));

		// 새로운 레코드 추가
		String accountNumber = account.getAccountNumber();
		String accountOwner = account.getAccountOwner();
		int password = account.getPassword();
		long restMoney = account.getRestMoney();
		long borrowMoney = -1;

		if (account instanceof MinusAccount) {
			borrowMoney = ((MinusAccount) account).getBorrowMoney();
		}

		// 계좌번호
		int numberCount = accountNumber.length();
		for (int i = 0; i < ACCOUNT_NUMBER_LENGTH / 2; i++) {
			file.writeChar(i < numberCount ? accountNumber.charAt(i) : ' ');
		}

		// 예금주
		int ownerCount = accountOwner.length();
		for (int i = 0; i < ACCOUNT_OWNER_LENGTH / 2; i++) {
			file.writeChar(i < ownerCount ? accountOwner.charAt(i) : ' ');
		}

		// 비밀번호
		file.writeInt(password);

		// 잔액
		file.writeLong(restMoney);

		// 대출금액
		file.writeLong(borrowMoney);

		// 레코드 저장 후 파일포인터를 파일의 처음으로 이동시켜 등록된 레코드 수 1 증가
		file.seek(0);
		file.writeInt(++recordCount);
		return true;
	}

	/**
	 * 전체조회-파일데이터로 반환
	 * 
	 * @return 전체리스트
	 * @throws IOException
	 */
	public List<Account> listAll() throws IOException {

		List<Account> accountList = new ArrayList<Account>();
		for (int i = 0; i < recordCount; i++) {
			Account account = read(i);
			accountList.add(account);
			System.out.println(account);
		}
		return accountList;

	}

	/**
	 * 전체조회-Account로 반환
	 * 
	 * @return Account
	 * @throws IOException
	 */
	public Account read(int index) throws IOException {
		Account account = null;

		// 계좌번호
		String accountNumber = "";
		file.seek(RECORD_COUNT_LENGTH + (index * RECORD_LENGTH));
		for (int i = 0; i < ACCOUNT_NUMBER_LENGTH / 2; i++) {
			accountNumber += file.readChar();
		}
		accountNumber = accountNumber.trim();

		// 예금주
		String accountOwner = "";
		for (int i = 0; i < ACCOUNT_OWNER_LENGTH / 2; i++) {
			accountOwner += file.readChar();
		}
		accountOwner.trim();

		// 비밀번호
		int password = 0;
		password = file.readInt();

		// 잔액
		long restMoney = 0;
		restMoney = file.readLong();

		// 대출금액
		long borrowMoney = 0;
		borrowMoney = file.readLong();
		System.out.println(borrowMoney);

		if (borrowMoney > 0) {
			account = new MinusAccount(accountNumber, accountOwner, password, restMoney, borrowMoney);
			System.out.println("Minus rest : " + restMoney);
		} else {
			account = new Account(accountNumber, accountOwner, password, restMoney);
		}

		// 생성
		return account;
	}

	/**
	 * 계좌번호로 조회
	 * 
	 * @throws IOException
	 */
	public Account getByNumber(String accocuntNumber) throws IOException {

		Account account = null;
		for (int i = 0; i < recordCount; i++) {
			if (read(i).getAccountNumber().equals(accocuntNumber)) {
				account = read(i);
				break;
			}
		}
		return account;
	}

	/**
	 * 예금주명으로 조회
	 * 
	 * @return
	 * @throws IOException
	 */
	public List<Account> getByOwner(String accountOwner) throws IOException {
		List<Account> accountList = new ArrayList<Account>();

		for (int i = 0; i < recordCount; i++) {
			if (read(i).getAccountOwner().trim().equals(accountOwner)) {
				accountList.add(read(i));
			}
		}

		return accountList;
	}

	/**
	 * 특정 레코드 삭제
	 * 
	 * @param accountNumber 계좌번호
	 * @return
	 * @throws IOException
	 */
	public boolean remove(String accountNumber) throws IOException {

		for (int i = 0; i < recordCount; i++) {
			Account account = read(i);
			if (account.getAccountNumber().equals(accountNumber)) {
				// i번째 계좌 삭제
				// 파일 포인터를 i번째 계좌 삭제할 수 있도록 이동
				file.seek(RECORD_COUNT_LENGTH + (i * RECORD_LENGTH));

				for (int j = i + 1; j < recordCount; j++, i++) {
					// i+1 번째 계좌를 i번째에 덮어쓰기 ~ recordCount 번째 까지
					// read 
					// 계좌번호
					String accountNumberj = read(j).getAccountNumber();
					// 예금주
					String accountOwner = read(j).getAccountOwner();
					// 비밀번호
					int password = read(j).getPassword();
					// 잔금
					long restMoney = read(j).getRestMoney();

					long borrowMoney = 0;
					// 대출금액
					if (read(j) instanceof MinusAccount) {
						borrowMoney = ((MinusAccount) read(j)).getBorrowMoney();
					} else {
						borrowMoney = -1;
					}
					
					// write 
					file.seek(RECORD_COUNT_LENGTH + (i * RECORD_LENGTH));
					// 계좌번호
					for (int k = 0; k < ACCOUNT_NUMBER_LENGTH / 2; k++) {
						file.writeChar(k < accountNumberj.length() ? accountNumberj.charAt(k) : ' ');
					}
					// 예금주
					for (int k = 0; k < ACCOUNT_OWNER_LENGTH / 2; k++) {
						file.writeChar(k < accountOwner.length() ? accountOwner.charAt(k) : ' ');
					}
					// 비밀번호
					file.writeInt(password);
					// 잔금
					file.writeLong(restMoney);
					// 대출금액
					file.writeLong(borrowMoney);

				}

				// recordCount번째 계좌는 그대로 두기
				// 레코드 삭제 후 파일포인터를 파일의 처음으로 이동시켜
				// 등록된 레코드 수 1 하락
				file.seek(0);
				file.writeInt(--recordCount);
				return true;
			}
		}
		return false;
	}

	/**
	 * 스트림 닫기
	 * 
	 */
	public void close() {
		if (file != null) {
			try {
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

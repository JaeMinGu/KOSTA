package kr.or.kosta.bin;
/**
 * 효율적인 계좌관리를 위한 AccountManager 활용    
 * 
 * @author 최재민
 *
 */

import kr.or.kosta.boundary.MainFrame;
import kr.or.kosta.entity.Account;
import kr.or.kosta.entity.AccountManager;
import kr.or.kosta.entity.MinusAccount;

public class AMS {

	public static void main(String[] args) {

		// accountManager 생성
		AccountManager accountManager = new AccountManager(100);
		
		// 메인프레임 생성 - 메인프레임 메소드를 사용하기 위함 
		MainFrame frame = new MainFrame("KOSTA AMS - 메인화면");
		frame.setAccountManager(accountManager);
		frame.setContents();
		frame.setSize(600, 500);
		frame.setCenter();
		frame.setVisible(true);
		frame.eventRegist();
		frame.headLine();

		// 예금통장 개설
		accountManager.add(new Account("1111-2222-3333", "김예금", 1111, 1000));
		accountManager.add(new Account("2222-3333-4444", "나예금", 2222, 2000));
		accountManager.add(new Account("3333-4444-5555", "다예금", 3333, 3000));

		// 대출통장 개설
		accountManager.add(new MinusAccount("9999-1111-2222", "김대출", 9111, 0, 9100));
		accountManager.add(new MinusAccount("9999-2222-3333", "나대출", 9222, 0, 9200));
		accountManager.add(new MinusAccount("9999-3333-4444", "다대출", 9333, 0, 9300)); // 삭제

	}

}

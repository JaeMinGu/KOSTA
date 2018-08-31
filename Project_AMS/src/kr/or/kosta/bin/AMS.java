package kr.or.kosta.bin;
/**
 * 효율적인 계좌관리를 위한 AccountManager 활용    
 * 
 * @author 최재민
 *
 */

import java.util.Enumeration;
import java.util.List;

import kr.or.kosta.boundary.MainFrame;
import kr.or.kosta.entity.Account;
import kr.or.kosta.entity.AccountManager;
import kr.or.kosta.entity.MinusAccount;

public class AMS {

	public static void main(String[] args) {

		// accountManager 생성
		AccountManager accountManager = new AccountManager(100);
		MainFrame mainFrame = new MainFrame();
//		mainFrame.setAccountManager(accountManager);
		
		// 예금통장 개설
		accountManager.add(new Account("1111-2222-3333", "김예금", 1111, 1000));
		accountManager.add(new Account("2222-3333-4444", "나예금", 2222, 2000));
		accountManager.add(new Account("3333-4444-5555", "다예금", 3333, 3000));

		// 대출통장 개설
		accountManager.add(new MinusAccount("9999-1111-2222", "김대출", 9111, 0, 9100));
		accountManager.add(new MinusAccount("9999-2222-3333", "나대출", 9222, 0, 9200));
		accountManager.add(new MinusAccount("9999-3333-4444", "다대출", 9333, 0, 9300)); // 삭제

		// 계좌반환-해야함

		/*Enumeration<Account> accountsList = accountManager.listAll();

		if (!accountsList.hasMoreElements()) {
			System.out.println("계좌가 없습니다.");
		}
		while (accountsList.hasMoreElements()) {
			System.out.println(accountsList.nextElement().toString());
		}*/

//		Account account = accountsList.nextElement();

		// 계좌번호를 활용한 계좌조회
		/*
		 * Account accountN = accountManager.getAccount("1111-2222-3333"); if (accountN
		 * != null) { if (accountN instanceof Account) { System.out.println("[예금통장]\t" +
		 * accountN.toString()); } if (accountN instanceof MinusAccount) {
		 * System.out.println("[마이너스통장]\t" + accountN.toString()); } } else {
		 * System.out.println("해당계좌가 존재하지 않습니다."); }
		 */

		// 예금주를 활용한 계좌조회-해야함
		List<Account> accountO = accountManager.searchAccount("김대출");

		if (accountO != null) {
			for (int i = 0; i < accountO.size(); i++) {
				Account temp = accountO.get(i);
//				System.out.println(temp.getClass());
				if (temp instanceof Account) {
					System.out.println("[예금통장]\t" + temp.toString());
				}
				if (temp instanceof MinusAccount) {
					System.out.println("[마이너스통장]\t" + temp.toString());
				}
			}
		} else {
			System.out.println("해당계좌가 존재하지 않습니다.");
		}

		// 계좌번호를 활용한 계좌삭제
		/*if (accountManager.remove("9999-3333-4444")) {
			System.out.println("해당계좌가 삭제되었습니다.");
		} else {
			System.out.println("해당계좌가 없습니다.");
		}*/

	}

}

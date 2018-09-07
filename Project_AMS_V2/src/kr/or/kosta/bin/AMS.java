package kr.or.kosta.bin;
/**
 * 효율적인 계좌관리를 위한 AccountManager 활용    
 * 
 * @author 최재민
 *
 */

import java.io.IOException;

import kr.or.kosta.boundary.MainFrame;
import kr.or.kosta.entity.Account;
import kr.or.kosta.entity.AccountDAO;
import kr.or.kosta.entity.MinusAccount;

public class AMS {

	public static void main(String[] args) throws IOException {

		// AcconutDAO 생성
		AccountDAO dao = new AccountDAO(); 
		// 예금통장 개설
		dao.create(new Account("1111-2222-3333", "김예금", 1111, 1000));
		dao.create(new Account("2222-3333-4444", "나예금", 2222, 2000));
		dao.create(new Account("3333-4444-5555", "다예금", 3333, 3000));
		dao.create(new Account("4444-5555-6666", "라예금", 4444, 4000));
		dao.create(new Account("5555-6666-7777", "마예금", 5555, 5000));
	

		// 대출통장 개설
		dao.create(new MinusAccount("9999-1111-2222", "김대출", 1111, 10000, 9100));
		dao.create(new MinusAccount("9999-2222-3333", "나대출", 2222, 10000, 9200));
		dao.create(new MinusAccount("9999-3333-4444", "다대출", 3333, 10000, 9300));
		dao.create(new MinusAccount("9999-4444-5555", "다대출", 4444, 20000, 9300));
		
		// 메인프레임 생성 - 메인프레임 메소드를 사용하기 위함 
		MainFrame frame = new MainFrame("KOSTA AMS - 메인화면");
		frame.setDao(dao);
		frame.setContents();
		frame.setSize(600, 500);
		frame.setCenter();
		frame.setVisible(true);
		frame.eventRegist();


	}

}

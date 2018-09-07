package kr.or.kosta.boundary;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.List;

import kr.or.kosta.entity.Account;
import kr.or.kosta.entity.AccountManager;
import kr.or.kosta.entity.MinusAccount;

/**
 * AMS를 위한 화면
 * 
 * @author 최재민
 *
 */
public class MainFrame extends Frame {

	// 인스턴스 변수 
	AccountManager accountManager;

	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;

	Label accountTypeL, accountNumberL, accountOwnerL, passwordL, borrowMoneyL, depositMoneyL, accountListL, unitL;
	Choice accountTypeC;
	TextField accountNumberTF, accountOwnerTF, passwordTF, borrowMoneyTF, depositMoneyTF;
	Button searchAccountB, deleteAccountB, searchOwnerB, enrollB, listAllB;
	TextArea accountList;

	// 생성자 
	private void Main() {

	}

	public MainFrame(String string) {
		super(string);

		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();

		// Label
		accountTypeL = new Label("계좌종류");
		accountNumberL = new Label("계좌번호");
		accountOwnerL = new Label("예금주명");
		passwordL = new Label("비밀번호");
		borrowMoneyL = new Label("대출금액");
		depositMoneyL = new Label("입금금액");
		accountListL = new Label("계좌목록");
		unitL = new Label("(단위 : 원)");

		// Choice
		accountTypeC = new Choice();
		accountTypeC.add("전체");
		accountTypeC.add("입출금계좌");
		accountTypeC.add("마이너스계좌");

		// TextField
		accountNumberTF = new TextField();
		accountOwnerTF = new TextField();
		passwordTF = new TextField();
		passwordTF.setEchoChar('*'); // 비밀번호 * 표시
		borrowMoneyTF = new TextField();
		depositMoneyTF = new TextField();

		// TextArea
		accountList = new TextArea();
		accountList.setBackground(Color.gray);

		// Button
		searchAccountB = new Button("조회");
		searchAccountB.setBackground(Color.gray);
		deleteAccountB = new Button("삭제");
		deleteAccountB.setBackground(Color.GRAY);
		searchOwnerB = new Button("검색");
		searchOwnerB.setBackground(Color.gray);
		enrollB = new Button("신규등록");
		enrollB.setBackground(Color.gray);
		listAllB = new Button("전체조회");
		listAllB.setBackground(Color.gray);

	}

	// getter, setter 메소드 
	public AccountManager getAccountManager() {
		return accountManager;
	}
	
	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

	/**
	 * 정렬하기 
	 * 
	 */
	public void setContents() {
		setLayout(gridBagLayout);

		add(accountTypeL, 		0, 0, 1, 1, 0, 0);
		add(accountTypeC, 		1, 0, 1, 1, 0, 0);
		add(new Label(""), 		2, 0, 1, 1, 0, 0);
		add(new Label(""), 		3, 0, 1, 1, 0, 0);
		add(new Label(""), 		4, 0, 1, 1, 0, 0);
		add(new Label(""), 		5, 0, 1, 1, 0, 0);

		add(accountNumberL,	 	0, 1, 1, 1, 0, 0);
		add(accountNumberTF, 	1, 1, 2, 1, 1, 0);
		add(searchAccountB, 	3, 1, 1, 1, 0, 0);
		add(deleteAccountB, 	4, 1, 1, 1, 0, 0);
		add(new Label(""),		5, 1, 1, 1, 0, 0);
		add(new Label(""),	 	6, 1, 1, 1, 0, 0);

		add(accountOwnerL, 		0, 2, 1, 1, 0, 0);
		add(accountOwnerTF, 	1, 2, 2, 1, 0, 0);
		add(searchOwnerB, 		3, 2, 1, 1, 0, 0);
		add(new Label(""), 		4, 2, 1, 1, 0, 0);
		add(new Label(""), 		5, 2, 1, 1, 0, 0);

		add(passwordL, 			0, 3, 1, 1, 0, 0);
		add(passwordTF, 		1, 3, 2, 1, 0, 0);
		add(depositMoneyL, 		3, 3, 1, 1, 0, 0);
		add(depositMoneyTF, 	4, 3, 2, 1, 0, 0);

		add(borrowMoneyL, 		0, 4, 1, 1, 0, 0);
		add(borrowMoneyTF, 		1, 4, 2, 1, 0, 0);
		add(enrollB, 			3, 4, 1, 1, 0, 0);
		add(listAllB, 			4, 4, 1, 1, 0, 0);
		add(new Label(""), 		5, 4, 1, 1, 0, 0);

		add(accountListL,		0, 5, 1, 1, 0, 0);
		add(new Label(""), 		1, 5, 1, 1, 0, 0);
		add(new Label(""), 		2, 5, 1, 1, 0, 0);
		add(new Label(""), 		3, 5, 1, 1, 0, 0);
		add(new Label(""), 		4, 5, 1, 1, 0, 0);
		add(unitL, 				5, 5, 1, 1, 0, 0);

		add(accountList, 		0, 6, 6, 1, 0, 0);

	}

	
	/**
	 * 화면에 출력하는 값 형식 만들기 
	 * 
	 * @param component 컴포넌트 
	 * @param gridx	x좌표값 
	 * @param gridy y좌표값
	 * @param gridwidth 가로길이
	 * @param gridheight 세로길이
	 * @param weightx x에 대한 가중치
	 * @param weighty y에 대한 가중치 
	 */
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx,
			double weighty) {

		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;

		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		gridBagConstraints.fill = gridBagConstraints.HORIZONTAL;
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
	}

	/**
	 * 종료 기능 
	 * 
	 */
	private void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	/**
	 * 이벤트 추가 기능 
	 * 
	 */
	public void eventRegist() {
		// 종료 버튼 활성화
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});

		// 신규등록 버튼 클릭 시
		enrollB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 마이너스 계좌를 선택했을 때
				if (accountTypeC.getSelectedIndex() == 2) {
					String accountNumber = accountNumberTF.getText();
					String accountOwner = accountOwnerTF.getText();
					String password = passwordTF.getText();
					String borrowMoney = borrowMoneyTF.getText();
					String depositMoney = depositMoneyTF.getText();
					
					// 빈 값이 있을 때 
					if (accountNumber.equals("") || accountOwner.equals("") || password.equals("")
							|| borrowMoney.equals("") || depositMoney.equals("")) {
						accountList.setText("모든 값을 입력해주시기 바랍니다.\n");

					// 올바르게 모든 값이 입력 됐을 때 
					} else {
						accountManager.add(new MinusAccount(accountNumber, accountOwner, Integer.parseInt(password),
								Long.parseLong(depositMoney), Long.parseLong(borrowMoney)));
						accountList.setText("계좌가 개설되었습니다.\n");
					}
				
				// 입출금 계좌를 선택했을 때 
				} else if(accountTypeC.getSelectedIndex()==1) {
					String accountNumber = accountNumberTF.getText();
					String accountOwner = accountOwnerTF.getText();
					String password = passwordTF.getText();
					String depositMoney = depositMoneyTF.getText();
					
					// 빈 값이 있을 때 
					if (accountNumber.equals("") || accountOwner.equals("") || password.equals("")
							|| depositMoney.equals("")) {
						print("모든 값을 입력해주시기 바랍니다.\n");
					
					// 올바르게 모든 값이 입력 됐을 때 
					} else {
						accountManager.add(new Account(accountNumber, accountOwner, Integer.parseInt(password),
								Long.parseLong(depositMoney)));
						print("계좌가 개설되었습니다.\n");
					}
				
				// 전체선택을 했을 때  
				}else {
					print("계좌종류를 선택해주세요.");
				}
			}
		});

		// 예금주명으로 검색 버튼 클릭 시
		searchOwnerB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String accountOwner = accountOwnerTF.getText();
				List<Account> accountLists = accountManager.searchAccount(accountOwner);
				print(accountLists);
			}
		});

		// 삭제 버튼 클릭 시
		deleteAccountB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String accountNumber = accountNumberTF.getText();
				if (accountManager.remove(accountNumber)) {
					accountList.setText("해당 계좌가 삭제되었습니다.\n");
				} else {
					accountList.setText("해당 계좌가 존재하지 않습니다.\n");
				}

			}
		});
		// 전체조회 버튼 클릭 시
		listAllB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Enumeration<Account> accountLists = accountManager.listAll();

				List<Account> accountList = new ArrayList<Account>();
				while (accountLists.hasMoreElements()) {
					Account account = (Account) accountLists.nextElement();
					accountList.add(account);
				}
				print(accountList);

			}
		});

		// 계좌종류 버튼 클릭 시
		accountTypeC.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// 전체 클릭 시 -0
				if (accountTypeC.getSelectedIndex() == 0) {
					borrowMoneyTF.setEnabled(true);
				}
				// 입출금 계좌 클릭 시 -1
				else if (accountTypeC.getSelectedIndex() == 1) {
					borrowMoneyTF.setEnabled(false);
				}
				// 마이너스 계좌 클릭 시 -2
				else if (accountTypeC.getSelectedIndex() == 2) {
					borrowMoneyTF.setEnabled(true);
				}

			}
		});

		// 계좌번호 조회 버튼 클릭 시
		searchAccountB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String accountNumber = accountNumberTF.getText();
				Account account = accountManager.getAccount(accountNumber);
				print(account);

			}
		});
	}

	// 가운데 정렬하기 
	public void setCenter() {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (dim.width - getSize().width) / 2;
		int y = (dim.height - getSize().height) / 2;

		setLocation(x, y);
	}

	// 헤드라인
	public void headLine() {
		accountList.setText("------------------------------------------------------------------------------------\n");
		accountList.append(String.format("계좌종류\t\t%-20s%-20s%-15s%-15s\n", "계좌번호", "예금주명", "현재잔액", "대출금액"));
		accountList.append("==================================================================================\n");

	}

	// 출력 직전 메소드1 - 에러메시지 출력용
	public void print(String message) {
		accountList.setText(message);
	}

	// 출력 직전 메소드2 - 계좌리스트 출력용
	public void print(List<Account> accountList) {
		headLine();
		for (Account account : accountList) {
			this.accountList.append(formatter(account));
		}

	}

	// 출력 직전 메소드3 - 계좌 출력용
	public void print(Account account) {
		headLine();
		String result = formatter(account);
		accountList.append(result);
	}

	

	
	/**
	 * 형식에 맞게 출력하기 
	 * 
	 * @param account 계좌 
	 * @return
	 */
	public String formatter(Account account) {
		Formatter formatter = new Formatter();
		String accountType, borrowMoney;

		if (account instanceof MinusAccount) {
			accountType = "[마이너스]";
			borrowMoney = String.format("%,15d", ((MinusAccount) account).getBorrowMoney());

		} else {
			accountType = "[입출금]";
			borrowMoney = " ";
		}

		accountType = String.format("%-15s", accountType);
		String accountNumber = String.format("%-15s", account.getAccountNum());
		String accountOwner = String.format("%-8s", account.getAccountOwner());
		String restMoney = String.format("%,20d", account.getRestMoney());

		String result = accountType + "\t" + accountNumber + "\t" + accountOwner + "\t" + restMoney + "\t" + borrowMoney
				+ "\n";

		return result;
	}

}

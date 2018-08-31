package kr.or.kosta.boundary;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

/**
 * 화면
 * 
 * @author 최재민
 *
 */
public class MainFrame extends Frame {

	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;

	Label accountTypeL, accountNumberL, accountOwnerL, passwordL, borrowMoneyL, depositMoneyL, resultL, unitL;
	Choice accountTypeC;
	TextField accountNumberTF, accountOwnerTF, passwordTF, borrowMoneyTF, depositMoneyTF;
	Button searchB, deleteB, findB, enrollB, listAllB;
	TextArea result;
	

	public MainFrame() {
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();

		accountTypeL = new Label("계좌종류");
		accountNumberL = new Label("계좌번호");
		accountOwnerL = new Label("예금주명");
		passwordL = new Label("비밀번호");
		borrowMoneyL = new Label("대출금액");
		depositMoneyL = new Label("입금금액");
		resultL = new Label("계좌목록");

		unitL = new Label("(단위 : 원)");
		accountTypeC = new Choice();
		accountTypeC.add("전체");
		accountTypeC.add("입출금계좌");
		accountTypeC.add("마이너스계좌");

		accountNumberTF = new TextField(1);
		accountOwnerTF = new TextField(1);
		passwordTF = new TextField(1);
		borrowMoneyTF = new TextField(1);
		depositMoneyTF = new TextField(1);

		result = new TextArea(1, 1);

		searchB = new Button("조회");
		deleteB = new Button("삭제");
		findB = new Button("검색");
		enrollB = new Button("신규등록");
		listAllB = new Button("전체조회");

		setContents();
	}

	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx,
			double weighty) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;

//		gridBagConstraints.fill = gridBagConstraints.HORIZONTAL;
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);

	}

	public void setContents() {
		setLayout(gridBagLayout);

		add(accountTypeL, 	    0, 0, 1, 1, 0, 0);
		add(accountTypeC, 		1, 0, 1, 1, 0, 0);
		add(new Label(" "), 	2, 0, 1, 1, 0, 0);
		add(new Label(" "),	 	3, 0, 1, 1, 0, 0);
		add(new Label(" "),	 	4, 0, 1, 1, 0, 0);
		add(new Label(" "), 	5, 0, 1, 1, 0, 0);

		add(accountNumberL, 	0, 1, 1, 1, 0, 0);
		add(accountNumberTF,	1, 1, 2, 1, 0, 0);
		add(searchB, 			3, 1, 1, 1, 0, 0);
		add(deleteB, 			4, 1, 1, 1, 0, 0);
		add(new Label(" "), 	5, 1, 1, 1, 0, 0);

		add(accountOwnerL, 		0, 2, 1, 1, 0, 0);
		add(accountOwnerTF, 	1, 2, 2, 1, 0, 0);
		add(findB,				3, 2, 1, 1, 0, 0);
		add(new Label(" "), 	4, 2, 1, 1, 0, 0);
		add(new Label(" "), 	5, 2, 1, 1, 0, 0);

		add(passwordL,			0, 3, 1, 1, 0, 0);
		add(passwordTF, 		1, 3, 2, 1, 0, 0);
		add(depositMoneyL, 		3, 3, 1, 1, 0, 0);
		add(depositMoneyTF, 	4, 3, 2, 1, 0, 0);

		add(borrowMoneyL, 		0, 4, 1, 1, 0, 0);
		add(borrowMoneyTF, 		1, 4, 2, 1, 0, 0);
		add(enrollB, 			3, 4, 1, 1, 0, 0);
		add(listAllB, 			4, 4, 1, 1, 0, 0);
		add(new Label(" "), 	5, 4, 1, 1, 0, 0);
	}

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setContents();
		frame.setSize(400, 600);
		frame.setVisible(true);
		
		
		
	}

}

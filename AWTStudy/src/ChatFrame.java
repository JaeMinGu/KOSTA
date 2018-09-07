import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class ChatFrame extends Frame {

	Label serverL;
	TextField serverTF, inputTF;
	Button connectB, sendB;
	TextArea messageTA;
	java.awt.List userList;

	MenuBar menuBar;
	Menu menu;
	MenuItem newMI, exitMI;

	public ChatFrame() {
		this("이름없음");
	}

	public ChatFrame(String title) {
		super(title);
		serverL = new Label("서버");
		serverTF = new TextField();
		inputTF = new TextField(30);
		connectB = new Button("연결") /*
									 * {
									 * 
									 * @Override public void paint(Graphics g) { g.drawLine(10, 10, 50, 10); } }
									 */; // 이름 없는 지역 내부 클래스
		sendB = new Button("전송");
		messageTA = new TextArea();
		userList = new java.awt.List();
		userList.add("말미잘");
		userList.add("꼴뚜기");
		userList.add("머저리");

		menuBar = new MenuBar();
		menu = new Menu("File");
		newMI = new MenuItem("New");
		newMI.setShortcut(new MenuShortcut(KeyEvent.VK_N)); // 단축키 설정 표시만 되어 있음, 이벤트 처리는 아직. 
		exitMI = new MenuItem("Exit");
		exitMI.setShortcut(new MenuShortcut(KeyEvent.VK_X)); 
	}

	/**
	 * 화면 배치
	 */
	public void setContents() {

//		connectB.setEnabled(false);
		connectB.setEnabled(true);
		connectB.setBackground(new Color(100, 50, 120));
		connectB.setBackground(Color.BLUE);
		connectB.setForeground(Color.WHITE);

//		connectB.setFont(new Font("궁서", Font.BOLD, 20));

		Panel northP = new Panel();
		northP.setLayout(new BorderLayout());

		northP.add(serverL, BorderLayout.WEST);
		northP.add(serverTF, BorderLayout.CENTER);
		northP.add(connectB, BorderLayout.EAST);

		Panel southP = new Panel();
		southP.add(inputTF, BorderLayout.CENTER);
		southP.add(sendB, BorderLayout.EAST);

		add(northP, BorderLayout.NORTH);
		add(messageTA, BorderLayout.CENTER);
		add(userList, BorderLayout.EAST);
		add(southP, BorderLayout.SOUTH);

		this.setLocation(100, 100);

//		setColorAll(Color.blue);
		
		setMenuBar(menuBar); // frame에 menuBar 붙임
		menuBar.add(menu); // menuBar에 menu를 붙임 
		menu.add(newMI); //menu에 newMI 붙임
		menu.addSeparator(); // 구분선 추가 
		menu.add(exitMI); //menu에 exitMI 붙임
		
	}


	public void setCenter() {
//		Runtime.getRuntime().exec(command)
		Toolkit.getDefaultToolkit().beep();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//		System.out.println(dim.toString());

		int x = (dim.width - getSize().width) / 2;
		int y = (dim.height - getSize().height) / 2;
		setLocation(x, y);
	}

	private void setColorAll(Color bg) {
		Component[] components = getComponents();
		for (Component component : components) {
			if (component instanceof Panel) {
				Component[] cs = ((Panel) component).getComponents();
				for (Component c : cs) {
					c.setBackground(bg);
				}
			}
			component.setBackground(bg);
		}
	}

	/**
	 * 종료
	 */
	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	public void appendMessage() {
		String message = inputTF.getText();
//		messageTA.setText(message); // 맨 윗줄 덮어씀 
		messageTA.append(message + "\n"); // 추가
		inputTF.setText("");
	}

	public void eventRegist() {
		/** 이름 있는 지역 내부 클래스, Local Inner Class */
		/*
		 * class Exiter extends WindowAdapter {
		 * 
		 * @Override public void windowClosing(WindowEvent e) { finish(); }
		 * 
		 * }
		 */

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});

		inputTF.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appendMessage();
			}
		});

		serverTF.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
//				System.out.println(e.getKeyCode());
				System.out.println(e.getKeyChar());
//				System.out.println(KeyEvent.VK_9);
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

		inputTF.addTextListener(new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				System.out.println(inputTF.getText());
			}
		});

		userList.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String name = userList.getSelectedItem();
					JOptionPane.showMessageDialog(null, name + "님 선택이요..", "알림", JOptionPane.INFORMATION_MESSAGE); // 나중에
																													// 복사해서
																													// 쓰기,
																													// 꼭
																													// 몰라도
																													// 됨
					JOptionPane.showMessageDialog(null, name + "님 선택이요..", "알림", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// exitMI(Ctrl+x) 이벤트 걸어주기 
		exitMI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				finish();
			}
		});

	}

	/** 멤버 내부 클래스를 이용한 이벤트 처리, Inner Class */
	/*
	 * class Exiter extends WindowAdapter {
	 * 
	 * @Override public void windowClosing(WindowEvent e) { finish(); } }
	 */

	public static void main(String[] args) {
		ChatFrame frame = new ChatFrame("Kotalk");
		frame.setContents();
		frame.setSize(400, 600);
		frame.setCenter();
		frame.setVisible(true);
		frame.eventRegist();

	}

}

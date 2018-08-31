import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TalkFrame extends Frame implements WindowListener {
	LoginPanel loginPanel;
	MainPanel mainPanel;

	Panel cardPanel;
	CardLayout cardLayout;

	public TalkFrame() {
		this("이름없음");
	}

	public TalkFrame(String title) {
		super(title);
		loginPanel = new LoginPanel(this);
		mainPanel = new MainPanel(this);

		cardPanel = new Panel();
		cardLayout = new CardLayout();

	}

	// 화면 배치
	public void setContents() {

		cardPanel.setLayout(cardLayout);
		cardPanel.add("LOGIN", loginPanel);
		cardPanel.add("MAIN", mainPanel);

		this.add(cardPanel, BorderLayout.CENTER);

	}

	// 화면 중앙 배치
	public void setCenter() {
		Toolkit.getDefaultToolkit().beep();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (dim.width - getSize().width) / 2;
		int y = (dim.height - getSize().height) / 2;
		setLocation(x, y);
	}

	// 카드 교체
	public void changeCard(String name) {
		cardLayout.show(cardPanel, name);
	}

	// 종료
	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);

	}

	public void eventRegister() {
		addWindowListener(this);
	}

	// 메인 메소드
	public static void main(String[] args) {

		TalkFrame frame = new TalkFrame("Kotalk");
		frame.setCenter();
		frame.setSize(300, 500);
		frame.setContents();
		frame.setVisible(true);
		frame.eventRegister();
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		finish();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

}

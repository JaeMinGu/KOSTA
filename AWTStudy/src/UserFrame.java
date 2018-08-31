import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.EventListener;

public class UserFrame extends Frame implements MouseListener, WindowListener {
//	String title;
	Button eButton, wButton, sButton, nButton, cButton;

	public UserFrame() {
		this("이름없음");
	}

	public UserFrame(String title) {
		super(title);
		this.eButton = new Button("East");
		this.wButton = new Button("West");
		this.sButton = new Button("South");
		this.nButton = new Button("North");
		this.cButton = new Button("Center");
	}

	// 화면배치
	public void setContents() {
		// LayoutManager 교체
		setLayout(new FlowLayout());
		add(eButton, BorderLayout.EAST);
		add(wButton, BorderLayout.WEST);
		add(sButton, BorderLayout.SOUTH);
		add(nButton, BorderLayout.NORTH);
		add(cButton, BorderLayout.CENTER);

	}

	// 이벤트 소스에 이벤트리스너 연결
	public void eventRegist() {
		eButton.addMouseListener(this);
		wButton.addMouseListener(this);
		sButton.addMouseListener(this);
		nButton.addMouseListener(this);
		cButton.addMouseListener(this);
		addWindowListener(this);
	}

	public static void main(String[] args) {
		UserFrame frame = new UserFrame("windowTitle");
		frame.setContents();
		frame.eventRegist();
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		System.out.println("마우스 클릭되었습니다.");
//		eButton.
		Object eventSource = e.getSource();
		int r = (int) (Math.random() * 256);
		int g = (int) (Math.random() * 256);
		int b = (int) (Math.random() * 256);
		Button button = (Button) eventSource;
		button.setBackground(new Color(r, g, b));

		if (eventSource == eButton) {
			System.out.println("East 클릭이요...");
		} else if (eventSource == wButton) {
			System.out.println("West 클릭이요...");

		} else if (eventSource == sButton) {
			System.out.println("South 클릭이요...");

		} else if (eventSource == nButton) {
			System.out.println("North 클릭이요...");

		} else {
			System.out.println("Center 클릭이요...");

		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered() Called...");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited() Called...");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed() Called....");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased() Called....");

	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		setVisible(false); // 창 사라지게 함 
		dispose(); // OS에 그래픽리소스 반납 
		System.exit(0);
		
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
		System.out.println("창이 열렸습니다...");
	}
}

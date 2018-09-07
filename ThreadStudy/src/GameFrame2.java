import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameFrame2 extends Frame implements Runnable {

	
	
	
	int xRabbit = 50, xTurtle = 50, distanceRabbit = 40, distanceTurtle = 2;

	Image unitRabbit, unitTurtle;
	Toolkit toolkit;

	public GameFrame2(String title) {
		super(title);
		toolkit = Toolkit.getDefaultToolkit();
		unitRabbit = toolkit.getImage("C:\\KOSTA187\\설치프로그램\\rabbit.png");
		unitTurtle = toolkit.getImage("C:\\KOSTA187\\설치프로그램\\turtle.png");
	}

	public void setContens() {

	}

	/**
	 * 이벤트 등록
	 */
	public void eventRegist() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				gameStart();
				super.windowOpened(e);
			}

			@Override
			public void windowClosing(WindowEvent e) {
				finish();
				super.windowClosing(e);
			}
		});

	}

	/**
	 * 시작
	 */
	public void gameStart() {
		Thread thread = new Thread(this);
		thread.start();

	}

	/**
	 * 종료
	 */
	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
//		g.fillOval(x, 100, 80, 80);
		g.drawImage(unitRabbit, xRabbit, 50, this);
		g.drawImage(unitTurtle, xTurtle, 300, this);
	}

	/*
	 * run 메소드
	 * 
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() { // Thread의 main 역할
		Random random = new Random();
		while (true) {
			xRabbit += distanceRabbit;
			xTurtle += distanceTurtle;
			repaint();
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

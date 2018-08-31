import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends Panel implements ActionListener {
	TalkFrame talkFrame;

	Label tempL;
	Button logoutB;

	public MainPanel(TalkFrame talkFrame) {
		this.talkFrame = talkFrame;
		tempL = new Label("This is Test Panel", Label.CENTER);
		logoutB = new Button("LOGOUT");

		setContents();

		logoutB.addActionListener(this);
	}

	private void setContents() {
		this.setLayout(new BorderLayout());
		Panel panel = new Panel();
		panel.add(logoutB);

		this.add(tempL, BorderLayout.CENTER);
		this.add(panel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		talkFrame.changeCard("LOGIN");

	}

//	public static void main(String[] args) {
//		Frame frame = new Frame(); 
//		MainPanel mainPanel = new MainPanel(); 
//		
//		frame.add(mainPanel);
//		frame.setSize(300, 500);
//		frame.setVisible(true);
//		
//	}
}

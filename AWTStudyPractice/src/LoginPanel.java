import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends Panel implements ActionListener{
	TalkFrame talkFrame;
	
	Label emailL, passwdL;
	TextField emailTF, passwdTF; 
	Button loginB, registB; 
	

	GridBagLayout gridBagLayout; 
	GridBagConstraints gridBagConstraints;
	
	public LoginPanel(TalkFrame talkFrame) {
		this.talkFrame = talkFrame;
		emailL = new Label("EMAIL");
		passwdL = new Label("PASSWD"); 
		emailTF = new TextField();
		passwdTF = new TextField();
		passwdTF.setEchoChar('*'); // 비밀번호 * 표시 
		loginB = new Button("LOGIN");
		registB = new Button("REGIST");
		
		gridBagLayout = new GridBagLayout(); 
		gridBagConstraints = new GridBagConstraints(); 

		setContents();
		
		loginB.addActionListener(this);
		
		
	}
	
	public void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty) {
		gridBagConstraints.gridx = gridx; 
		gridBagConstraints.gridy = gridy; 
		gridBagConstraints.gridwidth = gridwidth; 
		gridBagConstraints.gridheight = gridheight; 
		gridBagConstraints.weightx = weightx; 
		gridBagConstraints.weighty = weighty; 
		
		gridBagConstraints.fill = gridBagConstraints.HORIZONTAL; 
//		gridBagConstraints.insets = new Insets(4, 1, 4, 1);
		
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component); 
	}
	
	private void setContents() {
		setLayout(gridBagLayout);
		add(new Label(""), 0, 0, 1, 1, 0, 0);
		add(emailL, 1, 0, 1, 1, 0, 0);
		add(emailTF, 2, 0, 1, 1, 1, 0);		
		add(new Label(""), 3, 0, 1, 1, 0, 0);
		
		add(new Label(""), 0, 1, 1, 1, 0, 0);
		add(passwdL, 1, 1, 1, 1, 0, 0);
		add(passwdTF, 2, 1, 1, 1, 0, 0);
		add(new Label(""), 3, 1, 1, 1, 0, 0);
	
		Panel buttonPanel = new Panel();
		buttonPanel.add(loginB);
		buttonPanel.add(registB);
		add(buttonPanel, 0, 2, 3, 1, 0, 0);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		talkFrame.changeCard("MAIN");
	}
	
	
//	public static void main(String[] args) {
//		Frame frame = new Frame(); 
//		LoginPanel loginPanel = new LoginPanel(); 
//		
//		frame.add(loginPanel);
//		frame.setSize(300, 500);
//		frame.setVisible(true);
//	}
	
	
}

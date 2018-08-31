import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class GridBagLayoutExample extends Panel {
	Label receiverL, fileL, titleL;
	TextField receiverTF, fileTF, titleTF;
	Button searchB, sendB, cancelB;
	TextArea messageTA;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints; 

	public GridBagLayoutExample() {
		
		receiverL = new Label("받는사람");
		fileL = new Label("첨부파일");
		titleL = new Label("제목");
		receiverTF = new TextField();
		fileTF = new TextField();
		titleTF = new TextField();
		searchB = new Button("찾기");
		sendB = new Button("보내기");
		cancelB = new Button("취소");
		messageTA = new TextArea();
		
		gridBagLayout = new GridBagLayout(); 
		gridBagConstraints = new GridBagConstraints(); 
	}
	
	public void setContents() {
		setLayout(gridBagLayout); 
		
		add(receiverL, 0, 0, 1, 1, 0, 0);
		add(receiverTF, 1, 0, 1, 1, 0, 0);
		add(fileL, 0, 1, 1, 1, 0, 0);
		add(fileTF, 1, 1, 1, 1, 0, 0);

		
	}
	
	public void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty) {
		gridBagConstraints.gridx = gridx; 
		gridBagConstraints.gridy = gridy; 
		gridBagConstraints.gridwidth = gridwidth; 
		gridBagConstraints.gridheight = gridheight;
		gridBagConstraints.weightx = weightx; 
		gridBagConstraints.weighty = weighty; 
		
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
	}
	
	
	
	public static void main(String[] args) {
		Frame frame = new Frame(); 
		GridBagLayoutExample panel = new GridBagLayoutExample(); 

		panel.setContents();
		frame.add(panel);
		frame.setSize(400, 400);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	

}

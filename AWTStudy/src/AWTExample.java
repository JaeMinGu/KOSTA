import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

public class AWTExample {
	public static void main(String[] args) {

		Frame frame = new Frame("firstMadeFrame");
		frame.setSize(1000, 800);
		frame.setVisible(true);

		Button button1 = new Button("AWT Button");
		Button button2 = new Button("AWT Button");
		Button button3 = new Button("AWT Button");
		Button button4 = new Button("AWT Button");
		Button button5 = new Button("AWT Button");
		Button button6 = new Button("AWT Button");
		Button button7 = new Button("AWT Button");

		frame.setLayout(new FlowLayout());
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.add(button5);
		frame.add(button6);
		frame.add(button7);

//		frame.setResizable(false);

		Label label = new Label("AWT Label");
		frame.add(label);

		TextField field = new TextField("ID", 10);
		frame.add(field);

		TextArea area = new TextArea(5, 20);
		frame.add(area);

		Checkbox checkbox1 = new Checkbox("man", true);
		Checkbox checkbox2 = new Checkbox("woman", true);
		frame.add(checkbox1);
		frame.add(checkbox2);

		CheckboxGroup cg = new CheckboxGroup();

		Checkbox cb1 = new Checkbox("male", true, cg);
		Checkbox cb2 = new Checkbox("female", false, cg);
		frame.add(cb1);
		frame.add(cb2);
		
		Choice selectBox = new Choice(); 
		selectBox.add("박찬호");
		selectBox.add("박지성");
		selectBox.add("박찬숙");
		frame.add(selectBox); 
		
		
		
	}
}

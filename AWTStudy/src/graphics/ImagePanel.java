package graphics;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

public class ImagePanel extends Panel {

	Button button;

	Image background;

	public ImagePanel() {
		button = new Button("TEST Button");

		background = Toolkit.getDefaultToolkit().getImage("classes/resource/if_computer_103447.png");
		setLayout(new FlowLayout());
		add(button);
	}
	
	@Override
	public void paint(Graphics g) {
//		super.paint(g);
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this); // Component는 imageObserver 가능 
	}
	
	public static void main(String[] args) {
		Frame frame = new Frame(); 
		ImagePanel panel = new ImagePanel(); 
		
		frame.add(panel);
		frame.setSize(500, 600);
		frame.setVisible(true);
	}

}

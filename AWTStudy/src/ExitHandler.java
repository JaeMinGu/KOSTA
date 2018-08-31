import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExitHandler extends WindowAdapter {

	ChatFrame frame;

	public ExitHandler(ChatFrame frame) {
		this.frame = frame;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		frame.finish();
	}

}

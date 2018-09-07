import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.WindowAdapter;

public class ContainerExample {

	public static void main(String[] args) {

		Frame owner = new Frame(); // Dialog 단독적으로 사용 불가, Frame이 있어야 함
		owner.setSize(400, 200);
		owner.setVisible(true);

		Dialog dialog = new Dialog(owner, "타이틀", true);  // modal(true): 창 떠있을 때 다른 대화상자 선택
		dialog.setSize(200, 200);
		dialog.setVisible(true);

		Window window = new Window(owner);
		window.setSize(400, 200);
		window.setVisible(true);
		
//		FileDialog fileDialog = new FileDialog(owner, "파일열기", FileDialog.LOAD);
		FileDialog fileDialog = new FileDialog(owner, "파일저장", FileDialog.SAVE);
		fileDialog.setVisible(true);
	}

}

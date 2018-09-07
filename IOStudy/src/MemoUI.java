import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MemoUI extends Frame {
	MemoDAO dao;
	FileDialog dialogSave, dialogLoad; 

	// 인스턴스 변수
	TextArea memoPadTA; // 메모장 바디부분
	MenuBar menuBarMB; // 상단 메뉴바
	Menu fileM; // 상단 메뉴
	MenuItem newMI, loadMI, saveMI; // 메뉴 - 파일

	// 생성자
	public MemoUI() {
		this("이름없음");
	}

	public MemoUI(String title) throws HeadlessException {
		super(title);

		memoPadTA = new TextArea();
		menuBarMB = new MenuBar();
		fileM = new Menu("파일");
		newMI = new MenuItem("새로 만들기");
		newMI.setShortcut(new MenuShortcut(KeyEvent.VK_N));
		loadMI = new MenuItem("열기");
		loadMI.setShortcut(new MenuShortcut(KeyEvent.VK_O));
		saveMI = new MenuItem("저장");
		saveMI.setShortcut(new MenuShortcut(KeyEvent.VK_S));

		dialogSave = new FileDialog(this, "저장", FileDialog.SAVE);
		dialogLoad = new FileDialog(this, "열기", FileDialog.SAVE);

	}

	
	public String getMemoPadTA() {
		return memoPadTA.getText(); 
	}

	
	// 기능추가 
	public void setContens() {

		setMenuBar(menuBarMB);
		menuBarMB.add(fileM);
		fileM.add(newMI);
		fileM.addSeparator();
		fileM.add(loadMI);
		fileM.addSeparator();
		fileM.add(saveMI);

//		MemoUI memoUI = new MemoUI();
		add(memoPadTA);
		memoPadTA.setEditable(true);
	}

	/**
	 * 이벤트 추가
	 */
	public void eventRegist() {
		// 종료버튼 활성화
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});

		// 새로만들기 버튼 클릭
		newMI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				memoPadTA.setText(" ");

			}
		});

		// 열기 버튼 클릭
		loadMI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialogLoad.setVisible(true);
				
				
			}
		});

		// 저장하기 버튼 클릭
		saveMI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				dialogSave.setVisible(true);
				String dir = dialogSave.getDirectory();
				String file = dialogSave.getFile();
				String path = dir+file;
				
				MemoDAO tempDAO = new MemoDAO();
				tempDAO.save(memoPadTA.getText(),path);
				
				
			}
		});
		//

	}

	// 종료
	private void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

}

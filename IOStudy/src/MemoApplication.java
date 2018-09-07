
public class MemoApplication {
	public static void main(String[] args) {

		
		MemoUI memoUI = new MemoUI("메모장");
		memoUI.setSize(500, 400);
		memoUI.eventRegist();
		memoUI.setContens();
		memoUI.setVisible(true);

	}
}

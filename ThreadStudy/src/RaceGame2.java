/**
 * 게임화면
 * 
 * @author 최재민
 *
 */
public class RaceGame2 {

	public static void main(String[] args) {
		GameFrame frame = new GameFrame("경주게임");
		frame.setSize(800, 600);
		frame.eventRegist();
		frame.setVisible(true);
	}
}

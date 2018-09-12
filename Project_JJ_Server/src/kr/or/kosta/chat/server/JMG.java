package kr.or.kosta.chat.server;

public class JMG {

	public static void main(String[] args) {

		JJ_ChatServer chatServer = new JJ_ChatServer();
		try {
			chatServer.startUp();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

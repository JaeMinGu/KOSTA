package kr.or.kosta.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import javax.sound.sampled.Port;

import kr.or.kosta.common.Protocol;

/**
 * 
 * @author 최재민
 *
 */
public class JJ_ChatServer {
	private static final int PORT = 8888;

	private boolean running;
	private ServerSocket serverSocket;
	private Hashtable<String, JJ_Client> clients;
	private JJ_WaitingRoom waitingRoom;
	private static int roomNumber = 3;

	public JJ_ChatServer() {
		clients = new Hashtable<>();
		clients.put("소시지", new JJ_Client("소시지"));
		clients.put("별", new JJ_Client("별"));
		clients.put("사탕", new JJ_Client("사탕"));
		waitingRoom = new JJ_WaitingRoom(this);

	}

	public static int getPort() {
		return PORT;
	}

	public boolean isRunning() {
		return running;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public Hashtable<String, JJ_Client> getClients() {
		return clients;
	}

	public JJ_WaitingRoom getWaitingRoom() {
		return waitingRoom;
	}

	/**
	 * 닉네임 생성 조건에 맞는 닉네임인지 확인
	 * 
	 * @param nickName
	 * @return
	 */
	public boolean isValidNickName(String nickName) {
		return false;
	}

	/**
	 * Server를 시작
	 * 
	 * @throws IOException
	 * 
	 */
	public void startUp() throws IOException {
		Socket socket;
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			throw new IOException("[" + PORT + "] 포트 충돌이 일어났습니다. ");
		}
		running = true;

		System.out.println("JMG[" + PORT + "] 포트 시작");

		while (running) {
			try {
				socket = serverSocket.accept();
				JJ_Client client = new JJ_Client(socket, this);
				client.start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * Client 추가(입장)
	 * 
	 * @param client
	 * @return
	 */
	public void addClient(JJ_Client client) {
		clients.put(client.getNickName(), client);
	}

	/**
	 * 닉네임 중복확인
	 * 
	 * @param nickName
	 * @return
	 */
	public boolean isExistNickName(String nickName) {
		return clients.containsKey(nickName);
	}

	/**
	 * 전체 사용자 수 반환
	 * 
	 * @return
	 */
	public int getAllClientCount() {
		return clients.size();
	}

	/**
	 * 전체 사용자 리스트 반환
	 * 
	 * @return
	 */
	public List<String> getAllClientList() {

		List<String> list = new ArrayList<String>();
		String nickName = null;
		Enumeration<JJ_Client> e = clients.elements();
		while (e.hasMoreElements()) {
			JJ_Client client = e.nextElement();
			nickName = client.getNickName();
			list.add(nickName);
		}
		return list;
	}

	/**
	 * 해당 채팅방의 사용자 수 반환
	 * 
	 * @return
	 */
	public int getClientCount() {
		return 0;
	}

	/**
	 * 채팅방 이름 중복확인
	 * 
	 * @param chatRoomName
	 * @return
	 */
	public boolean checkChatRoomName(String chatRoomName) {
//		if(waitingRoom.getChatRooms().containsKey(chatRoomName)) {
		if (waitingRoom.getChatRoomNames().contains(chatRoomName)) {
			return true; // 이미 존재하는 채팅방 이름이 있음
		}
		return false; // 채팅방 이름 사용 가능함
	}

	/**
	 * 종료
	 * 
	 * @param client
	 */
	public void removeClient(JJ_Client client) {
		clients.remove(client.getNickName());

	}

	/**
	 * Socket 없애기
	 */
	public void shutDown() {

	}

	/**
	 * 현재 활성화된 채팅방 리스트 반환
	 * 
	 * @return
	 */
	public List<JJ_ChatRoom> getActiveChatRoomList() {
		List<JJ_ChatRoom> activeChatRoomList = new ArrayList<>();
		activeChatRoomList = waitingRoom.getActiveChatRoomList();
		return activeChatRoomList;
	}

	/**
	 * 채팅방 추가
	 * 
	 * @param newChatRoomName
	 * @param newChatRoomOwner
	 * @param newChatRoomCapacity
	 */
	public void addChatRoom(String newChatRoomName, String newChatRoomOwner, int newChatRoomCapacity) {
		waitingRoom.addChatRoom(++roomNumber, newChatRoomName, newChatRoomOwner, newChatRoomCapacity);
	}

	/**
	 * 해당 채팅방의 client 리스트 반환
	 */
	public List<String> getActiveChatRoomClientList(String nickName) {
		List<String> clientList = new ArrayList<>();
		clientList.addAll(waitingRoom.getActiveChatRoomClientList(nickName));
		return clientList;
	}

	/**
	 * 해당 채팅방 정보 반환
	 * 
	 * @param roomName
	 */
	public List<String> getAtiveChatRoom(String roomName) {
		// client 리스트 반환
//		List<String> list = new ArrayList<>(); 
//		list.addAll(waitingRoom.getActiveChatRoomClientList(roomName));
		return waitingRoom.getActiveChatRoomClientList(roomName);
	}

	/**
	 * 해당 채팅방에 Client 추가하기
	 * 
	 * @param string
	 * @param string2
	 * @param jj_Client
	 */
	public boolean addClientToChatRoom(String nickName, String roomName) {
		if (waitingRoom.addClientToChatRoom(nickName, roomName)) {
			return true;
		}
		return false;

	}

	/**
	 * 방장 채팅방에 추가하기
	 */
	public void addRoomOwnerToChatRoom(String roomName, String roomOwner) {
		waitingRoom.chatRooms.get(roomName).addClient(roomOwner);
	}

	/**
	 * 모든 클라이언트에게 이벤트 보내기
	 */
	public void sendAllMessage(String message) {
		Enumeration<JJ_Client> e = clients.elements();
		while (e.hasMoreElements()) {
			JJ_Client client = e.nextElement();
			client.sendMessage(message);
		}
	}

	/**
	 * 채팅시작하기
	 * 
	 * @param string
	 * @param string2
	 */
	public void startRoomChat(String nickName, String message) {
		// nickName을 활용해서 해당 채팅방을 찾아야 함
		JJ_ChatRoom chatRoom = waitingRoom.getChatRoom(nickName);
		// 그 채팅방에 있는 사람들을 찾아야 함
		List<String> roomUsers = chatRoom.getClientNickNames();
		// 그 사람들한테 message를 뿌려야 함
		for (String nickNames : roomUsers) {
			clients.get(nickNames).sendMessage(
					Protocol.SC_ROOM_CHAT_RESULT + Protocol.DELEMETER + nickName + Protocol.DELEMETER + message);
		}
		// List<String> roomUser = waitingRoom.getChatUserName(nickName);
		// 들어온 nickName이 있는 채팅방 찾기
//		waitingRoom.getActiveChatRoomName();
		// 채팅 입력 필요!!
//		for (String string : roomUsers) {
//			clients.get(string).sendMessage(Protocol.SC_ROOM_CHAT_RESULT + Protocol.DELEMETER + nickName + Protocol.DELEMETER + message);
//		}

		// 그 채팅방에 있는 사람들이 누구인지 찾기
		// 그 사람들한테 들어온 message 보내주기
	}

	/**
	 * 대기방 말고 특정 채팅방에만 userList 업데이트 해주기 
	 * 
	 * @param nickName
	 */
	public void sendToSpecificRoom(String nickName) {
		JJ_ChatRoom chatRoom = waitingRoom.getChatRoom(nickName);
		List<String> users = chatRoom.getClientNickNames();
		for (String userList : users) {
			clients.get(userList).sendMessage(Protocol.SC_UPDATE_ROOM_USER + Protocol.DELEMETER + users);
		}
	}
}

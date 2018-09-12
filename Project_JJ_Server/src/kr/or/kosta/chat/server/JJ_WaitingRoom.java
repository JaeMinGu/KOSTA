package kr.or.kosta.chat.server;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 * 
 * @author 최재민
 *
 */
public class JJ_WaitingRoom {

	JJ_ChatServer server;
	Hashtable<String, JJ_ChatRoom> chatRooms;

	public JJ_WaitingRoom() {

	}

	public JJ_WaitingRoom(JJ_ChatServer server) {
		this.server = server;
		chatRooms = new Hashtable<>();

		chatRooms.put("멍텅구리1", new JJ_ChatRoom(1, "멍텅구리1", "소시지", 6));
		
		chatRooms.put("멍텅구리2", new JJ_ChatRoom(2, "멍텅구리2", "사탕", 3));
		chatRooms.put("멍텅구리3", new JJ_ChatRoom(3, "멍텅구리3", "별", 5));
		
		chatRooms.get("멍텅구리1").addClient("소시지");
		chatRooms.get("멍텅구리1").addClient("치약");
		chatRooms.get("멍텅구리1").addClient("물통");

		chatRooms.get("멍텅구리2").addClient("사탕");
		chatRooms.get("멍텅구리3").addClient("별");

		
	}

	/**
	 * 사용자 수 반환
	 * 
	 * @return
	 */
	public int getClientCount() {
		return 0;
	}

	/**
	 * 현재 활성화 된 채팅방 수 반환
	 * 
	 * @return
	 */
	public int getChatActiveRoomCount() {

		return 0;
	}

	/**
	 * 현재 활성화 된 채팅방 반환
	 * 
	 * @return
	 */
	public List<JJ_ChatRoom> getActiveChatRoomList() {
		List<JJ_ChatRoom> chatRoomList = new ArrayList<>();
		Enumeration<JJ_ChatRoom> e = chatRooms.elements();
		while (e.hasMoreElements()) {
			JJ_ChatRoom chatRoom = e.nextElement();
			chatRoomList.add(chatRoom);
		}
		if (chatRoomList.size() != 0) {
			return chatRoomList;
		}
		return null;
	}

	/**
	 * 채팅방 이름 반환
	 * 
	 * @return
	 */
	public List<String> getChatRoomNames() {
		List<String> chatRoomNameList = new ArrayList<>();
		Enumeration<String> e = chatRooms.keys(); // 채팅방 이름으로 검색 
		while (e.hasMoreElements()) {
			String keys = e.nextElement();
			chatRoomNameList.add(keys);
		}
		return chatRoomNameList;
	}

	/**
	 * 채팅방 객체 반환
	 * 
	 * @return
	 */
	public Hashtable<String, JJ_ChatRoom> getChatRooms() {
		return chatRooms;
	}

	/**
	 * 방 번호 반환
	 * 
	 * @return
	 */
	public int getChatRoomNum() {
		return 0;
	}

	/**
	 * 방장 반환
	 * 
	 * @return
	 */
	public String getChatRoomOwner() {
		return null;
	}

	/**
	 * 채팅방 내 사용자들 반환
	 * 
	 * @param chatRoomName
	 * @return
	 */
	public List getClientNames(String chatRoomName) {
		return null;
	}

	/**
	 * 채팅방 크기 설정 시 유효한 값 여부 확인
	 * 
	 * @return
	 */
	public boolean isValidChatRoomCapacity(Object object) {
		return false;
	}

	/**
	 * 새로운 채팅방 추가
	 * 
	 * @param newChatRoomNumber
	 * @param newChatRoomName
	 * @param newChatRoomOwner
	 * @param newChatRoomCapacity
	 */
	public void addChatRoom(int newChatRoomNumber, String newChatRoomName, String newChatRoomOwner,
			int newChatRoomCapacity) {
		chatRooms.put(newChatRoomName,
				new JJ_ChatRoom(newChatRoomNumber, newChatRoomName, newChatRoomOwner, newChatRoomCapacity));
	}
	
	public JJ_ChatRoom getChatRoom(String nickName) {
		JJ_ChatRoom tempRoom = null;
		Enumeration<JJ_ChatRoom> tempRooms = chatRooms.elements();
		while (tempRooms.hasMoreElements()) {
			JJ_ChatRoom jj_ChatRoom = (JJ_ChatRoom) tempRooms.nextElement();
			if(jj_ChatRoom.getFindUserRoom(nickName)) {
				tempRoom = jj_ChatRoom;
				break;
			}
		}
		return tempRoom;
	}
	
	/**
	 * client가 들어있는 방의 유저들을 return
	 */
	public List<String> getChatUserName(String nickName) {
		//해당 방의 유저를 return
		return getChatRoom(nickName).getClientNickNames();
		
	}
	
	/**
	 * 해당 채팅방 client 리스트 보여주기
	 * 
	 * @param roomName
	 */
	public List<String> getActiveChatRoomClientList(String roomName) {
//		List<String> clientNickNamelist = new ArrayList<>();
		JJ_ChatRoom chatRoom = chatRooms.get(roomName);
//		clientNickNamelist.addAll(chatRoom.getClientNickNames());
		return chatRoom.getClientNickNames(); 
	}
	
	/**
	 * 채팅방에 Client 입장
	 */
	public boolean addClientToChatRoom(String nickName, String roomName) {
		if(chatRooms.get(roomName).getClientCount() <  chatRooms.get(roomName).getRoomCapacity()) {
			chatRooms.get(roomName).addClient(nickName);
			return true; 
		}
		return false; 
	}

}

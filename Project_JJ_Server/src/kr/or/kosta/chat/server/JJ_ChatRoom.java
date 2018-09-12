package kr.or.kosta.chat.server;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import kr.or.kosta.common.Protocol;

/**
 * 
 * @author 최재민
 *
 */
public class JJ_ChatRoom {

	private int roomNum;
	private String roomName;
	private String roomOwner;
	private int roomCapacity;
	
	private List<String> clients;
	

	public JJ_ChatRoom() {
	}

	public JJ_ChatRoom(int roomNum, String roomName, String roomOwner, int roomCapacity) {
		this.roomNum = roomNum;
		this.roomName = roomName;
		this.roomOwner = roomOwner;
		this.roomCapacity = roomCapacity;
		
		clients = new ArrayList<>();
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomOwner() {
		return roomOwner;
	}

	public void setRoomOwner(String roomOwner) {
		this.roomOwner = roomOwner;
	}

	public int getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}

	/**
	 * 메시지 받기
	 */
	public void receiveMessage() {

	}

	/**
	 * 메시지 보내기
	 */
	public void sendMessage(String message) {

	}

	/**
	 * 종료하기
	 */
	public void finish() {
		
	}

	/**
	 * 사용자 수 반환하기
	 * 
	 * @return
	 */
	public int getClientCount() {
		return clients.size();
	}
	// 방 안에 있는 사람 수 리턴하기 
	
	
	
	@Override
	public String toString() {
		return roomNum + Protocol.DELEMETER2 + roomName + Protocol.DELEMETER2 + roomOwner + Protocol.DELEMETER2
				+ roomCapacity;
	}

	/**
	 * 해당 채팅방 client 리스트 반환하기 
	 * @return
	 */
	public List<String> getClientNickNames() {
		return clients; 
	}

	/**
	 * 채팅방에 client 추가하기 
	 */

	public void addClient(String nickName) {
		
		clients.add(nickName);
	}
	
	public boolean getFindUserRoom(String nickName) {
		return clients.contains(nickName);
	}
	

	/**
	 * 
	 */
	public void addMessage() {
		// TODO Auto-generated method stub
		
	}
}

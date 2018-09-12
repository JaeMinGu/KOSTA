package kr.or.kosta.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import kr.or.kosta.common.Protocol;

/**
 * 
 * @author 최재민
 *
 */
public class JJ_Client extends Thread {

	private Socket socket;
	private boolean running;
	private BufferedReader in;
	private PrintWriter out;
	private String nickName;
	private Hashtable<String, JJ_Client> clientNames;

	JJ_ChatServer chatServer;

	public JJ_Client() {
	}

	public JJ_Client(String nickName) {
		this.nickName = nickName;
	}

	public JJ_Client(Socket socket, JJ_ChatServer server) throws IOException {
		this.socket = socket;
		this.chatServer = server;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		running = true;

	}

	public Socket getSocket() {
		return socket;
	}

	public boolean isRunning() {
		return running;
	}

	public BufferedReader getIn() {
		return in;
	}

	public PrintWriter getOut() {
		return out;
	}

	public String getNickName() {
		return nickName;
	}

	/*
	 * 실행 시작
	 * 
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		receiveMessage();
	}

	/**
	 * 메시지 수신
	 */
	public void receiveMessage() {
		String clientMessage = null;

		while (running) {
			try {
				clientMessage = in.readLine();
				System.out.println("[Debug] : 클라이언트 수신 데이터: " + clientMessage);
				process(clientMessage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 처리
	 */
	public void process(String message) {
		String[] tokens = message.split(Protocol.DELEMETER);
		int protocol = Integer.parseInt(tokens[0]);
		switch (protocol) {

		case Protocol.CS_LOGIN:
			nickName = tokens[1];
			/** 닉네임 중복체크 */
			if (chatServer.isExistNickName(nickName)) {
				sendMessage(Protocol.SC_LOGIN_RESULT + Protocol.DELEMETER + nickName + Protocol.DELEMETER + "FAIL");
			} else {
				sendMessage(Protocol.SC_LOGIN_RESULT + Protocol.DELEMETER + nickName + Protocol.DELEMETER + "SUCCESS");
			}
			break;

		case Protocol.CS_ENTER:
			/** 입장 시 사용자 리스트에 추가 */
			chatServer.addClient(this);
			/* 대기자 리스트 업데이트 **/
			updateWaitingClientList();
			/** 채팅방 리스트 업데이트 */
			updateChatRoomList();
			break;

		/** 채팅방 이름 중복체크 */
		case Protocol.CS_ROOM_NAME:
			if (chatServer.checkChatRoomName(tokens[1])) {
				sendMessage(Protocol.SC_ROOM_NAME_RESULT + Protocol.DELEMETER + "Fail");
			} else {
				sendMessage(Protocol.SC_ROOM_NAME_RESULT + Protocol.DELEMETER + "SUCCESS");
			}
			break;

		/** 새로운 채팅방 생성 */
		case Protocol.CS_ROOM_CREATE:
			String[] chatRoomInfo = tokens[1].split(Protocol.DELEMETER2);

			// chatRoomInfo[0]: 새로운 채팅방 이름
			// chatRoomInfo[1]: 새로운 채팅방 방장
			// chatRoomInfo[2]: 새로운 채팅방 최대참여자수
			chatServer.addChatRoom(chatRoomInfo[0], chatRoomInfo[1], Integer.parseInt(chatRoomInfo[2]));
			/* 대기자 리스트 업데이트 **/
			updateWaitingClientList();
			/** 채팅방 리스트 업데이트 */
			updateChatRoomList();
			/** 방장 채팅방에 추가하기 */
			chatServer.addRoomOwnerToChatRoom(chatRoomInfo[0], chatRoomInfo[1]);
			sendMessage(Protocol.SC_ROOM_CREATE_RESULT + Protocol.DELEMETER + "SUCCESS");

			break;
		/** 채팅방 입장 */
		case Protocol.CS_REQUEST_ENTER_CHATROOM:
			// tokens[1]: nickName
			// tokens[2]: roomName
			if (chatServer.addClientToChatRoom(tokens[1], tokens[2])) {
				sendMessage(Protocol.SC_REQUEST_ENTER_CHATROOM_RESULT + Protocol.DELEMETER + "SUCCESS");
				updateChatRoomClientList(tokens[1], 1);
			} else {
				sendMessage(Protocol.SC_REQUEST_ENTER_CHATROOM_RESULT + Protocol.DELEMETER + "Fail");
			}
			break;
			
		/** 해당 채팅방 받아오기 */
		case Protocol.CS_GETROOM_INFO:

			/** 해당 채팅방 client 리스트 업데이트 */
			// tokens[1]: roomName
			updateChatRoomClientList(tokens[1], 0);
			updateWaitingClientList();
			break;

		case Protocol.CS_ROOM_CHAT:
			// tokens[1]: nickName
			// tokens[2]: message
			chatServer.startRoomChat(tokens[1], tokens[2]);
			break;

		/** 종료하기 */
		case Protocol.CS_DISCONNECT:
			/** 사용자 리스트에서 삭제 */
			chatServer.removeClient(this);
			running = false;
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			break;

		default:
			break;
		}
	}

	/**
	 * 채팅방 내 client 리스트 업데이트
	 * 
	 * @param name
	 */
	private void updateChatRoomClientList(String name, int flag) {
		if (flag == 0) {
			sendMessage(Protocol.SC_GETROOM_INFO_RESULT + Protocol.DELEMETER + chatServer.getAtiveChatRoom(name));
		} else if (flag == 1) {
			chatServer.sendToSpecificRoom(name);
		}
	}

	/**
	 * 대기자 리스트 업데이트
	 * 
	 */
	public void updateWaitingClientList() {
		List<String> allClientList = new ArrayList<>();
		allClientList = chatServer.getAllClientList();
		chatServer.sendAllMessage(Protocol.SC_UPDATE_WAITINGROOM_USER_LIST + Protocol.DELEMETER + allClientList);
	}

	/**
	 * 채팅방 리스트 업데이트
	 */
	public void updateChatRoomList() {
		List<JJ_ChatRoom> allChatRoomList = new ArrayList<>();
		allChatRoomList = chatServer.getActiveChatRoomList();
		chatServer.sendAllMessage(Protocol.SC_UPDATE_CHATROOM_LIST + Protocol.DELEMETER + allChatRoomList);
	}

	public void sendList(List list) {
		if (out != null) {
			out.println(list);
		}
	}

	/**
	 * 메시지 전송
	 */
	public void sendMessage(String message) {
		if (out != null) {
			out.println(message);
		}
	}
}

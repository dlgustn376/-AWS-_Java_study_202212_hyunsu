package simplechatting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
class ConnectedSocket extends Thread {
	private static List<ConnectedSocket> socketList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	private String username;
	
	public ConnectedSocket(Socket socket) {
		this.socket = socket;
		socketList.add(this);
		
	}
	
	@Override
	public void run() {
		try {
//			현재 자신의 소켓에만 주고 있다.
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true);
			out.println("join");
			
			InputStream inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream)); 
			
			username = in.readLine();
			System.out.println(username + "님이 접속하였습니다.");		// 서버에 띄우기
			
			String userListStr = "";
			
			for(int i = 0; i < socketList.size(); i++) {
				userListStr += socketList.get(i).getUsername();
				if(i < socketList.size() -1) {
					userListStr += ",";
				}
			}
			
			// 메시지름 모두에게 줌
			for(ConnectedSocket connectedSocket : socketList) {
				outputStream = connectedSocket.getSocket().getOutputStream();
				out = new PrintWriter(outputStream, true);
				out.println("@welcome/" + username + "님이 접속하였습니다.");
				out.println("@userList/" + userListStr);
			}
			
//			out.println(welcomeMessage);			// 클라이언트에게 돌려주기
			
			while(true) {
				String message = in.readLine();
//				모두에게 보내줘야 함
				for(ConnectedSocket connectedSocket : socketList) {
					outputStream = connectedSocket.getOutputStream();
					out = new PrintWriter(outputStream, true);
					out.println(message);
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}



public class ServerApplication {
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null; 
		try {
			serverSocket = new ServerSocket(9090);
			System.out.println("=====<< 서버 실행 >>=====");
						
			
			while(true){
				Socket socket =	serverSocket.accept(); // 클라이언트의 접속을 기다리는 것
				ConnectedSocket connectedSocket = new ConnectedSocket(socket);				
				connectedSocket.start();				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			if(serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("=====<< 서버 종료 >>=====");
		}
	}
}

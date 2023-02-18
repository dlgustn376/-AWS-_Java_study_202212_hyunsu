package usermanagement.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.management.InvalidApplicationException;

import usermanagement.server.SocketServer;

public class UserManagementServerApllication implements Runnable{
	
	private final static int PORT = 9090;
	private ServerSocket serverSocket;
	
	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("================<<서버실행>>==================");
			
			socketConnection();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(serverSocket != null) {
					serverSocket.close();
				}
				System.out.println("================<<서버종료>>==================");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	private void socketConnection() throws IOException {
		while(true) {
			Socket socket = serverSocket.accept(); // 소켓 객체 생성
			SocketServer socketServer = new SocketServer(socket);
			socketServer.start();
		}
	}
	
	public static void main(String[] args) {
		UserManagementServerApllication application = new UserManagementServerApllication();
		application.run();
	}

}

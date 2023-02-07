package j25_소켓.multiSocket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private static final int PORT = 9090;
	
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("서버를 실행합니다.");
			
			while(true) { // 클라이언트 접속을 기다리는 무한 루프
				Socket socket = serverSocket.accept(); // 클라이언트 하나씩 접속했을 떄.
				SocketServer socketServer = new SocketServer(socket);
				socketServer.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("서버를 종료합니다.");
		}
	}
}

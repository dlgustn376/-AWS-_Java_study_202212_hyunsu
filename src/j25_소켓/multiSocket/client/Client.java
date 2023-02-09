package j25_소켓.multiSocket.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",9090);
			// 메시지른 받기에 대기하는 스레드
			ClientRecive clientRecive = new ClientRecive(socket);
			clientRecive.start();
			// 메시지를 보내기에 대기하는 스레드
			ClientSend clientSend = new ClientSend(socket);
			clientSend.start();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}

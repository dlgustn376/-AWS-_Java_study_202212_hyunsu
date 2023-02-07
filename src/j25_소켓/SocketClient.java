package j25_소켓;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
	
	public static void main(String[] args) {
		
		try {
			
			Socket socket = new Socket("127.0.0.1",9090);
			System.out.println("서버에 접속 성공!");
			
			InputStream inputStream = socket.getInputStream();
			InputStreamReader streamReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(streamReader);
			
			System.out.println(reader.readLine()); // 한 줄씩 가져온다. readLImE
		
			
			
		} catch (UnknownHostException e) {
			// IP를 잡지 못했을 때 
			e.printStackTrace();
		} catch (IOException e) {
			// 인터넷 연결이 안되었을 때
			e.printStackTrace();
		}
	}

}

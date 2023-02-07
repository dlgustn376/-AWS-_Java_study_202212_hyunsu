package j25_소켓.multiSocket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer  extends Thread {
	
	public static List<Socket> clientList = new ArrayList<>();
	private static Socket socket;
	
	public SocketServer(Socket socket) {
		this.socket = socket;
		clientList.add(socket);
	}
	
	@Override
	public void run() {
//		server의 기능이 들어가면 됨
		System.out.println("[연결된 클라이언트 정보]");
//		클라이언트의 IP주소
		System.out.println("IP: " + socket.getInetAddress());	
		
		try {
			InputStream inputStream = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(outputStream, true);
			
			writer.println("서버 접속 성공!");
			writer.println("사용자 이름을 입력하세요!");
			
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
	
}

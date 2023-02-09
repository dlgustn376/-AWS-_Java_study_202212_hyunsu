package j25_소켓.multiSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

// 하나의 스레드
public class SocketServer  extends Thread {
	
	// 소캣서버들이 들어있는 리스트
	public static List<SocketServer> clientList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	private static int autoIncrement = 1;
	private String name;
	// 해당 클라이언트만 생성
	public SocketServer(Socket socket) {
		this.socket = socket;
		name = "user" + autoIncrement++;
		clientList.add(this);
	}
	
	@Override
	public void run() {
//		server의 기능이 들어가면 됨
		System.out.println("[연결된 클라이언트 정보]");
//		클라이언트의 IP주소
		System.out.println("IP: " + socket.getInetAddress());	
		
		try {
			inputStream = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			
			sendToAll(name + "님이 접속하였습니다.");
			
			while(true) {
				// 메시지가 들어올 때까지 대기
				// readLine() 무조건 문자열을 가져옴
				// null이 온다는 것은 연결이 끊어졌다는 의미
				String message = reader.readLine();
				if(message == null) {
					break;
				}
				// 브로드캐스팅(모든 클라이언트들에게 동시에 메시시를 보냄)
				sendToAll(message);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 연결 끊기
				inputStream.close();
				outputStream.close();
				socket.close();
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
		
	private void sendToAll(String message) throws IOException {
		for(SocketServer socketServer : clientList) {
			outputStream = socketServer.socket.getOutputStream();
			PrintWriter writer = new PrintWriter(outputStream, true);
			// name은 자기 자신, 멤버변수에 들어 있는 이름
			// 방금 들어온 대상
			writer.println(name + ":" + message);
		}
	}
}

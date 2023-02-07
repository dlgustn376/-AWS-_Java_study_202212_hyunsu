package j25_소켓;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer {
	// server를 열기위해서 포트번호가 꼭 필요.
	public static final int PORT = 9090;
	
	public static void main(String[] args) {
		List<Socket> clients = new ArrayList<>();
		
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			
			while(true) {
				System.out.println("클라이언트의 접속을 기다리는 중입니다.");
				Socket socket = serverSocket.accept();
				clients.add(socket);
				System.out.println("클라이언트가 연결되었습니다.");
				System.out.println(clients);
//				Socket[addr=/127.0.0.1,port=64986,localport=9090] prot는 클라이언트, localport는 서버
				
				OutputStream outputStream = socket.getOutputStream();
				PrintWriter out = new PrintWriter(outputStream, true); // 문자열을 보내는데 사용. 버퍼기능도 포함. 문자열 전송시 사용.
				out.println("___서버에 접속한 것을 환영합니다.");
			
				// 각각이 전부 스레드여야 한다.
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	
	}
	
}

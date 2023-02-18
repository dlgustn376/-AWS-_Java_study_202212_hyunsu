package j25_소켓;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;

import usermanagement.dto.RequestDto;

public class SocketClient {
	public static void main(String[] args) {
		
		
		try {
			Socket socket = new Socket("127.0.0.1",9090); //ip, port
			System.out.println("서버에 접속 성공!");
			
			InputStream inputStream = socket.getInputStream();
			InputStreamReader streamReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(streamReader);
			
//			System.out.println(reader.readLine()); // readline -> 한 줄 읽기
			
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream, true);
			
			Gson gson = new Gson();
			RequestDto<String> dto = new RequestDto<String>("test", "테스트 데이터");
			
			printWriter.println();
		
		
		} catch (UnknownHostException e) { // 연결 못 했을 때
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}



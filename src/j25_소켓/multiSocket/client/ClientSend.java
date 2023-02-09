package j25_소켓.multiSocket.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientSend extends Thread{
	
	private final Socket socket;
	@Override
	public void run() {
		try {
			OutputStream outpurStream = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(outpurStream, true);
			Scanner scanner = new Scanner(System.in);
			
			while(true) {
			
				writer.println(scanner.nextLine());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

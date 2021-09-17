package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	
	
	public static void main(String[] args) {
		
		try {
			Scanner scanner = new Scanner(System.in);
			Socket socket = new Socket();
			socket.connect(new InetSocketAddress("220.119.14.160", 8080));
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			System.out.println("닉네임>>");
			String nickname = scanner.nextLine();
			printWriter.println("join:" + nickname);
			printWriter.flush();
			
			new ChatClientReceiveThread(socket, nickname, bufferedReader).start();
			
			while(true) {
				System.out.println(">>");
				String input = scanner.nextLine();
				
				if("quit".equals(input) == true) {
					printWriter.println("quit");
					socket.close();
					break;
				} else {
					printWriter.println("message:" + input);
				}
			}
		} catch (IOException e) {
			//ChatServer.log("error: " + e);
		} finally {
			
		}
	}
	
}

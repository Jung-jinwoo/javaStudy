package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatServer {
	private static final int PORT = 8080;

	public static void main(String[] args) {
		ServerSocket serverSocket;
		List<Writer> listWriters = new ArrayList<Writer>();
		Scanner scanner;
		try {
			serverSocket = new ServerSocket();
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
			log("연결 기다림" + hostAddress + ":" + PORT);
			
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listWriters).start();
			}
			
		} catch (IOException e) {
			log("error: " + e);
		}
		
		
	}

	public static void log(String string) {
		System.out.println(string);

	}

}

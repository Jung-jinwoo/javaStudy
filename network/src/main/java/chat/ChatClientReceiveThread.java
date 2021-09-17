package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatClientReceiveThread extends Thread {

	private BufferedReader bufferedReader;
	private Socket socket;
	private String nickname;

	public ChatClientReceiveThread(Socket socket, String nickname, BufferedReader bufferedReader) {
		this.socket = socket;
		this.nickname = nickname;
		this.bufferedReader = bufferedReader;
	}

	@Override
	public void run() {
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),
					true);
			while(true) {
				String line = bufferedReader.readLine();
				doMessage(nickname, line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if(socket != null && socket.isClosed() == true) {
					socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}

	public void doMessage(String nickname, String message) {
		System.out.println(message);
		

	}

}

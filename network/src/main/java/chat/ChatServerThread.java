package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class ChatServerThread extends Thread {

	private String nickname;
	private Socket socket;
	private List<Writer> listWriters;

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	BufferedReader bufferedReader = null;
	PrintWriter printWriter = null;

	@Override
	public void run() {

		Scanner scanner = new Scanner(System.in);

		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),
					true);

			String request = null;
			while (true) {
				request = bufferedReader.readLine();
				if (request == null) {
					ChatServer.log("Closed By Client");
					doQuit(printWriter);
					break;
				}

				String[] tokens = request.split(":");
				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], printWriter);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit(printWriter);
					break;
				} else {
					ChatServer.log("error: Unknown Request (" + tokens[0] + ")");
				}
			}

		} catch (IOException e) {
		} finally {
			try {
				if ((socket != null && socket.isClosed()) == false) {
					socket.close();
				}
			} catch (Exception e) {
			}
		}

	}

	private void doQuit(Writer writer) {
		String data = nickname + "님이 퇴장 하였습니다.";
		broadcast(data);
		removeWriter(writer);
	}

	private void removeWriter(Writer writer) {
		try {
			writer.close();
		} catch (IOException e) {
		}
	}

	public void doMessage(String message) {
		ChatServer.log(message + "\n");

		String data = nickname + ":" + message;
		broadcast(data);
	}

	private void doJoin(String nickName, Writer writer) {
		this.nickname = nickName;

		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);

		addWriter(writer);

		printWriter.println("join:ok");
		printWriter.flush();
	}

	private void addWriter(Writer writer) {
		listWriters.add(writer);

	}

	private void broadcast(String data) {
		synchronized (listWriters) {
			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}
}

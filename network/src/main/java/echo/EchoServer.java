package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private static final int PORT = 6000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket();

			serverSocket.bind(new InetSocketAddress("0,0,0,0", PORT));
			log("starts... [port:" + PORT + "]");

			Socket socket = serverSocket.accept();

			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));

				while (true) {
					String data = br.readLine();
					if (data == null) {
						log("closed by client");
						break;
					}
					
					log("received: " + data);
					pw.println(data);
				}
			} catch (IOException e) {
				log("error: " + e);
			} finally {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			}
		} catch (IOException e) {
			log("error: " + e);
		} finally {
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public static void log(String log) {
		System.out.println("[EchoServer] " + log);
	}

}

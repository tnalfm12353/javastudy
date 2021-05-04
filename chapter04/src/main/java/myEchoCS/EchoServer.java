package myEchoCS;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	private static final String SERVER_IP = "0.0.0.0";
	private static final int SERVER_PORT = 6910;
	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		
		try {
			
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			log("start... [ Port : " + SERVER_PORT + "]");
			
			while(true) {
				Socket socket = serverSocket.accept();
				Thread thread = new EchoServerSocketThread(socket);
				thread.start();
			}
			
		} catch (IOException e) {
			System.out.println();
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static final void log (String log) {
		System.out.println("[EchoServer] " + log);
	}
}

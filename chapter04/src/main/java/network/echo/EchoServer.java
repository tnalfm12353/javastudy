package network.echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static final int PORT = 7000;
	
	public static void main(String[] args) {

		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("Starts... [port : " + PORT + "]");

			// thread 
			while(true) {				
				Socket socket = serverSocket.accept(); 
				
				Thread thread = new EchoServerReceiveThread(socket);
				thread.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
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
	
	public static void log (String log) {
		System.out.println("[EchoServer] " + log);
	}
}

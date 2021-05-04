package network.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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

			Socket socket = serverSocket.accept(); 
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();

			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketAddress.getPort();
			log("connected by client [" +remoteHostAddress + ":" + remoteHostPort+"]");

			try {
				// 4. IOStream 받아오기
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true); // true -> 버퍼가 다 채워지지 않더라도 플러쉬시킴

				while(true) {
					// 4. 데이터 일기
					String data = br.readLine();
					
					if( data == null) {
						log("closeed by client");
						break;
					}
					
					log("received : " + data);

					// 5. 데이터 쓰기
					pw.print(data);
				}
			} catch (IOException e){
				e.printStackTrace();
			} finally {
				try {
					if(socket != null && !socket.isClosed()) {
						socket.close();
					}					
				} catch (IOException e) {
					e.printStackTrace();
				}
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
	
	private static void log (String log) {
		System.out.println("[EchoServer] " + log);
	}
}

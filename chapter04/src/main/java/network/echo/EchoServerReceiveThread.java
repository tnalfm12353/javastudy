package network.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class EchoServerReceiveThread extends Thread{

	private Socket socket;

	public EchoServerReceiveThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();

		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		int remoteHostPort = inetRemoteSocketAddress.getPort();
		EchoServer.log("connected by client [" +remoteHostAddress + ":" + remoteHostPort+"]");

		try {
			// 4. IOStream 받아오기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true); // true -> 버퍼가 다 채워지지 않더라도 플러쉬시킴

			while(true) {
				// 4. 데이터 일기
				String data = br.readLine();
				
				if( data == null) {
					EchoServer.log("closeed by client");
					break;
				}
				
				EchoServer.log("received : " + data);

				// 5. 데이터 쓰기
				pw.println(data);
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

		
	}

}

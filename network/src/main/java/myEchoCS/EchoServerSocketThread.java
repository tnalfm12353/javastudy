package myEchoCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class EchoServerSocketThread extends Thread{

	private Socket socket;
	
	public EchoServerSocketThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		String hostAddress = inetSocketAddress.getAddress().getHostAddress();
		String hostName = inetSocketAddress.getHostName();
		int port = inetSocketAddress.getPort();
		EchoServer.log("Connected by "+ hostName + " : "+ hostAddress + " : "+ port);
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);
			
			while(true) {
				String data = br.readLine();
				
				if(data == null) {
					EchoServer.log("close by client");
					return ;
				}
				
				EchoServer.log("received : "+ data);
				pw.println("[" +hostAddress+"] "+hostName+ " : " + data);
			}
		} catch (IOException e) {			
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

package myEchoCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Scanner;

import echo.EchoClient;

public class EchoClientReader extends Thread{
	
	private Socket socket;
	
	public EchoClientReader(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			String data = br.readLine();
			if(data == null) {
				EchoClient.log("server shuted down");
				return ;
			}
			
			EchoClient.log(data);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

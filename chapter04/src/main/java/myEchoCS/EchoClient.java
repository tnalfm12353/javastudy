package myEchoCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Socket socket = null;
		
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress("127.0.0.1", 6910));
			log("connected");
//			Thread clientReader = new EchoClientReader(socket);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
			while(true) {
//				clientReader.start();
				System.out.print("> ");
				String message = sc.nextLine();
				pw.println(message);
		
				String data = br.readLine();
				if(data == null) {
					log("server shuted down");
					return ;
				}
				
				log(data);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void log(String log) {
		System.out.println("[Client] " + log);
	}
}

package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {

	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		Scanner sc = null;
		Socket socket = null;

		try {
			sc = new Scanner(System.in);
			// 1. 소캣 생성
			socket = new Socket();

			// 2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, EchoServer.PORT));
			log("connected");

			// 3. IOStream 받아오기 
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);

			while(true) {
				// 4. 키보드 입력
				System.out.print(">");
				String line = sc.nextLine();
				if("exit".equals(line)) {
					break;
				}
				// 5. 데이터 쓰기
				pw.println(line);
				// 6. 데이터 읽기
				String data = br.readLine();
				if( data == null) {
					log("closed by server");
					break;
				}

				System.out.println("<" + data);
			}
		} catch (SocketException e) {
			log("suddenly closed by server");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(sc != null) {
					sc.close();
				}
				if(socket != null && !socket.isClosed()) {
					socket.close();					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void log (String log) {
		System.out.println("[EchoClient] " + log);
	}
}

package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
				
		try {
			// 1. 서버소캣 생성
			serverSocket = new ServerSocket();

			// 1-1. Time Wait 상태에서도 소캣에 포트 번호 할당이 가능하게 하기 위해서.
			serverSocket.setReuseAddress(true);
			
			// 2. 바인딩(Binding)
			//	  Socket에 InetSocketAddress(IPAddress + Port) --> IPAddress는 내 ip가 아닌 받을 ip주소
			//    IPAddress : 0.0.0.0 -> 모든 IP 접근 허용
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000));
			
			// 3. accept
			//	  클라이언트의 연결 요청을 기다린다.
			Socket socket = serverSocket.accept(); // blocking
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketAddress.getPort();
			System.out.println("[server] connected by client [" +remoteHostAddress + ":" + remoteHostPort+"]");
			
			try {
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				while(true) {
					byte [] buffer = new byte[256];
					int readByteCount = is.read(buffer); // blocking
					if( readByteCount == -1) {
						// 클라이언트가 정상적으로 종료 (close() 호출)
						System.out.println("[server] closeed by client");
						break;
					}
					
					String data = new String(buffer, 0, readByteCount, "UTF-8");
					System.out.println("[server] received : " + data);
					
					// 5. 데이터 쓰기
					os.write(data.getBytes("utf-8"));
				}
			} catch (IOException e){
				e.printStackTrace();
			} finally {
				try {
					if(socket != null && !socket.isClosed())
					socket.close();					
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

}

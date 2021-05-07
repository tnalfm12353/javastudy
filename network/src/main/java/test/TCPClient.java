package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class TCPClient {

	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5000;
	
	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {
			// 1. 소캣 생성
			socket = new Socket();
			
			// 1-1 소캣 버퍼사이즈 확인
			int reciveBufferSize = socket.getReceiveBufferSize();
			int sendBufferSize = socket.getSendBufferSize();
			System.out.println("[Client] " + reciveBufferSize + ":" + sendBufferSize);

			// 1-2 소캣 버퍼사이즈 변경
			socket.setReceiveBufferSize(1024*10);
			socket.setSendBufferSize(1024*10);
			reciveBufferSize = socket.getReceiveBufferSize();
			sendBufferSize = socket.getSendBufferSize();
			System.out.println("[Client] " + reciveBufferSize + ":" + sendBufferSize);
			
			// 1-3. SO_NODELAY(Nagle Algorithm off)
			socket.setTcpNoDelay(true);
			
			
			// 2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			System.out.println("[Client] connected");
			
			// 3. IOStream 받아오기 
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			// 4. 쓰기
			String data = "Hello World\n";
			os.write(data.getBytes("UTF-8"));
			
			// 5. 읽기
			byte [] buffer = new byte[256];
			int readByteCount = is.read(buffer); // blocking
			if(readByteCount == -1) {
				System.out.println("[Client] closed by server");
				return ;
			}
			
			data = new String(buffer, 0, readByteCount, "UTF-8");
			System.out.println("[Client] received : "+ data);
		} catch (SocketException e) {
			System.out.println("[Client] suddenly closed by server");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

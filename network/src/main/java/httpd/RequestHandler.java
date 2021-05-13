package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	
	private static final String DOCUMENT_ROOT = "./webapp";
	private static final String ERROR = "/error";
	private static final String ERROR_404 = "/404.html";
	private static final String ERROR_400 = "/400.html";
	private Socket socket;
	
	
	public RequestHandler( Socket socket ) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress();
			consoleLog( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() );
			String request = null;
			
			while(true) {
				String line = br.readLine();
				
				//브라우져가 연결을 끊으면
				if(line == null) {
					break ;
				}
				
				// Request header만 읽음.
				if("".equals(line)) {
					break;
				}

				// 첫 번째 라인만 처리
				if(request == null) {
					request = line;
					break ;
				}
			}

			// 요청 처리
			String [] tokens = request.split(" ");
			if("GET".equals(tokens[0])) {
				consoleLog("request : " + tokens[1]);
				responseStaticResource(outputStream, tokens[1], tokens[2]);
				
			} else { // methods : POST, PUT, DELETE, HEAD, CONNECT
				/* Simple Http Server에서는 무시 */
				badRequestResponse(outputStream, tokens[2]);
			}
			
			
			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
//			outputStream.write( "HTTP/1.1 200 OK\r\n".getBytes( "UTF-8" ) );
//			outputStream.write( "Content-Type:text/html; charset=utf-8\r\n".getBytes( "UTF-8" ) );
//			outputStream.write( "\r\n".getBytes() );
//			outputStream.write( "<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes( "UTF-8" ) );

		} catch( Exception ex ) {
			consoleLog( "error:" + ex );
		} finally {
			// clean-up
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}
				
			} catch( IOException ex ) {
				consoleLog( "error:" + ex );
			}
		}			
	}

	private void responseStaticResource(OutputStream outputStream, String url, String protocol) throws IOException {
		// set welcome file 
		if("/".equals(url)) {
			url = "/index.html";
		}
		
		File file = new File(DOCUMENT_ROOT + url);
	
		if(!file.exists()) {
			notFoundResponse(outputStream,protocol);
			
			return ;
		}
		
		// nio
		byte [] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
		String status = " 200 OK";
		response(outputStream, protocol, status, body, contentType);
	}
	
	private void notFoundResponse(OutputStream outputStream, String protocol) throws IOException {
		File file = new File(DOCUMENT_ROOT + ERROR + ERROR_404);
		if(!file.exists()) {
			System.out.println("file not found:" + file.getAbsolutePath());
			
			return ;
		}
		byte [] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
		String status = " 404 Not Found";
		response(outputStream, protocol, status, body, contentType);
	}
	
	private void badRequestResponse(OutputStream outputStream, String protocol) throws IOException{
		File file = new File(DOCUMENT_ROOT + ERROR + ERROR_400);
		if(!file.exists()) {
			System.out.println("file not found:" + file.getAbsolutePath());
			return ;
		}
		byte [] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
		String status = " 400 Bad Request";
		response(outputStream, protocol, status, body, contentType);
	}
	
	private void response(OutputStream outputStream, String protocol, String status, byte [] body , String contentType) throws IOException {
		outputStream.write((protocol + " "+ status +"\r\n").getBytes( "UTF-8" ) );
		outputStream.write(("Content-Type:" + contentType + ";charset=utf-8\r\n").getBytes( "UTF-8" ) );
		outputStream.write("\r\n".getBytes() );
		outputStream.write(body);
	}

	public void consoleLog( String message ) {
		System.out.println( "[RequestHandler#" + getId() + "] " + message );
	}
}

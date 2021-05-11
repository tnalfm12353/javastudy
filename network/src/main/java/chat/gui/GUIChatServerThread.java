package chat.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class GUIChatServerThread extends Thread{

	private String nickname;
	private Socket socket;
	private List<ClientDomain> listWriters;
	private BufferedReader br;
	private PrintWriter pw;
	
	public GUIChatServerThread(Socket socket, List<ClientDomain> listWriters) throws IOException {
		this.socket = socket;
		this.listWriters = listWriters;
		br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
		pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"),true);
	}

	@Override
	public void run() {
		try {
			while(true) {
				String requestMsg = br.readLine(); // socketException
				if(requestMsg == null) {
					doQuit();
					break;
				}
				String tokens [] = requestMsg.split(":");
				
				switch(tokens[0]) {
					case "JOIN" : doJoin(tokens[1]);
							break;
					case "/msg" : doWhisper(tokens[1]);
							break;
					default : broadcast(nickname+" : "+tokens[0]);
							break;
				}
			}
		} catch (SocketException e) {
			doQuit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null && !socket.isClosed())
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	private void doJoin(String username) {
		nickname = username;
		String messsage = username +"님이 입장했습니다.";
		broadcast(messsage);
		addWriter();
		pw.println("JOIN:OK");
	}

	private void doQuit() {
		String message = nickname + "님이 퇴장했습니다.";
		broadcast(message);
		removeWriter();
	}
	private void broadcast(String message) {
		synchronized (listWriters) {
			for(ClientDomain client : listWriters) {
				client.getPw().println(message);
			}
		}
	}

	private void addWriter() {
		synchronized (listWriters) {
			listWriters.add(new ClientDomain(nickname,pw));
			System.out.println(listWriters.size());
		}
	}
	
	private void removeWriter() {
		synchronized (listWriters) {
			listWriters.remove(findClient(nickname));
			System.out.println(listWriters.size());
		}
	}
	private void doWhisper(String whisper) {
		String whisperSplit[] = whisper.split(" ");
		sendWhisper(whisperSplit[0],whisperSplit[1]);
	}
	
	private void sendWhisper(String nickname, String msg) {
		ClientDomain client = findClient(nickname);
		if(client == null) {
			pw.println("채팅에 참여하지 않은 이용자입니다.");
			return ;
		}
		String whisper = "["+this.nickname+"]"+"귓속말 > "+msg;
		client.getPw().println(whisper);
		pw.println(whisper);
		
	}

	private ClientDomain findClient(String nickname) {
		for(ClientDomain client: listWriters) {
			if(nickname.equals(client.getNickname())) {
				return client;
			}
		}
		return null;
	}
}

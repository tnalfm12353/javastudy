package chat.gui;

import java.io.PrintWriter;

public class ClientDomain {

	private PrintWriter pw;
	private String nickname;
	
	public ClientDomain(String nickname, PrintWriter pw) {
		this.nickname = nickname;
		this.pw = pw;
	}
	
	public PrintWriter getPw() {
		return pw;
	}
	public void setPw(PrintWriter pw) {
		this.pw = pw;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}

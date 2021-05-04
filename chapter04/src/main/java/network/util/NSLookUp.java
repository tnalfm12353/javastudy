package network.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookUp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.print(">>");
				String line = sc.nextLine();
				
				if("exit".equals(line)) {
					break;
				}
				
				InetAddress [] inetAddresses = InetAddress.getAllByName(line);
				for(InetAddress inetAddress : inetAddresses) {
					System.out.println(line + " : " + inetAddress.getHostAddress());
				}
			} catch (UnknownHostException e) {
				System.out.println("unKnown host" + e);
			}
		}
	}

}

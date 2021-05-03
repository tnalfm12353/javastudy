package io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhoneList02 {

	public static void main(String[] args) {

		Scanner scanner = null; 

		try {
			File file = new File("phone.txt");

			if(!file.exists()) {
				System.out.println("file not found");
				return;
			}
			System.out.println("================= 파일 정보 =================");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");

//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//			String ModifiedDate = dateFormat.format(new Date(file.lastModified()));
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));


			System.out.println("================= 전화번호 =================");
			scanner = new Scanner(file);
			
			while(scanner.hasNextLine()) {
				String name = scanner.next();
				String phoneNum1 = scanner.next();
				String phoneNum2 = scanner.next();
				String phoneNum3 = scanner.next();

				System.out.println(name + ":" +phoneNum1 + "-" + phoneNum2 + "-" + phoneNum3);
			}
		} catch (IOException e) {
			System.out.println("Error : " + e);
		}finally {
			if(scanner != null) {
				scanner.close();
			}
		}
	}

}

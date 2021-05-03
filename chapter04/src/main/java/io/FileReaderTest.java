package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

public class FileReaderTest {

	public static void main(String[] args) {
		
		Reader in = null;
		InputStream is = null;
		
		try {
			in = new FileReader("1234.txt");
			
			int count = 0;
			int data = -1;
			while((data = in.read()) != -1) {
				System.out.print((char)data);
				count++;
			}
			System.out.println("\ncount : " + count);
			
			System.out.println("=================================");
			
			count = 0;
			data = -1;
			is = new FileInputStream("1234.txt");
			while((data = is.read()) != -1) {
				System.out.print((char)data); // ê°ëë¤ë¼ë§ë°ì¬ -> 한글은 3바이트인데 inputstream은 1바이트씩 읽기 때문. 영어는 byte기에 안꺠짐. 
				count++;
			}
			System.out.println("\ncount : " + count);
			
		}catch (FileNotFoundException e) {
			System.out.println("File Not Found : " + e);
		}catch (IOException e) {
			System.out.println("Error :" + e);
		}finally {
			try {
				if(in != null) {
					in.close();
				}
				if(is != null) {
					is.close();
				}
			}catch (IOException e) {
				System.out.println("Stream close Error : " + e);
			}
		}

	}

}

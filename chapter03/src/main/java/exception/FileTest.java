package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 *  CheckedException
 *
 */
public class FileTest {

	public static void main(String[] args) {
		FileInputStream file = null;
		
		try {
			file = new FileInputStream("./hello.txt");
			int data = file.read();
			System.out.println(data);
		} catch (FileNotFoundException e) {
			System.out.println("Error : " + e);
		} catch (IOException e) {
			System.out.println("Error : " + e);
		} finally {
			try {
				if(file != null)
					file.close();
			} catch (IOException e) {
				System.out.println("Error : " + e);
			}
		}

	}

}

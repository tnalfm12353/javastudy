package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutpusStreamTest {

	public static void main(String[] args) {
		
		/**
		 * 보조 스트림은 파일을 직접적으로 가져올 수 없음.
		 * 고로 FileOutputStream이 주 스트림, BufferedOutputStream이 보조 스트림
		 */
		BufferedOutputStream bos = null;
		
		try {
			// 기반 스트림
			FileOutputStream fis =  new FileOutputStream("test.txt");
			
			// 보조 스트림
			bos = new BufferedOutputStream(fis);
//			bos = new BufferedOutputStream(new FileOutputStream("test.txt"));
			
			//for(int i = 'a'; i < 'z'; i++) -> 아스키코드 i = 97 ; i < 122
			for(int i = 'a'; i < 'z'; i++) {
				bos.write(i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("can not open : " + e);
		}catch (IOException e) {
			System.out.println("Error : " + e);
		}finally {
			try {
				if(bos != null) {
					bos.close();
				}
			}catch (IOException e) {
				System.out.println("Stream Close Error : " + e);
			}
		}

	}

}

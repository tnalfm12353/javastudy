package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String text = scanner.nextLine();
//		char textToChar [] = text.toCharArray();
//
//		for( int i = 0 ; i < text.length(); i++) {
//			for(int j = 0; j <= i; j++) {
//				System.out.print(textToChar[j]);
//			}
//			System.out.println();
//		}
		
		for(int i = 1 ; i <= text.length(); i++) {
			System.out.println(text.substring(0,i));
		}
		
		scanner.close();
	}

}

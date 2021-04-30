package chapter04;

public class StringTest01 {

	public static void main(String[] args) {
		// C:\temp
		System.out.println("c:\\temp");

		// "hello" 
		System.out.println("\"hello\"");
		
		// \t : tap
		// \r : carriage return -> 타자기처럼 한줄을 띄우면 첫번째 자리로 돌아가는 것  
		// \n : newLine
		// \b : beep -> 삐 소리 나옴
		
		System.out.print("hello\tworld\n");
		System.out.println("hello\tworld");
		
		// '
		char c = '\'';
		System.out.println(c);
	}

}

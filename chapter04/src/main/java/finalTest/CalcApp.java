package finalTest;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String userResponse = "";
		int num [] = new int[2];
		
		String operation = null;
		int answer = -1;
		
		
		System.out.print("두 정수와 연산자를 입력하시오 (Ex. 3 4 / ) : ");
		userResponse = sc.nextLine();
		
		String splited [] = userResponse.trim().split(" "); // 공백 제거
		
		for(int i = 0; i < splited.length ; i++) {
			if(splited[i].matches("\\d+")) {
				if(num[0] == 0) {
					num[0] = Integer.parseInt(splited[i]);
				}else {
					num[1] = Integer.parseInt(splited[i]);
				}
			}else if( splited[i].matches("\\p{Punct}")) {
				operation = splited[i];
			}
		}
		
		switch (operation) {
		case "+": answer = new Add().calculate(num[0], num[1]);
			break;
		case "-": answer = new Sub().calculate(num[0], num[1]);
			break;
		case "*": answer = new Mul().calculate(num[0], num[1]);
			break;
		case "/": answer = new Div().calculate(num[0], num[1]);
			break;

		default: System.out.println("잘못된 연산자 입니다.");
			break;
		}
		
		System.out.println(answer != -1? answer : "다시 시도해주세요");
	}

}

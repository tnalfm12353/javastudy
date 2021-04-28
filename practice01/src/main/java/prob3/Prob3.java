package prob3;

import java.util.Scanner;

public class Prob3 {
	
	
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
	
	
		int number = 0;
		int sum = 0;
		System.out.print("숫자를 입력하세요 :");
		number = scanner.nextInt();
			
		if(number % 2 == 0) { // 짝수 
			for(int i = 0 ; i <= number; i += 2) {
				sum += i;
			}
		}else { //홀수 
			for(int i = 1 ; i <= number; i += 2) {
				sum += i;
			}	
		}
		System.out.println("결과 값 : "+ sum);

		scanner.close();
	}
}

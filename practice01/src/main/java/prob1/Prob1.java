package prob1;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		int number = 0;
		/* 코드 작성 */
		System.out.print("수를 입력하시오 :");
		number = scanner.nextInt();
		if(number % 3 == 0) {
			System.out.println("3의 배수입니다.");
		}
		scanner.close();
	}
}

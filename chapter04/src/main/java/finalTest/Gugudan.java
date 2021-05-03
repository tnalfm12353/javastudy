package finalTest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Gugudan {

	public static void main(String[] args) {
		
		int num1 = 0;
		int num2 = 0;
		int answer = 0;
		Set<Integer> randomNum = new HashSet<>();
		Scanner sc = new Scanner(System.in);
		
		while(num1 == 0 || num2 == 0) {
			num1 = (int)(Math.random()*10);
			num2 = (int)(Math.random()*10);
		}
		
		System.out.println(num1 +" x "+ num2 + " = ?");
		for(int i = 0 ; i <= 9 ; i++) {
			if(i == 5 ) {
				randomNum.add(num1*num2);
			}else {
				int num = 0;
				while(num == 0 || num > 81) {
					num = (int)(Math.random()*100);
				}
				randomNum.add(num);
			}
		}
		
		Iterator<Integer> temp = randomNum.iterator();
		int count = 0;
		while(temp.hasNext()) {
			if(count % 3 == 0 ) {
				System.out.println();
			}
			int num = temp.next();
			System.out.print(num + "\t");
			count++;
		}
		
		
		System.out.println("");
		System.out.print("answer : ");
		answer = sc.nextInt();
		System.out.println(num1 * num2 == answer ? "정답" : "오답");
	}

}

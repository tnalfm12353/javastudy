package prob2;

public class Prob2 {
	public static void main(String[] args) {
		int number[] = {1,2,3,4,5,6,7,8,9,10};
		
		for(int i = 0 ; i < 9 ; i++) {
			for(int j = 0 ; j < number.length ; j++) {
				System.out.print(number[j]);
				number[j] += 1;
			}
			System.out.println();
		}
	}
}

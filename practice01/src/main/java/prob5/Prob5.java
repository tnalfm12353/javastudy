package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		for(int i = 1 ; i <= 99; i++) {
			int clapCount = 0; 
			String intToString = String.valueOf(i); 
			if(intToString.charAt(0) % 3 == 0 ) {
				clapCount++;
			}
			if(i >= 10) {
				if(intToString.charAt(1) % 3 == 0 && intToString.charAt(1) != '0') {
					clapCount++;
				}
			}
			if(clapCount != 0) {
				System.out.print(i);
				for(int j = 0 ; j < clapCount; j++) {
					System.out.print("짝");
				}
				System.out.println();
			}
			
		}
		
	}
}

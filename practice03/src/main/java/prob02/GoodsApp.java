package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		System.out.println("상품 가격 수량을 입력해주세요 (Ex. 콜라 1000 10)");
		
		for(int i = 0 ; i < goods.length ; i++) {
			Goods good = new Goods();
			String goodInput = scanner.nextLine();
			String goodSplited [] = goodInput.split(" ");
			good.setName(goodSplited[0]);
			good.setPrice(Integer.valueOf(goodSplited[1]));
			good.setCountStock(Integer.valueOf(goodSplited[2]));
			goods[i] = good;
		}
			
		// 상품 출
		for(int i = 0 ; i < goods.length ; i++) {
			 goods[i].printout();
		}
		// 자원정리
		scanner.close();
	}
}

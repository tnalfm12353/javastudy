package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	private static void printDate01(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = sdf.format(date);
		System.out.println(now);
	}
	
	private static void printDate02(Date date) {
		// 년도(+1900)
		int year = date.getYear(); // 2021
		
		// 월(0~11) +1
		int month = date.getMonth();
		
		// 일
		int day = date.getDate();
		
		// 시
		int hour = date.getHours();
		
		// 분
		int minutes = date.getMinutes();
		
		//초
		int seconds = date.getSeconds();
		
		System.out.printf("%d-%d-%d %d:%d:%d",year + 1900, month + 1, day, hour, minutes, seconds);
	}
	
	public static void main(String[] args) {
		Date date = new Date();
		
		System.out.println(date);
		printDate01(date);
		printDate02(date);
	}

}

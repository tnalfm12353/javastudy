package chapter04;

import java.util.Calendar;

public class CalendarTest {

	private static void printDate(Calendar cal) {
		final String DAYS [] = { "일", "월", "화", "수", "목", "금", "토" };
		
		// 년
		int year = cal.get(Calendar.YEAR);
		// 월 (0 ~ 11) +1
		int month = cal.get(Calendar.MONTH);
		// 일
		int date = cal.get(Calendar.DATE);
		// 요일 -> 1(일) ~ 7(토)
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 시
		int hour = cal.get(Calendar.HOUR);
		// 분
		int minutes = cal.get(Calendar.MINUTE);
		// 초
		int seconds = cal.get(Calendar.SECOND);
		
		System.out.printf("%d-%d-%d %s요일 %d:%d:%d \n",year , month + 1, date, DAYS[day-1], hour, minutes, seconds);
	}
	
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		printDate(cal);
		
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DATE, 25);
		printDate(cal);
		
		cal.set(2021, 0, 30);
		cal.add(Calendar.DATE, 1000);
		printDate(cal);
	}
}

package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		String s = "aBcABCabcAbc";
		
		System.out.println(s.length());
		System.out.println(s.charAt(2));
		System.out.println(s.indexOf("abc"));
		System.out.println(s.indexOf("abc", 3));
		System.out.println(s.indexOf("abc", 7)); // -1
		System.out.println(s.substring(3));
		System.out.println(s.substring(3,5));
		
		String s2 = "             ab             cd           ";
		String s3 = "efg,hijk,lmn,opqr,stu";
		
		String s4 = s2.concat(s3);
		System.out.println(s4);
		
		System.out.println("----" + s2.trim() + "----");
		System.out.println("====" + s2.replaceAll(" ", "") + "====");
		
		// 정규표현식 regular expression 
		String p = "1000";
		if(p.matches("\\d+")) { // \d 숫자  
			int price = Integer.parseInt(p);
			System.out.println(price);
		}else {
			System.out.println("유효한 금액이 아닙니다.");
		}
		
		String tokens [] = s3.split(",");
		for(String token : tokens) {
			System.out.println(token);
		}
		
		System.out.println("===================================================");
		String tokens2 [] = s3.split("#");
		for(String token : tokens2) {
			System.out.println(token);
		}
		
		StringBuffer sb = new StringBuffer("");
		sb.append("Hello ");
		sb.append("World ");
		sb.append("Java ");
		sb.append(1.8);

		String s5= sb.toString();
		System.out.println(s5);
		
		//String s6 = "Hello " + "World " + "Java " + 1.8;
		String s6 = new StringBuffer("Hello ").append("World ").append("Java ").append(1.8).toString();
		System.out.println(s6);
		
		// 주의 : 문자열 + 연산을 하지 말아야 할 때 --> String s6 = "Hello " + "World " + "Java " + 1.8;
		String warning ="";
		for(int i = 0 ; i < 100000 ; i++) {
			//warning = s7 + i; 
			//warning = new StringBuffer(s7).append(i).toString();
		}
		
		StringBuffer useThis = new StringBuffer("");
		for(int i = 0 ; i < 100000 ; i++) {
			useThis.append(i);
		}
		String s7 = useThis.toString();
		System.out.println(s7.length());
	}

}

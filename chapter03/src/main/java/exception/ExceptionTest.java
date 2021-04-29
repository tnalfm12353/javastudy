package exception;


/** 
 * try ~ catch ~ finally 구문 만들기 연습
 *
 * Unchecked Exception (Error) - 예상하지 못한 에러 (DB가 꺼져있다던지 등등)
 * Checked Exception - 논리적 오류로 코드를 고쳐야함.
 * 
 *
 */
public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;
		
		System.out.println("Some Codes... 1");
		try {
			System.out.println("Some Codes... 2");
			int result = (1 + 2 + 3) / b;
//			int result = (1 + 2 + 3) / 1;
			System.out.println("Some Codes... 3");
		}catch (ArithmeticException e) {
			/* 에외 처리 */
			// 1. 사과 (사용자 인지)
			System.out.println("ㅈㅅㅈㅅ");
			// 2. 로깅 
			System.out.println("error : " + e);
			// 3. 정상 종료 
			return ;
		}finally {
			/* 자원정리 */
			System.out.println("Some Codes... final(자원정리)");
		}
	}

}
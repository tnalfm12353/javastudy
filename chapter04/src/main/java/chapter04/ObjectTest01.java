package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point point = new Point(10,10);

//		Class clazz = point.getClass();
		
		System.out.println(point.getClass()); // reflection
		System.out.println(point.hashCode()); // address 기반의 해싱값 출력  -> address 
		System.out.println(point.toString());
		System.out.println(point);
	}

}

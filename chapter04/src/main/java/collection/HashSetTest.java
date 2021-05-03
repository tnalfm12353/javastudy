package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		String s1 = new String("도우너");
		String s2 = new String("도우너");
		
		s.add("둘리");
		s.add("마이클");
		s.add("또치");
		s.add(s1);
		
		System.out.println(s.size());
		System.out.println(s1 == s2);
		System.out.println(s.contains(s2));
		
		// 순회 
		Iterator<String> itor =s.iterator();
		while(itor.hasNext()) {
			String str = itor.next();
			System.out.println(str);
		}
	}

}

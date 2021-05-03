package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class HashMapTest {

/**
 * HashMap은 키 값을 HashSet으로 저장함. 
 * 
 */

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		String ks1 ="one";
		map.put("one", 1); // auto Boxing
		map.put("two", 2);
		map.put("three", 3);
		
		
		int i = map.get(ks1); //auto unboxing
		int j = map.get(new String("one"));
		
		System.out.println(i + ":" + j);
		
		map.put("three", 333333);
		System.out.println(map.get("three"));
		
		// 순회
		Set<String> s = map.keySet();
		for(String key : s) {
			int val = map.get(key);
			System.out.println(val);
		}
		
	}

}

package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("뚤리");
		list.add("마이클");
		list.add("또치");
		
		// 순회 1
		int count = list.size();
		for(int i = 0 ; i < count ; i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		// 삭제
		list.remove(2);
		
		// 순회 2
		Iterator<String > itor = list.iterator();
		while(itor.hasNext()) {
			String s = itor.next();
			System.out.println(s);
		}
		
		// 순회 3
		for(String s : list) {
			System.out.println(s);
		}
	}

}

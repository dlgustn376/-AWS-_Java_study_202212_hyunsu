package J19_컬렉션;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapStringMain {

	public static void main(String[] args) {
		Map<String, String> strMap = new HashMap<>();

//		strMap.put("a", "A");
//		strMap.put("b", "B");
//		strMap.put("c", "C");
//		strMap.put("d", "D");

		strMap.put("가나다", "A");
		strMap.put("라마바", "B");
		strMap.put("사아자", "C");
		strMap.put("차카타", "D");

		System.out.println(strMap);

		System.out.println(strMap.get("a"));
		System.out.println(strMap.get("e"));

//		for(int i = 0); // 키 값이 0,1,2 ... 이런 식으로 진행 되지않는다.

//		for(String s : strMap) // 

		for (String k : strMap.keySet()) {
			System.out.println("key : " + k);
			System.out.println(strMap.get(k));
		}

		for (String v : strMap.values()) {
			System.out.println("value : " + v);
		}

		for (Entry<String, String> entry : strMap.entrySet()) {
			System.out.println(entry);
			System.out.println("Key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
			System.out.println();

		}

		System.out.println("=========================================");

		strMap.forEach((k, v) -> {
			System.out.println("Key : " + k);
			System.out.println("value : " + v);
		});
	}
}

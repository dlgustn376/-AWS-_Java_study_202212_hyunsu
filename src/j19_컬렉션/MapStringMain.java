package j19_컬렉션;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapStringMain {
	
	public static void main(String[] args) {
		Map<String, String> strMap = new HashMap<>();
//		key 값의 해쉬코드 정렬
		
		strMap.put("이종현", "a");
		strMap.put("진채희", "b");
		strMap.put("김재영", "c");
		strMap.put("이상현", "d" );
		
		System.out.println(strMap);
		
		System.out.println(strMap.get("a"));
		System.out.println(strMap.get("e"));
		
//		strMap.entrySet();
//		strMap.keySet(); 키값 가져오기
		for(String k : strMap.keySet()) {
			System.out.println("key: " + k);
			System.out.println(strMap.get(k));
		}
		
		for(String v : strMap.values()) {
			System.out.println("vlaue: " + v);
		}
		
		
//		key와 value를 한꺼번에 가져오고 싶을 때, entry
//		하나하나 entry로 들어감. Map 안에 존재.
//		entry 객체, 
		System.out.println(strMap.entrySet());
		
//		Set<Entry<String, String>> s = null;
//		Set인데 Entry를 담는 Set 형태
		
		for(Entry<String, String> entry : strMap.entrySet()) {
			System.out.println(entry);
			System.out.println("key: " + entry.getKey());
			System.out.println("value: " + entry.getValue());
			System.out.println();
			
		}
		System.out.println("=======================================");
		
		strMap.forEach((k, v) -> {
			System.out.println("key: " + k);
			System.out.println("value: " + v);
		});
		
	}
	
}

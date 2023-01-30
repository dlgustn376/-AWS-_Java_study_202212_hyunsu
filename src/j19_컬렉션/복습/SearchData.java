package j19_컬렉션.복습;

import java.util.HashMap;
import java.util.Map;

public class SearchData {
	
	
	
	public static void main(String[] args) {
		Map<String, String> searchData = new HashMap<>();
		
		searchData.put("catagory", "소설");
		searchData.put("serachValue", "불편한 편의점");
		
		// 단순히 map을 toString한것
		System.out.println(searchData);
		
		System.out.println(searchData.get("catagory"));
		System.out.println(searchData.get("serachValue"));
		
		System.out.println(searchData.keySet());
		System.out.println(searchData.values());
		
		// entrySet으로 entry를 뽑은 것.
		System.out.println(searchData.entrySet());
		
//		key 값은 Set으로 순서가 없어서 꺼낼 수 없다.
//		for(int i = 0; i < searchData.size(); i++) {
//			System.out.println(searchData.get(null));
//		}
		
//		key값을 가져와서 넣고 value를 뽑아낸다.
		for(String key : searchData.keySet()) {
			System.out.println(searchData.get(key));
		}
		
	}
	
	
}

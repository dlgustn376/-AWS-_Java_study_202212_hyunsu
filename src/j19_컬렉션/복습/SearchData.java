package j19_컬렉션.복습;

import java.util.HashMap;
import java.util.Map;

public class SearchData {

	public static void main(String[] args) {
		Map<String, Object> searchData = new HashMap<>();

		searchData.put("category", "소설");
		searchData.put("searchValue", "불편한 편의점");

		System.out.println(searchData); // map

		System.out.println(searchData.get("category"));
		System.out.println(searchData.get("searchValue"));

//		v 반복 가능
		System.out.println(searchData.keySet());
		System.out.println(searchData.values());

		System.out.println(searchData.entrySet()); // entryset

//		for (int i = 0; i < searchData.size(); i++) {
//			System.out.println(searchData.get(null));
//		}

		for (String key : searchData.keySet()) {
			System.out.println(searchData.get(key));
		}
	}

}

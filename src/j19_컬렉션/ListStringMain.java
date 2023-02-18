package J19_컬렉션;

import java.util.ArrayList;

public class ListStringMain {
	public static void main(String[] args) {
		String[] strArray = new String[] { "java", "python", "C++" };

		// 배열공간 +1, "html"을 집어 넣어준다.
		String[] newStrArray = new String[strArray.length + 1];

		for (int i = 0; i < strArray.length; i++) {
			newStrArray[i] = strArray[i];
		}
		newStrArray[strArray.length] = "html";

		System.out.println("[strArray]");
		for (String str : strArray) {
			System.out.println(str);
		}

		System.out.println();

		System.out.println("[newstrArray]");
		for (String str : newStrArray) {
			System.out.println(str);
		}
		System.out.println();

		////////////////////////////////////////////////////////////

		ArrayList<String> strList = new ArrayList<String>/* <> */(); // 자동으로 <> String이 들어간다. 생략 가능

		strList.add("Java");
		strList.add("Python");
		strList.add("Python");
		strList.add("Python");
		strList.remove("Python");
		strList.add(1, "Java");
		strList.remove(1);
		
		//1
		for (int i = 0; i < strList.size(); i++) {
			System.out.print("[" + i +"]: ");
			System.out.println(strList.get(i));
		}
		//2
		for(String str: strList) {
			System.out.println(str);
		}

	}

}

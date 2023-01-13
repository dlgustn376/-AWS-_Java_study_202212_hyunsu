package j19_컬렉션;

import java.util.ArrayList;

public class ListStringMain {
	
	public static void main(String[] args) {
		String[] strArray = new String[] {"java", "python","c++"};
		String[] newStrArray = new String[strArray.length + 1];
		
		for(int i = 0; i < strArray.length;i++) {
			newStrArray[i] = strArray[i];
		}
		newStrArray[strArray.length] = "html";
		
		System.out.println("[StrArray]");
		for(String str : strArray) {
			System.out.println(str);
		}
		System.out.println("\n");
		
		System.out.println("[newStrArray]");
		for(String str : newStrArray) {
			System.out.println(str);
		}
		System.out.println();
		//////////////////////////////////////////////////////////////
//		ArrayList<>
		
//		ArrayList<?> strList = new ArrayList<>();
//		((ArrayList<String>)strList).add("java");
//		new ArrayList<>().add("test"); 이렇게 사용하면 안됨.
		
		ArrayList<String> strList = new ArrayList<>();

		strList.add("java");
		strList.add("phthon");
		strList.add("phthon");
		strList.add("phthon");
		strList.add("phthon");
		strList.add("phthon");
		strList.remove("java");
		strList.add(1, "java");
		strList.remove(1);
		
		
		for(int i = 0; i < strList.size(); i++) {
			System.out.print("[" + i +"]: ");
			System.out.println(strList.get(i));
		}
		
		for(String str : strList) {
			System.out.println(str);
		}
		
//		System.out.println(strList);
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
	}
}

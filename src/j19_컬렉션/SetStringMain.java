package j19_컬렉션;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetStringMain {
	
	public static void main(String[] args) {
		Set<String> setStr = new HashSet<>();
		List<String> listStr = new ArrayList<>();
		
		listStr.add("임나영");
		listStr.add("이강용");
		listStr.add("임나영");
		listStr.add("임나영");
		
		System.out.println(listStr);
		
		setStr.add("김상현");
		setStr.add("강대협");
		setStr.add("손지호");
//		중복 안됨.
		setStr.add("최해혁");
		setStr.add("최해혁");
		setStr.addAll(listStr);

		System.out.println(setStr);
//		무조건 forEeach로 값을 직접 꺼내서 사용.
		
		String searchName = "손지호";
		
//		값을 직접 비교
		for(String name : setStr) {
// 키값이 없기 때문에 값을 직접 꺼내야 함.
			if(name.equals(searchName)) {
				System.out.println(name);
				break;
			}
		}
//		Map에서 반복을 돌리려면 람다를 알아야하는데 모르면 이터레이터를 사용해야 함.
		
		Iterator<String> iterator =  setStr.iterator();
		while(iterator.hasNext()) {
			String n = iterator.next();
			if(n.equals(searchName)) {
				System.out.println(n);
			}
		}
		
		
		
		
	}
	
	
}

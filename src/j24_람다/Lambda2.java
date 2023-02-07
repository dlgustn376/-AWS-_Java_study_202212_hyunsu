package j24_람다;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda2 {
	
	public static void main(String[] args) {
		
//		1.Runnable - run()
		Runnable a = () -> System.out.println("하나만 실행");
		Runnable b = () -> {
			System.out.println("여");
			System.out.println("러");
			System.out.println("명");
			System.out.println("령");
			System.out.println("실");
			System.out.println("행");
		};
//		하나만 실행하기에 중괄호를 생략
		a.run(); 
		a.run(); 
		
//		여러개를 실행하기에 중괄호 포함.
		b.run();
		
		
//		2. Supplier<T> - T get()
//		매개변수 없음.
 		Supplier<LocalDate> c = () -> LocalDate.now(); 
 		Supplier<String> d = () -> {
 			LocalDate now = LocalDate.now();
 			return now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
 		};
 				
 		System.out.println(c.get());
 		System.out.println(d.get());
 				
 				
// 		3. Consumer<T> - accept(T t) 
// 		매개변수를 받아서 처리만 해줌.
// 		정의 와 생성 부분
 		Consumer<String> e = name -> {
 			System.out.println("이름: " + name);
 			System.out.println("오늘 날짜: " + d.get());
 		};
 		
// 		호출
 		e.accept("이종현");
 		
// 		
// 		메소드 참조 표현식 ([인스턴스]::[메소드명 또는 new])
 		Consumer<String> f = System.out::println;
 		f.accept("출력");
 		
 		List<String> names = new ArrayList<>();
 		
 		names.add("김동민");
 		names.add("김두영");
 		names.add("장진원");
 		names.add("조병철");
 		
 		
 		Consumer<String> g = name -> 
 			System.out.println("이름: " + name + "님");
 		names.forEach(g);
 		System.out.println();
 		
// 		names.forEach(name -> System.out.println("이름: " + name + "님"));
 		
// 		여기서 this = names
 		
// 		default void forEach(Consumer<? super String> action) {
// 	        Objects.requireNonNull(action);
// 	        for (String t : this) {
// 	            action.accept(t);
// 	        }
// 	    }
 		
 		
 		names.forEach(name->{
 			System.out.println("이름을 출력합니다.");
 			System.out.println("이름: " + name);
 			System.out.println();
 		});
 		
//==========================================================================================================
 		
 		Map<String, String> userMap = new HashMap<>();
 		userMap.put("username", "aaa");
 		userMap.put("password", "1234");
 		
 		userMap.forEach((key, value) ->{
 			System.out.println("key: " + key);
 			System.out.println("value: " + value);
 			System.out.println();
 		});
 		
 		for(Entry<String,String> entry : userMap.entrySet()) {
 			System.out.println("key: " + entry.getKey());
 			System.out.println("value: " + entry.getValue());
 			System.out.println();
 		}
 		
 		//4. Function<T, R>
 		
 		Function<String, Integer> h = num ->Integer.parseInt(num); 
 		int convertStrNum1 = h.apply("10000");
 		int convertStrNum2 = h.apply("20000");
 		
 		System.out.println(convertStrNum1 + convertStrNum2);
 		System.out.println();

 		//5. Predicate<T>
// 		Predicate<String> p = str -> str.startsWith("김");
// 		Predicate<String> p2 = str -> str.startsWith("이");
 		
 		Function<Predicate<String>, Boolean> function1 = 
 				predicate -> predicate.or(str -> str.startsWith("이")).test("김준일");
 		
 		boolean rs = function1.apply(str -> str.startsWith("김"));
 		System.out.println(rs + "\n");
// 		System.out.println(p.test("김준일") || p2.test("김준일"));
// 		System.out.println(p.or(p2).test("김준일"));
// 		System.out.println(p.or(p2).test("이준일"));
// 		System.out.println(p.or(p2).test("박준일"));
 	
 		
 		List<String> nameList = new ArrayList<>();
 		nameList.add("김종환");
 		nameList.add("고병수");
 		nameList.add("김상현");
 		nameList.add("김준경");
 		
// 		6. 스트림 -> 일회용.
 		Stream<String> stream = nameList.stream().filter(name -> name.startsWith("김"));
// 		stream.forEach(name -> System.out.println(name));
 		
 		List<String> newList = stream.collect(Collectors.toList());
 		
 		System.out.println(newList);
 		newList.forEach(str -> System.out.println(str));
// 		System.out.println(stream);
 		
 		System.out.println("============================================================");
 		
 		nameList.stream()
 			.filter(name-> name.startsWith("김"))
 			.collect(Collectors.toList())
 			.forEach(System.out::println);
// 			.stream()
// 			.filter(name -> name.startsWith("고"))
// 			.collect(Collectors.toList())
// 			.forEach(name -> System.out.println(name));
 		
 		
 		
 		
 		
 		
 		
 		
 		
	}
}

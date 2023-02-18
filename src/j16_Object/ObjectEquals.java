package J16_Object;

public class ObjectEquals {
	public static void main(String[] args) {
		String name1 = "김준일";
		String name2 = "김준일";
		String name3 = new String("김준일");
		
		
		System.out.println(name1);
		System.out.println(name2);

		System.out.println(name1 == name2); // 주소를 비교하는 과정이다.
		System.out.println(name1.equals(name3)); 
		
		////////////////////////////////////////////////////////////////////
		
		Student s1 = new Student("박은빈", 24);
		Student s2 = new Student("박은빈", 24);
		SubStudent s3 = new SubStudent ("박은빈", 24);
		
		System.out.println(s1.equals(s1));
		
		
		
		
		
		
		
		
//		Student s1 = new Student("박은빈", 24);
//		Student s2 = new Student("박은빈", 24);
//						
//		System.out.println(s1 == s2); // new new 따로 생성을 하여서 주소가 다르다.
//		System.out.println(s1.equals(s2));
		
		////////////////////////////////////////////////////////////////////
		
//		Student s = new Student("박은빈", 24);
//		Student s3 = s;
//		Student s4 = s;
//
//		System.out.println(s3 == s4); // new new 따로 생성을 하여서 다르다.
		
		
		
	}
}

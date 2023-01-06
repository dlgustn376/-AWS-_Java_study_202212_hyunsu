package j11_접근지정자;

import j11_접근지정자.default1.J11_StudentDefault;

public class J11_StudentMain {
	
	public static void main(String[] args) {
		J11_Student s1 = new J11_Student(null, 0);
		s1.setName("이현수");
		
		s1.printInfo();
		
		J11_StudentDefault s2 = new J11_StudentDefault(); // 다른 패키지 않에 있기때문에
		
//		s2.name = "김철수";
//		
//		System.out.println("이름: " + s2.name);
		s2.setName("김철수");
		System.out.println("이름: " + s2.getName());
		
	}
	
}

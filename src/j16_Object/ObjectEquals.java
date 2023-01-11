package j16_Object;

public class ObjectEquals {
	
	public static void main(String[] args) {
		
//		주소가 같은 상태
//		리터럴주소
		String name1 = "김준일";
		String name2 = "김준일";
//		다른 주소값
		String name3 = new String("김준일");
		
		System.out.println(name1);
		System.out.println(name2);
		System.out.println(name3);
		
//		주소값 비교
//		Student s = new Student("박은빈",24);
//		Student s1 = s;
//		Student s2 = s;
		System.out.println(name1 == name2);
//		실질적인 값의 비교확인
		System.out.println(name1.equals(name3));
		
		
		
///////////////////////////////////////////////////////////////////////////////
		
//		각가 다른 주소값
		Student s1 = new Student("박은빈",24);
		Student s2 = new Student("박은빈",24);
		SubStudent s3 = new SubStudent("박은빈", 24);
		
//		매개변수가 대입되면서 업캐스팅이 됨.
		System.out.println(s1.equals(s3));
		
		
		
		
	}
	
}
/*
 * equals를 오버라이드 해서
 * 내용이 같은 인스턴트 객체를 같다고 어떻게 판다할 것인가.

 	public boolean equals(Object obj) {
        주소 비교
        return (this == obj); 
    }
    
    
 */

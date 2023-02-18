package j09_클래스;

public class J09_StudentMain {
	public static void main(String[] args) {
//		J09_Student student1 = new J09_Student();
//		J09_Student student2 = new J09_Student(); // = : 대입 -> 값을 넣는다.
//		/*^자료형*//*^변수명*//*^키워드*//*^값*/
//		
//		System.out.println(student1);
//		System.out.println(student2);
//		System.out.println(new J09_Student());
//		int a = 0;
//		System.out.println(a);

		J09_Student s1 = new J09_Student();
		J09_Student s2 = new J09_Student();

		s1.name = "김준일";
		s1.age = 30;

		s1.printInfo();

		s2.printInfo();

	}

}

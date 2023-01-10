package j09_클래스;

public class J09_StudentMain {
	
	public static void main(String[] args) {
		
//		int a; // 초기화를 해야함. 스택영역은 자동으로 초기화 안됨.
//		
//		System.out.println(a);
		
		J09_Student student1 = new J09_Student(); // 생성자 호출
		J09_Student student2 = new J09_Student(); // 생성자 호출
		
		student1.setName("이현수");
		student1.setAge(25);
		 
		student1.printInfo();

		student2.printInfo();
		 
		 
	}
	
}

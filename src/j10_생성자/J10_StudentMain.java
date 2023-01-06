package j10_생성자;

public class J10_StudentMain {
	
	public static void main(String[] args) {
		
		// 인스턴스를 생성할 때 부터 값을 가지고 생성.
		J10_Student student1 = new J10_Student();
		J10_Student student2 = new J10_Student("김철수", 17);
		
		student1.printInfo();
		student2.printInfo();
		
	}	
}

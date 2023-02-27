package j11_접근지정자;

public class J11_StudentMain {
	public static void main(String[] args) {
		J11_Student s1 = new J11_Student();
		s1.name = "김준일";
		
		s1.printInfo();
		
		J11_StudentDefualt s2 = new J11_StudentDefualt();
		
//		s2.name = "김준이";
		
//		System.out.println("이름 : " + s2.name);
		System.out.println("이름 : " + s2.getName());
		
				
	}
}

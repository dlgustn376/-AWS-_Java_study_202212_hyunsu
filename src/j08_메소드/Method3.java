package j08_메소드;

public class Method3 {

	// 메소드의 오버로딩(오버로드)

	
	public static void ov1() {
		System.out.println("매개변수 없음");
	}
	public static void ov1(int a) {// 매개변수 형태가 다르면 같은 이를 사용이 가능하다. 
		System.out.println("int 매개변수 하나");
	}
	public static void ov1(int a, String b) {
		System.out.println("int  먼저 그 다음 String");
	}
	public static void ov1(String a, int b) { 
		System.out.println("String  먼저 그 다음 int");
	}
	
	public static void main(String[] args) {
		ov1();
		ov1(10);
		
		
	}

}

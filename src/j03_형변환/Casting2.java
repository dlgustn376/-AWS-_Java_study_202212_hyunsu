package j03_형변환;

public class Casting2 {

	public static void main(String[] args) {
		char char_a = 'a';
		int num = (int) char_a; // Up Casting 자동으로 형변환이 됨. 묵시적 형변환.
		
		// char char_b = (char) num + 1; --> 안 됨.
		char char_b = (char) (num + 1) ; // Down Casting에서는 무조건 형변환 명시해야 함.
										 // 형변환이 연산자 보다 우선순위가 높다. 
		System.out.println('a' + 1);
		System.out.println(char_b);
	}

}

package j02_변수;

public class Variable3 {

	public static void main(String[] args) {
		// 상수: 자료형 앞에 final이 붙는다.
		// 상수는 상수명을 무조건 대문자로 사용을 한다.
		final int NOW_AGE = 10; // 선언 및 초기화
		
		System.out.println(NOW_AGE);
		
		float fnum = 3.14F; // F앞의 숫자는 리터럴 상수 실수로 double형이 기본형이다.
		System.out.println(fnum);
		
		long num = 12345678900L; // L앞의 숫자는 리터럴 상수 정수로 int형이 기본형이다.
		System.out.println(num);
		
	}

}

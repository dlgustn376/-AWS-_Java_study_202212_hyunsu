package j01_출력;


public class HelloJava { // 클래스는 대문자로 시작한다. 변수명과 겹치기 때문이다.

	// 주석 : 코드 내부에 메모를 할 때 사용한다. 컴파일 시에 무시된다.
	// 한 줄 주석을 뜻한다.
	// Tab(띄어쓰기4칸X) 들여쓰기이다.

	/*
	 * 여러 줄 주석 1 2 3
	 * 
	 * 4 5 6
	 */

	/**
	 * 클래스, 메소드 등의 정보를 설명하기 위한 주석이다.
	 */
	// 프로그램의 시작점
	public static void main(String[] args) {
		System.out.println("Hello, Java!!"); // 한 줄의 문자열을 출력 후 끝에 줄 바꿈을 해라.
		System.out.println("이름 : 김준일");
		System.out.println("주소 : 부산 동래구 사직동");
		System.out.print("연락처 : 010-9988-1916");
		System.out.print("수업 : AWS 기반 공공빅데이터 활용 웹개발자 양성");
		
		System.out.println();
		
	}

}

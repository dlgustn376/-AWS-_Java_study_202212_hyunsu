package j07_반복;

import java.util.Scanner;

public class While3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String select = null;
		
		while(true) {
			System.out.print("x 입력시 멈춤: ");
			select = scanner.nextLine();  // 입력을 기다림. 
			
			if(select.equals("x") || select.equals("X")) {  // 문자열을 비교할 때는 equals()를 사용해야 함.
				System.out.println("프로그램을 멈춥니다.");
				break;
			}
		
			System.out.println("계속 실행!");
		}
		
		System.out.println("프로그램 종료됨!");
		
		
	}
}

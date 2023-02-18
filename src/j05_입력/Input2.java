package j05_입력;

import java.util.Scanner; // Ctrl + shift + O -> import 자동 

// 변수 5개를 받고 5개를 출력

public class Input2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int inputNum = 0; // = 0; 은 가능하면 붙여준다. 초기화
		int inputNum2 = 0;
		int inputNum3 = 0;
		int inputNum4 = 0;
		int inputNum5 = 0;
		
		System.out.print("입력1: ");
		inputNum = scanner.nextInt();
		System.out.print("입력2: ");
		inputNum2 = scanner.nextInt();
		System.out.print("입력3: ");
		inputNum3 = scanner.nextInt();
		System.out.print("입력4: ");
		inputNum4 = scanner.nextInt();
		System.out.print("입력5: ");
		inputNum5 = scanner.nextInt();
	
		System.out.println("입력값 : " + (inputNum + inputNum2 + inputNum3 + inputNum4 + inputNum5));
	}

}

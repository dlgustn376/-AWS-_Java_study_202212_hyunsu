package j05_입력;

import java.util.Scanner; // Ctrl + shift + O -> import 자동 

// 변수 5개를 받고 5개를 출력

public class Input1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("문자열1 : ");
		String str1 = scanner.nextLine();
		System.out.println("문자열2 : ");
		String str2 = scanner.nextLine();
	}

}

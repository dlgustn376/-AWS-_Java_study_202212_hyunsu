package j05_입력;

import java.util.Scanner;

public class Input2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int number1 = 0;
		double number2 = 0.0;
		
		System.out.print("문자열1: ");
		String str1 = scanner.nextLine();
		
		System.out.print("문자열2: ");
		String str2 = scanner.next();
		
		System.out.print("정수: ");
		number1 = scanner.nextInt();

		System.out.print("실수: ");
		number2 = scanner.nextDouble();
		
		System.out.println("문자열1: " + str1);
		System.out.println("문자열1: " + str2);
		System.out.println("정수: " + number1);
		System.out.println("실수: " + number2);
		
		
	}
}

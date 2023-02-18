package j05_입력;

import java.util.Scanner; // Ctrl + shift + O -> import 자동 

// 변수 3개를 받고 3개 출력하고 최대값 최소값 출력하기

public class Input4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = 0;
		int b = 0;
		int c = 0;
		
		int max = 0;
		int min = 0;
		
		System.out.println("정수 3개 입력 : ");
		a = scanner.nextInt();
		b = scanner.nextInt();
		c = scanner.nextInt();
		
		max = a;
		max = b > max ? b : max;
		max = c > max ? c : max;
		min = a;
		min = b < min ? b : min;
		min = c < min ? c : min;
		
			
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
		
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	}

}

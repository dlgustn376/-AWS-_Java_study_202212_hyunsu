package j07_반복;

import java.util.Scanner;

public class Loop3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
//		int loop = 0;
//		int a = 0;
//		int b = 0;
//		int total = 0;
//		
//		System.out.print("반복횟수 : ");
//		loop = scanner.nextInt();
//
//		System.out.println(loop + "번 반복");
//		System.out.print("a : ");
//		a = scanner.nextInt();
//		System.out.print("b : ");
//		b = scanner.nextInt();
//				
//		for(int i = 0; i < loop + 1 ; i ++) {			
//			loop += i;
//		
//		}
//		
//		System.out.println(loop + "번 합: " + total);
		int count = 0;
		int total = 0;
		System.out.print("반복횟수 : ");
		count = scanner.nextInt();
		System.out.println();
		
		for(int i = 0; i < count ; i ++) {		
		
		int a = 0; // 밖에 작성하지 않고 안에 작성 하는 이유는  a,b는 여기 반복문 내부에서만 사용하기 때문이다.
		int b = 0;
		
		System.out.println(i + 1 + "번 반복");
		System.out.print("a : ");
		a = scanner.nextInt();
		System.out.print("b : ");
		b = scanner.nextInt();
		
		total += a + b;
		System.out.println(i + 1 + "번 합: " + (a + b)); // "\n"로 줄바꿈을 해도 된다. "\0" -> 공백
		System.out.println();
		}
		System.out.println("총합 : " + total);
	}
}
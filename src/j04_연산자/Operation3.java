package j04_연산자;

/*
 * 논리연산자
 * 
 * AND(곱)
 * T && T = 1
 * T && F = 0
 * 조건 중 하나라도 0 이면 0이다.
 * 
 * OR(합)
 * T || F
 * 하나라도 1 이면 1이다.
 * 
 * NOT(부정) !T = F
 * 
 * 
 * XOR도 있다.
 */

public class Operation3 {

	public static void main(String[] args) {
		int num = 11;
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = num % 2 == 0;
				
		System.out.println(flag1 && flag2);
		System.out.println(flag1 && flag3);
		System.out.println(!(flag2 || flag3 && flag1));
		

	}

}

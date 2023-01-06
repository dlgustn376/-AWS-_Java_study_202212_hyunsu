package j04_연산자;

/*
 * 논리연산자
 *  
 *  AND (곱) T && T, T && F 둘 다 참 이면 참
 *  
 *  OR (합) T || T, T || F, F || T, F || F 둘 중 하나만 참이면 참
 *  
 *  NOT (부정) !T, !F 참은 거짓, 거짓은 참
 *  
 *  AND 연산이 OR 연산보다 우선.
 */

public class Operation3 {
	public static void main(String[] args) {
		int num = 11;
		
		
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = num % 2 > 0;
		
		System.out.println(flag1 && flag2);
		System.out.println(flag1 && flag3);
		System.out.println(!(flag2) || !(flag3) && !(flag1));
	}
}

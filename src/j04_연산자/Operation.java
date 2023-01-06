package j04_연산자;

public class Operation {
	public static void main(String[] args) {
		int add = 1 + 2;
		int sub = 10 - 5;
		int mul = 10 * 2;
		int div = 10 / 5;
		int remainder = 10 % 5;
		
		System.out.println(add);
		System.out.println(sub);
		System.out.println(mul);
		System.out.println(div);
		System.out.println(remainder); // 배수. 2로 나누었을 때, 짝수 or 홀수 
		
		System.out.println(remainder == 0 ? "5의 배수이다" : "5의 배수가 아니다");
		
	}
}

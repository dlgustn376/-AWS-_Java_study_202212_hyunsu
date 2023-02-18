package j04_연산자;

public class Operation1 {

	public static void main(String[] args) {
		int add = 1 + 2;
		int sub = 10 - 5;
		int mul = 10 * 2;
		int div = 10 / 5;
		int remainder = 10 % 5;
		
		System.out.println(add); // ctrl + alt + 방향키 위 아래 -> 복사
		System.out.println(sub); // 
		System.out.println(mul);
		System.out.println(div);
		System.out.println(remainder);
		
		System.out.println(remainder == 0 ? "5의 배수이다." : "5의 배수가 아니다.");

	}

}

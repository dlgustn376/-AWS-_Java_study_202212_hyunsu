package j04_연산자;

public class Operation5 {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 5;
				
		int result =  num1 > num2 ? num1 * -1 : num2 * -1;
		
		System.out.println(result);
		
		System.out.println("================================");
		
		int num = 79;
		
		int result2 = num / 90 == 1 ? 90 
				: num / 80 == 1 ? 80 // 줄을 바꿀 때는 들여쓰기 2칸을 한다.
				: num / 70 == 1 ? 70 : 0;
		
		System.out.println(result2);

	}

}

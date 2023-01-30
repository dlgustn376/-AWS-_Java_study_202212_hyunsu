package j12_배열.복습;

public class Array1 {
	
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int num4 = 40;
		int num5 = 50;
		
		
		int[] nums = new int[5];
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		nums[3] = 40;
		nums[4] = 50;
		
		System.out.println("num1: " + num1);
		System.out.println("num2: " + num2);
		System.out.println("num3: " + num3);
		System.out.println("num4: " + num4);
		System.out.println("num5: " + num5);
		System.out.println();
		
		for(int i = 0; i < nums.length; i++) {
			System.out.println("nums[" + i + "]: " + nums[i]);
		}
		
		
		
	}
}

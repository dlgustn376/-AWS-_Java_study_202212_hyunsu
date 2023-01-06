package j12_배열;

import java.util.Random;
	

public class Array3 {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		int[] nums = new int[10];
		
		for(int i = 0; i < nums.length; i++) {
			
			while(true) {
				// 선형 검색을 위한 논리
				boolean findFlag1 = true;			
				// 생성하는 명령
				int randomNum = random.nextInt(nums.length) + 1;

				// 검사하는 반복
				for(int j = 0; j < nums.length; j++) {
					if(nums[j] == randomNum) {			
						findFlag1 = false;				
						break;							
					}									
				}
				
				if(findFlag1) {							
					nums[i] = randomNum;			
					break;							
				}										
			}
		}
		
		for(int i = 0; i < nums.length - 1; i++) {
			System.out.print(nums[i] + ", ");
		}
		System.out.println(nums[nums.length - 1]);
		
		
	}

}

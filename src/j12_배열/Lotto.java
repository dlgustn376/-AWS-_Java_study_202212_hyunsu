package j12_배열;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		int correctNum = 0;
		int[] nums = new int[7];
		int[] myNums = new int[6];
		
		// 추첨된 번호 6개 + 보너스 1개 = 총 7개	
		for(int i = 0; i < nums.length; i++) {
			
			while(true) {
				// 선형 검색을 위한 논리값
				boolean findFlag1 = true;			
				// 생성하는 명령
				int lottoNum = random.nextInt(45) + 1;
				// 검사하는 반복
				for(int j = 0; j < nums.length; j++) {
					if(nums[j] == lottoNum) {			
						findFlag1 = false;				
						break;							
					}									
				}
					
				if(findFlag1) {							
					nums[i] = lottoNum;			
					break;							
				}										
			}
		}
		
		//Arrays.sort(nums);
		
		// 6개 번호가 생성
		for(int i = 0; i < myNums.length; i++) {
			while(true) {
				boolean findFlag2 = true;
				int lottoNum = random.nextInt(45) + 1;
				
				for(int j = 0; j < myNums.length; j++) {
					if(myNums[j] == lottoNum) {
						findFlag2 = false;
						break;
					}
				}
				if(findFlag2) {
					myNums[i] = lottoNum;
					break;
				}
			}
		}
		
		//Arrays.sort(myNums);
		
		// 6번 비교
		for(int i = 0; i < nums.length - 1; i++) {
			
			while(true) {
				boolean findFlag3 = true;
				// 6번 비교
				for(int j = 0; j < myNums.length; j++) {
					if(nums[i] == myNums[j]) {
						correctNum += 1;
						break;
					}
				}
			
				if(findFlag3) { // 참이란것은 일치하는 숫자가 없다는 의미.
					break;

				}
				
			}// while 문 마지막
			
		}// for 문 마지막
		
		for(int i = 0; i < nums.length - 1; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println("보너스 번호: "+ nums[nums.length - 1]);
		
		for(int i = 0; i < myNums.length - 1; i++) {
			System.out.print(myNums[i] + " ");
		}
		System.out.println(myNums[myNums.length - 1]);
		
		
		if(correctNum < 3) {
			System.out.println("낙첨");
		}else if(correctNum == 3) {
			System.out.println("5등 당첨");
		}else if(correctNum == 4) {
			System.out.println("4등 당첨");
		}else if(correctNum == 5) {
			for(int i = 0; i < myNums.length; i++) {
				if(nums[6] == myNums[i]) {
					correctNum += 1;
				}
			}

			if(correctNum == 6) {
				System.out.println("축 2등 당첨");				
			}else {
				System.out.println("3등 당첨");
			}

		}else {
			System.out.println("축하합니다. 1등입니다.");
		}

		System.out.println("당첨 개수: " + correctNum);
		
	}
	
}
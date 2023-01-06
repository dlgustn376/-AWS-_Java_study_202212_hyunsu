package j07_반복;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean loopFlag1 = true;
		
		while(loopFlag1) {
			char select = '\0';
			
			System.out.println("========<< 식당 메뉴 >>========");
			System.out.println("1. 김밥천국");
			System.out.println("2. 탄탄면");
			System.out.println("3. 홍대개미");
			System.out.println("4. 밥앤밥");
			System.out.println("===============================");
			System.out.println("q. 프로그램 종료");
			System.out.println("===============================");

			System.out.print("식당 선택: ");
			select = scanner.next().charAt(0);
//			select = scanner.next() 여기까지 문자열 .charAt(0);
			
			if(select == 'q' || select == 'Q') {
				loopFlag1 = false;
			}else if(select == '1') {
				boolean loopFlag2 = true;
				
				while(loopFlag2) {
					System.out.println();
					System.out.println("========<< 김밥천국 >>========");
					System.out.println("1. 라면");
					System.out.println("2. 돌솥비빔밥");
					System.out.println("3. 오므라이스");
					System.out.println("4. 김치볶음밥");
					System.out.println("==============================");
					System.out.println("b. 뒤로가기");
					System.out.println("q. 프로그램 종료");
					System.out.println("==============================");
					
					System.out.print("메뉴 번호 선택: ");
					select = scanner.next().charAt(0);
					
					if(select == 'b' || select == 'B') {
						loopFlag2 = false;
					} else if(select == 'q' || select == 'Q') {
						loopFlag1 = false;
						loopFlag2 = false;
					}else if (select == '1') {
						System.out.println("라면을 선택하였습니다.");
					}else if (select == '2') {
						System.out.println("돌솥비빔밥을 선택하였습니다.");
					}else if (select == '3') {
						System.out.println("오므라이스를 선택하였습니다.");
					}else if (select == '4') {
						System.out.println("김치볶음밥을 선택하였습니다.");						
					}else {
						System.out.println();
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						System.out.println("사용 할 수 없는 번호입니다.");
						System.out.println("다시 입력하세요.");
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					}
					System.out.println();
				}
				
			}else if(select == '2') {
				boolean loopFlag2 = true;
				
				while(loopFlag2) {
					System.out.println();
					System.out.println("========<< 탄탄면 >>========");
					System.out.println("1. 탄탄면");
					System.out.println("2. 청양탄탄면");
					System.out.println("3. 사천탄탄면");
					System.out.println("4. 마라탄탄면");
					System.out.println("============================");
					System.out.println("b. 뒤로가기");
					System.out.println("q. 프로그램 종료");
					System.out.println("============================");
					
					System.out.print("메뉴 번호 선택: ");
					select = scanner.next().charAt(0);
					
					if(select == 'b' || select == 'B') {
						loopFlag2 = false;
					} else if(select == 'q' || select == 'Q') {
						loopFlag2 = false;
						loopFlag1 = false;
					}else if (select == '1') {
						System.out.println("탄탄면을 선택하였습니다.");
					}else if (select == '2') {
						System.out.println("청양탄탄면을 선택하였습니다.");
					}else if (select == '3') {
						System.out.println("사천탄탄면을 선택하였습니다.");
					}else if (select == '4') {
						System.out.println("마라탄탄면을 선택하였습니다.");						
					}else {
						System.out.println();
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						System.out.println("사용 할 수 없는 번호입니다.");
						System.out.println("다시 입력하세요.");;
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					}
					
					System.out.println();
				}
				
			}else if(select == '3') {
				boolean loopFlag2 = true;
				
				while(loopFlag2) {
					System.out.println();
					System.out.println("========<< 홍대개미 >>========");
					System.out.println("1. 스테이크덮밥");
					System.out.println("2. 연어덮밥");
					System.out.println("3. 막창덮밥");
					System.out.println("4. 포크슬라이스덮밥");
					System.out.println("==============================");
					System.out.println("b. 뒤로가기");
					System.out.println("q. 프로그램 종료");
					System.out.println("==============================");
					
					System.out.print("메뉴 번호 선택: ");
					select = scanner.next().charAt(0);
					
					if(select == 'b' || select == 'B') {
						loopFlag2 = false;
					} else if(select == 'q' || select == 'Q') {
						loopFlag2 = false;
						loopFlag1 = false;
					}else if (select == '1') {
						System.out.println("스테이크덮밥을 선택하였습니다.");
					}else if (select == '2') {
						System.out.println("연어덮밥을 선택하였습니다.");
					}else if (select == '3') {
						System.out.println("막창덮밥을 선택하였습니다.");
					}else if (select == '4') {
						System.out.println("포크슬라이스덮밥을 선택하였습니다.");						
					}else {
						System.out.println();
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						System.out.println("사용 할 수 없는 번호입니다.");
						System.out.println("다시 입력하세요.");
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					}
					
					System.out.println();
				}
			}else if(select == '4') {
				boolean loopFlag2 = true;
				
				while(loopFlag2) {
					System.out.println();
					System.out.println("========<< 밥앤밥 >>========");
					System.out.println("1. 소고기미역국");
					System.out.println("2. 뚝배기불고기");
					System.out.println("3. 얼큰순두부");
					System.out.println("4. 제육볶음");
					System.out.println("============================");
					System.out.println("b. 뒤로가기");
					System.out.println("q. 프로그램 종료");
					System.out.println("============================");
					
					System.out.print("메뉴 번호 선택: ");
					select = scanner.next().charAt(0);
					
					if(select == 'b' || select == 'B') {
						loopFlag2 = false;
					} else if(select == 'q' || select == 'Q') {
						loopFlag2 = false;
						loopFlag1 = false;
					}else if (select == '1') {
						System.out.println("소고기미역국을 선택하였습니다.");
					}else if (select == '2') {
						System.out.println("뚝배기불고기를 선택하였습니다.");
					}else if (select == '3') {
						System.out.println("얼큰순두부를 선택하였습니다.");
					}else if (select == '4') {
						System.out.println("제육볶음을 선택하였습니다.");						
					}else {
						System.out.println();
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						System.out.println("사용 할 수 없는 번호입니다.");
						System.out.println("다시 입력하세요.");
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					}
					
					System.out.println();
				}
			}else {
				System.out.println();
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("사용 할 수 없는 번호입니다.");
				System.out.println("다시 입력하세요.");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				
			}
			
			
			System.out.println();
		}
		
		System.out.println("프로그램 정상 종료!");
		
	}
	
}

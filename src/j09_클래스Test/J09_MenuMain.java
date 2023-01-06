package j09_클래스Test;

import java.util.Scanner;

public class J09_MenuMain {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		J09_Menu customer1 = new J09_Menu();
		
		boolean loopFlag1 = true;
		
		do {
			System.out.println("=====<< 메뉴 선택 >>=====");
			System.out.println("1. 짜장면");
			System.out.println("2. 짬뽕");
			System.out.println("3. 탕수육");
			System.out.println("4. 깐풍기");
			System.out.println("5. 군만두");
			System.out.println("6. 계산서 출력");
			System.out.println("=========================");
			System.out.println("q. 프로그램 종료");
			System.out.println("=========================");
				
			System.out.print("메뉴 선택: ");
			char select = '\0';
			select = scanner.next().charAt(0);			
			System.out.println();
			
			if(select == 'q' || select == 'Q') {
				loopFlag1 = false;
			}else if(select == '1') {
				// 수량 선택하기 넣기
				boolean loopFlag2 =true;
				customer1.menuName = "짜장면";
				while(loopFlag2) {
					System.out.print("수량 입력: ");
					customer1.order = scanner.nextInt();
					loopFlag2 = false;
				}
					
				customer1.price = customer1.order * 6000;
				customer1.printprince();
				
				customer1.totalPrice += customer1.price;
					
			}else if(select == '2') {
				boolean loopFlag2 = true;
				
				while(loopFlag2) {
					System.out.print("수량 입력: ");
					customer1.order = scanner.nextInt();
					loopFlag2 = false;
				}
				customer1.price = customer1.order * 7000;
				customer1.menuName = "짬뽕";
				customer1.printprince();
				customer1.totalPrice += customer1.price;
					
			}else if(select == '3') {
				boolean loopFlag2 = true;
					
				while(loopFlag2) {
						
					boolean loopFlag3 = true;
						
					while(loopFlag3) {
							
						System.out.println("1. 대");
						System.out.println("2. 중");
						System.out.println("3. 소");
						System.out.println();
						System.out.print("사이즈 입력: ");
						customer1.order = scanner.nextInt();
						
						if(select == 'q' || select == 'Q' ) {
							loopFlag3 = false;
						}else if(customer1.order == 1) {
							customer1.price = 24000;
							
						}else if(customer1.order == 2) {
							customer1.price = 20000;
						
						}else if(customer1.order == 3) {
							customer1.price = 16000;
					
						}else {
							System.out.println();
							System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
							System.out.println("사용 할 수 없는 번호입니다.");
							System.out.println("다시 입력하세요.");
							System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						}
						loopFlag2 = false;
						loopFlag3 = false;
					}
						
					customer1.menuName = "탕수육";
					customer1.printprince();
					customer1.totalPrice += customer1.price;
				}
			}else if(select == '4') {
				boolean loopFlag2 = true;
					
				while(loopFlag2) {
					boolean loopFlag3 = true;
					
					while(loopFlag3) {
							
						System.out.println("1. 대");
						System.out.println("2. 중");
						System.out.println("3. 소");
						System.out.println();
						System.out.print("사이즈 입력: ");
						customer1.order = scanner.nextInt();
						
						if(select == 'q' || select == 'Q' ) {
							loopFlag3 = false;
						}else if(customer1.order == 1) {
							customer1.price = 28000;
								
						}else if(customer1.order == 2) {
							customer1.price = 25000;
							
						}else if(customer1.order == 3) {
							customer1.price = 20000;
					
						}else {
							System.out.println();
							System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
							System.out.println("사용 할 수 없는 번호입니다.");
							System.out.println("다시 입력하세요.");
							System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						}

						loopFlag2 = false;
						loopFlag3 = false;
					
						customer1.menuName = "깐풍기";
						customer1.printprince();
						customer1.totalPrice += customer1.price;
					}
				}
			}else if(select == '5') {
				boolean loopFlag2 = true;
					
				while(loopFlag2) {
					boolean loopFlag3 = true;
					
					while(loopFlag3) {
							
						System.out.println("1. 대(12개)");
						System.out.println("2. 중(8개)");
						System.out.println("3. 소(4개)");
						System.out.println();
						System.out.print("사이즈 입력: ");
						customer1.order = scanner.nextInt();
						
						if(select == 'q' || select == 'Q' ) {
							loopFlag3 = false;
						}else if(customer1.order == 1) {
							customer1.price = 11000;
								
						}else if(customer1.order == 2) {
							customer1.price = 8000;
								
						}else if(customer1.order == 3) {
							customer1.price = 5000;
						
						}else {
							System.out.println();
							System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
							System.out.println("사용 할 수 없는 번호입니다.");
							System.out.println("다시 입력하세요.");
							System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						}
						loopFlag2 = false;
						loopFlag3 = false;
					}
					customer1.menuName = "군만두";
					customer1.printprince();
					customer1.totalPrice += customer1.price;
					
				}
				}else if(select == '6') {
					customer1.printTotal();
					loopFlag1 = false;
					
				}else {
					System.out.println();
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					System.out.println("사용 할 수 없는 번호입니다.");
					System.out.println("다시 입력하세요.");
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			}
				
		}while(loopFlag1);
		System.out.println("프로그램 종료");
		
	}
}

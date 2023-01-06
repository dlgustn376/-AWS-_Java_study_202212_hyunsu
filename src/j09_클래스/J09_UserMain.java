package j09_클래스;

import java.util.Scanner;

public class J09_UserMain {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		
		J09_User user1 = new J09_User();
		
		boolean loopFlag1 = true;
		
		boolean loopFlag2 = true;
		while(loopFlag1) {
			
			char select = '\0';
			System.out.println("========<< User Info 입력 >>========");
			System.out.println("1. 아이디");
			System.out.println("2. 비밀번호");
			System.out.println("3. 이름");
			System.out.println("4. 출력");
			System.out.println("===================================");
			System.out.println("q. 프로그램 종료");
			System.out.println("===================================");
			
			System.out.print("입력 선택: ");
			select = scanner.next().charAt(0);
			
			if(select == 'q' || select == 'Q') {
				loopFlag1 = false;
				
			}else if(select == '1') {
				System.out.print("아이디 입력: ");
				user1.username = scanner.next();
				user1.email = user1.username + "@gmail.com";
			}else if(select == '2') {
				System.out.print("비밀번호 입력: ");
				user1.password = scanner.next();
			}else if(select == '3') {
				System.out.print("이름 입력: ");
				user1.name = scanner.next();
			}else if(select == '4') {
				System.out.println("출력");
				user1.printUserInfo();
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

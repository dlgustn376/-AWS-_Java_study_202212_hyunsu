package j12_배열;

import java.util.Scanner;

public class J12_UserService {
	
	private Scanner scanner;
	
	// 생성자를 통해서 생성 될 때만 됨. 
	public J12_UserService() {
		scanner = new Scanner(System.in);
	}
	
// 결합도 낮음
//	public J12_UserService(Scanner scanner) {
//		this.scanner = new Scanner(System.in);
//	}
	// 비즈니스 로직 객체
	public void run() {
		boolean loopFlag = true;
		char select = '\0';
		
		while(loopFlag) {
			showMainMenu();
			select = inputSelect("메인");
			loopFlag = mainMenu(select);
		}
		
	}
	
	public void stop() {
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500); //0.5s씩 delay
				System.out.println("프로그램 종료중...(" + (i + 1) +"/10)");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료");
	}


	// inputSelect 메소드
	private char inputSelect(String menuName) {
		System.out.print(menuName + "메뉴 선택: ");
		char select = scanner.next().charAt(0);
		scanner.nextLine();
		return select;
	}
	
	// 나가는 메소드
	// 리펙토링 : 이전의 코드를 정리하는 것.
	private boolean isExit(char select) {
		return select == 'q' || select == 'Q';
	}
	
	// 선택에러메시지 출력 메소드
	private String getSelectedErrorMessage() {
		return "###<< 잘못된 입력입니다. 다시 입력하세요. >>###";
	}
	
	// 메인메뉴를 보여줌.
	private void showMainMenu() {
		System.out.println("========<< 메인메뉴 >>========");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 등록");
		System.out.println("3. 사용자이름으로 회원 조회");
		System.out.println("4. 회원 정보 수정");
		System.out.println("==============================");
		System.out.println("q. 프로그램 종료");
		System.out.println("==============================");
		System.out.println();
	}
	
	// mainMenu 기능 메소드
	private boolean mainMenu(char select) {
		boolean flag = true;
		
		if(isExit(select)) {
			flag = false;
		}else {
			if(select == '1') {
				
			}else if(select == '2') {
				
			}else if(select == '3') {
			
			}else if(select == '4') {
				
			}else {
				System.out.println(getSelectedErrorMessage());
			}
		}
		System.out.println();
		
		return flag;
	}
	
	
	
}

package j12_배열;

import java.util.Scanner;

public class J12_UserService {
	
	private Scanner scanner; 
	private J12_UserRepository userRepository;
	
	// UserRepository는 UserService에 의존하고 있다.
	public J12_UserService(J12_UserRepository userRepository) {
		scanner = new Scanner(System.in);
		this.userRepository = userRepository;
	}
	
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
				Thread.sleep(500);
				System.out.println("프로그램 종료중...(" + (i + 1) + "/10)");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료");
	}
	
	private char inputSelect(String menuName) {
		System.out.print(menuName + " 메뉴 선택: ");
		char select = scanner.next().charAt(0);
		scanner.nextLine();
		return select;
	}
	
	private void showMainMenu() {
		System.out.println("========<< 메인메뉴 >>========");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 등록");
		System.out.println("3. 사용자이름으로 회원 조회");
		System.out.println("4. 회원 정보 수정");
		System.out.println("==============================");
		System.out.println("q. 프로그램 종료");
		System.out.println();
	}
	
	
	
	private void showUsers() {
		
		J12_User[] users = userRepository.getUserTable();
		
		System.out.println("========<< 회원 전체 조회 >>========");
		
		
		for(J12_User user : users ) {
			System.out.println(user.toString());
		}
		
		System.out.println("====================================");
	}
	
	
	
	private void registerUser() {
		
		J12_User user = new J12_User();
		
		System.out.println("========<< 회원 등록 >>========");
		System.out.print("사용자이름: ");
		// setter 방식
		user.setUsername(scanner.nextLine());
		
		System.out.print("비밀번호: ");
		user.setPassword(scanner.nextLine());
		
		System.out.print("성명: ");
		user.setName(scanner.nextLine());
		
		System.out.print("이메일: ");
		user.setEmail(scanner.nextLine());
		
		userRepository.saveUser(user);
	}
	// 검색하는 메소드
	
	
	private boolean mainMenu(char select) {
		boolean flag = true;
		
		if(isExit(select)) {
			flag = false;
			
		}else {
			if(select == '1') {
				showUsers();
			}else if(select == '2') {
				registerUser();
			}else if(select == '3') {
				findUser();
			}else if(select == '4') {
	
				boolean loopFlag = true;
				char select1 = '\0';
				
				while(loopFlag) {
					
					String username = inputUsername();
					System.out.println();
					showUserData(username);
					select1 = inputSelect("수정");
					loopFlag = updateUser(select1);
					
					
				}
				
				
			}else {
				System.out.println(getSelectedErrorMessage());
			}
		}
		System.out.println();
		
		return flag;
	}
	
	private boolean isExit(char select) {
		return select == 'q' || select == 'Q';
	}
	
	private boolean isBack(char select) {
		return select == 'b' || select == 'B';
	}
	
	private String getSelectedErrorMessage() {
		return "###<< 잘못된 입력입니다. 다시 입력하세요. >>###";
	}
	
	private String getUsernameErrorMessage() {
		return "해당 사용자이름은 존재하지 않는 사용자이름입니다.";
	}
	
	private String getPasswardErrorMessage() {
		return "비밀번호가 일치하지 않습니다.";
	}
	
	private String getNewpasswardErrorMessage() {
		return "새로운 비밀번호가 서로 일치하지 않습니다.";
	}
	
	
	// 사용자이름(ID)를 입력하는 메소드
	private String inputUsername() {
		String username = null;
		System.out.println("수정 할 사용자이름을 입력하세요: ");
		username = scanner.nextLine();
		
		return username;
	}
	
	public void showUserData(String username) {
		System.out.println("========<< 수정메뉴 >>========");
		System.out.println("사용자 이름: " + username);
		System.out.println("==============================");
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 이름 변경");
		System.out.println("3. 이메일 변경");
		System.out.println("==============================");
		System.out.println("b. 뒤로가기");
		System.out.println("==============================");
		
	}
	
	private boolean updateUser(char select) {
		boolean flag = true;
		J12_User user = new J12_User();
		
//		J12_User user;
		String passward = null;
		
		if(isBack(select)) {
			flag = false;
		}else {
			if(select == '1') {
				
				
				
				
				System.out.print("기존의 비밀번호를 입력하세요: ");
				passward = scanner.nextLine();
				if(userRepository.equals(passward)) {
					System.out.print("새로운 비밀번호를 입력해주세요: ");
					user.setPassword(scanner.nextLine());
					System.out.print("새로운 비밀번호를 확인해주세요: ");
					passward = scanner.nextLine();
					if(user.equals(passward)) {
						System.out.println("비밀번호 변경 완료.");
					}else {
						System.out.println(getNewpasswardErrorMessage()); 
						flag = false;
					}
					
				}else {
					System.out.println(getPasswardErrorMessage());
					flag = true;
				}
				
				
				
				
				
				
				
			}else if(select == '2') {
				// 이름 변경
			}else if(select == '3') {
				// 이메일 변경
			}else {
				getUsernameErrorMessage();
			}
			
		}
		System.out.println();
		
		return flag;
	}

	
//	public String inputUsername(String username) {
//		username = null;
//		System.out.print(" 사용자이름 조회: ");
//		username = scanner.nextLine();
//		
//		return username;
//	}
//	
	
	
	
	private void findUser() {
		
		boolean loop = true;
		
		String username = null;

		while(loop) {
			System.out.print("사용자 이름: ");
			username = scanner.nextLine();
			if(userRepository.findUserByUsername(username) != null) {
				System.out.println("사용자 " + username + "의 정보");
				System.out.println(userRepository.findUserByUsername(username));
				loop = false;
			}else {
				System.out.println(getUsernameErrorMessage());
				break;
			}
			System.out.println();
		}
		
	}
	
}










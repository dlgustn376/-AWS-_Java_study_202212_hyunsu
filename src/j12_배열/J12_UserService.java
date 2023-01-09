package j12_배열;

import java.io.ObjectInputFilter.Config;
import java.util.Scanner;

public class J12_UserService {
	
	private Scanner scanner; 
	private J12_UserRepository userRepository;
	
	// UserRepository는 UserService에 의존하고 있다.
	public J12_UserService(J12_UserRepository userRepository) {
		scanner = new Scanner(System.in);
		this.userRepository = userRepository;
	}
	
	// 프로그램을 실행하는 메소드
	public void run() {
		boolean loopFlag = true;
		char select = '\0';
		
		while(loopFlag) {
			showMainMenu();
			select = inputSelect("메인");
			loopFlag = mainMenu(select);
		}
	}
	
	// 프로그램 종료를 보여주는 메소드
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
	
	// 회원 전체를 조회하는 메소드
	private void showUsers() {
		
		J12_User[] users = userRepository.getUserTable();
		
		System.out.println("========<< 회원 전체 조회 >>========");
		
		
		for(J12_User user : users ) {
			System.out.println(user.toString());
		}
		
		System.out.println("====================================");
	}
	
	// 회원을 등록하는 메소드
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
				showUser();
			}else if(select == '4') {
				updateUser();
			}else {
				System.out.println(getSelectedErrorMessage());
			}
		}
		System.out.println();
		
		return flag;
	}
	
	//----------------------------------------------------------------------------------------------------------------
	private boolean isExit(char select) {
		return select == 'q' || select == 'Q';
	}
	
	private boolean isBack(char select) {
		return select == 'b' || select == 'B';
	}
	//----------------------------------------------------------------------------------------------------------------
	
	private String getSelectedErrorMessage() {
		return "###<< 잘못된 입력입니다. 다시 입력하세요. >>###";
	}
	
	
	// 사용자이름(ID)를 회원 조회 메소드
	private J12_User verifyUsername() {
		String username = null;
		System.out.print("사용자이름: ");
		username = scanner.nextLine();
		return userRepository.findUserByUsername(username);
	}
	
	// 검색한 유저의 정보를 보여주는 메소드
	private void showUser() {
		
		J12_User user = null;
		
		System.out.println("========<< 회원 조회 >>========");
		user = verifyUsername();
		
		if(user == null) {
			System.out.println("존재하지 않는 사용자이름입니다.");
			return;
		}
		
		System.out.println(user.toString());
		System.out.println("===============================");
	}	

	// 사용자를 수정하는 메소드
	private void updateUser() {
		J12_User user = verifyUsername();
		if(user == null) {
			System.out.println("존재하지 않는 사용자이름입니다.");
			return;
		}
		
		boolean loopFlag = true;
		char select = '\0';
		
		while(loopFlag) {
			showUpdateMenu(user);
			select = inputSelect("수정");
			loopFlag = updateMenu(user, select);
		}
		
	}
	
	// 수정메뉴를 보여주는 메소드
	private void showUpdateMenu(J12_User user) {
		System.out.println("========<< 수정메뉴 >>========");
		System.out.println("사용자 이름: " + user.getUsername());
		System.out.println("==============================");
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 이름 변경");
		System.out.println("3. 이메일 변경");
		System.out.println("==============================");
		System.out.println("b. 뒤로가기");
		System.out.println("==============================");
		
	}
	
	// update menu 논리 메소드
	private boolean updateMenu(J12_User user, char select) {
		boolean flag = true;
		
		if(isBack(select)) {
			flag = false;
		}else {
			if(select == '1') {
				updatePassword(user);
			}else if(select == '2') {
				updateName(user);
			}else if(select == '3') {
				updateEmail(user);
			}else {
				System.out.println(getSelectedErrorMessage());
			}
		}
		
		return flag;
	}
	
	
	// 비밀번호를 변경하는 메소드
	private void updatePassword(J12_User user) {
		String oldPassword = null;
		String newPassword = null;
		String confirmPassword = null;
		
		
		System.out.println("========<< 비밀번호 입력 >>========");

		System.out.print("기존 비밀번호 입력: ");
		oldPassword = scanner.nextLine();
		
		if(!comparePassword(user.getPassword(), oldPassword)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		
		System.out.print("새로운 비밀번호 입력: ");
		newPassword = scanner.nextLine();
		System.out.print("새로운 비밀번호 확인: ");
		confirmPassword = scanner.nextLine();
		
		if(!comparePassword(newPassword, confirmPassword)) {
			System.out.println("새로운 비밀번호가 일치하지 않습니다.");
			return;
		}
		
		user.setPassword(newPassword);
		System.out.println("비밀번호 변경 완료.");
		
	}
	
	private boolean comparePassword(String prePassword, String nextPassword) {
		return prePassword.equals(nextPassword);
	}
		
	private void updateName(J12_User user) {
		String oldName = null;
		String newName = null;
		String confirmName = null;
		
		
		System.out.println("========<< 이름 입력 >>========");

		System.out.print("기존 이름 입력: ");
		oldName = scanner.nextLine();
		
		if(!compareName(user.getName(), oldName)) {
			System.out.println("이름이 일치하지 않습니다.");
			return;
		}
		
		System.out.print("새로운 이름 입력: ");
		newName = scanner.nextLine();
		System.out.print("새로운 비밀번호 확인: ");
		confirmName = scanner.nextLine();
		
		if(!compareName(newName, confirmName)) {
			System.out.println("새로운 이름이 일치하지 않습니다.");
			return;
		}
		
		user.setPassword(newName);
		System.out.println("이름 변경 완료.");
		
		
	}
	
	private boolean compareName(String preName, String nextName) {
		return preName.equals(nextName);
	}

	private void updateEmail(J12_User user) {
		String oldEmail = null;
		String newEmail = null;
		String confirmEmail = null;
		
		System.out.println("========<< 이메일 입력 >>========");
		
		System.out.print("이메일 입력: ");
		oldEmail = scanner.nextLine();
		
		if(!compareEmail(user.getEmail(), oldEmail)) {
			System.out.println("이메일이 일치하지 않습니다.");
			return;
		}
		
		System.out.print("새로운 이메일 입력: ");
		newEmail = scanner.nextLine();
		System.out.print("새로운 이메일 확인: ");
		confirmEmail = scanner.nextLine();
		
		if(!compareName(newEmail, confirmEmail)) {
			System.out.println("새로운 이메일이 일치하지 않습니다.");
			return;
		}
		
		user.setPassword(newEmail);
		System.out.println("이메일 변경 완료.");
		
		
	}
	private boolean compareEmail(String preEmail, String nextEmail) {
		return preEmail.equals(nextEmail);
	}
	
}








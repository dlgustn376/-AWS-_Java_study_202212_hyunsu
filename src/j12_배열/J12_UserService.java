package J12_배열;

import java.util.Scanner;

public class J12_UserService {

	private Scanner scanner;
	private J12_UserRepository userRepository;

	public J12_UserService(J12_UserRepository userRepository) {
		scanner = new Scanner(System.in);
		this.userRepository = userRepository;
	}

	public void run() {
		boolean loopFlag = true;
		char select = '\0';

		while (loopFlag) {
			showMainMenu();
			select = inputSelect("메인");
			loopFlag = mainMenu(select);
		}
	}

	public void stop() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
				System.out.println("프로그램 종료중...(" + (i + 1) + "/10)");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("프로그램 종료");
		}
	}

	private char inputSelect(String menuName) {
		System.out.println(menuName + "메뉴 선택 : ");
		char select = scanner.next().charAt(0);
		scanner.nextLine();
		return select;
	}

	private void showMainMenu() {

		System.out.println("=========<<메인메뉴>>=========");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 등록");
		System.out.println("3. 사용자이름으로 사용자 조회");
		System.out.println("4. 회원 정보 수정");
		System.out.println("==============================");
		System.out.println("q. 프로그램 종료");
		System.out.println();
	}

	private void showUsers() {
		J12_User[] users = userRepository.getUserTable();

		System.out.println("========<<회원 전체 조회>>========");

		for (J12_User user : users) {
			System.out.println(user.toString());
		}

		System.out.println("==============================");

	}

	private void registerUser() {
		J12_User user = new J12_User();

		System.out.println("========<<회원 등록>>========");
		System.out.print("사용자이름 : ");
		user.setUsername(scanner.nextLine());

		System.out.print("비밀번호 : ");
		user.setPassword(scanner.nextLine());

		System.out.print("성명 : ");
		user.setName(scanner.nextLine());

		System.out.print("이메일 :");
		user.setEmail(scanner.nextLine());

		userRepository.saveUser(user);

		System.out.println("===========================");
	}

//	private void searchUser() { // 3. 사용자 이름으로 회원 조회 기능
////		J12_User user = new J12_User // 굳이 객체를 생성할 필요는 없다.
//		J12_User user = null; // Username을 받을 공간은 필요하다
//		String username = null;
//		System.out.print("수정 할 사용자이름을 입력하세요 : ");
//		username = scanner.nextLine();
//
//		System.out.println(userRepository.findUserByUsername(username));
//
//		if (user == null) {
//			System.out.println("존재하지 않는 사용자 이름입니다.");
//			return;
//		}
//		System.out.println(user.toString());
////		System.out.println(user); 이렇게 해도 된다. 나중에 배울 예정
//
//	}

	private void showUser() {
		J12_User user = null;

		System.out.println("========<< 회원 조회>>========");
		user = verifyUsername();

		if (user == null) {
			System.out.println("존재하지 않는 사용자 이름입니다.");
			return;
		}

		System.out.println(user.toString());
		System.out.println("============================");
	}

	private void updateUser() { // 4. 회원 정보 수정 기능
		J12_User user = verifyUsername();
		if (user == null) {
			System.out.println("존재하지 않는 사용자 이름입니다.");
			return;
		}

		boolean loopFlag = true;
		char select = '\0';

		while (loopFlag) {
			showUpdateMenu(user);
			select = inputSelect("수정");
			loopFlag = updateMenu(user, select);
		}
	}

	private void showUpdateMenu(J12_User user) {
		System.out.println("==============<< 수정 메뉴 >>============");
		System.out.println("사용자이름 : " + user.getUsername());
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 이름 변경");
		System.out.println("3. 이메일 변경");
		System.out.println("==========================================");
		System.out.println("b. 비밀번호 변경");
		System.out.println();
	}

	private boolean mainMenu(char select) {
		boolean flag = true;

		if (isExit(select)) {
			flag = false;

		} else {
			if (select == '1') {
				showUsers();
			} else if (select == '2') {
				registerUser();
			} else if (select == '3') {
				verifyUsername();
			} else if (select == '4') {
				updateUser();
			} else {
				System.out.println(getSelectedErrorMessage());
			}

		}
		System.out.println();

		return flag;

	}

	private boolean updateMenu(J12_User user, char select) {
		boolean flag = true;
		
		if(isBack(select)) {
			flag = false;
			
		}else {
			if(select == '1') {
				updatePassword(user);
			}else if (select == '2') {
				
			}else if (select == '3') {
				
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
		return "###<<잘못된 입력입니다. 다시 입력하세요.>>###";
	}

	private J12_User verifyUsername() {
		String username = null;
		System.out.println("사용자 이름 : ");
		username = scanner.nextLine();
		return userRepository.findUserByUsername(username);
	}
	
	private void updatePassword(J12_User user) {
		String oldPassword = null;
		String newPassword = null;
		String confirmPassword = null;
		
		System.out.println("============<< 비밀번호 변경 >>===============");
		
		System.out.println("기존 비밀번호 입력 : ");
		oldPassword = scanner.nextLine();
		
		if(!comparePassword(user.getPassword(), oldPassword)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		System.out.println("새로운 비밀번호 입력 : ");
		newPassword = scanner.nextLine();
		System.out.println("새로운 비밀번호 확인");
		confirmPassword = scanner.nextLine();
		
		if(!comparePassword(newPassword, confirmPassword)) {
			System.out.println("새로운 비밀번호가 서로 일치하지 않습니다.");
			return;
		}
		
		user.setPassword(newPassword);
		System.out.println("");
	}
	
	private boolean comparePassword(String prePassword, String nextPassword) {
		return prePassword.equals(nextPassword);
	}
	
}
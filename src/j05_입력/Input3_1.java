package j05_입력;

import java.util.Scanner; // Ctrl + shift + O -> import 자동 

// 변수 5개를 받고 5개를 출력

public class Input3_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String name = null;
		int age = 0;
		String address = null;
		String phone = null;
				
		
		
		System.out.println("이름 : ");
		name = scanner.next(); // 띄어쓰기 인식
		
		System.out.println("나이 : ");
		age = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("주소 : ");
		address = scanner.nextLine(); 
		
		System.out.println("연락처 : ");
		phone = scanner.next();
		
		System.out.println("사용자의 이름은" + name + "이고 나이는 " + age + "살입니다.");
		System.out.println("주소는" + address + "에 거주중입니다.");
		System.out.println("연락처는" + phone + "입니다.");
		
	}

}

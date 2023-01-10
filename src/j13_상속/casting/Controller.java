package j13_상속.casting;

import java.util.Scanner;

public class Controller {
	
	private View view;
	private Scanner scanner;
	
	public Controller(View view) {
		this.view = view;
		scanner = new Scanner(System.in);
	}
	
	// view에 따라 다르게 동작
	public void run() {
		boolean flag = true;
		String select = null;
		
		while(flag) {
			view.show();
			System.out.print("명령 입력: ");
			select = scanner.nextLine();
			flag = view.menu(select);
			System.out.println();
		}
		
	}
}

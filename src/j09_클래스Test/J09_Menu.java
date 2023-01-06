package j09_클래스Test;

public class J09_Menu {
	String menuName = null;
	int price = 0;
	int order = 0;
	int totalPrice = 0;
	
	
	void printprince() {
		System.out.println();
		System.out.println("메뉴: " + menuName);
		System.out.println("수량: " + order);
		System.out.println("가격: " + price + "원");
	}

	void printTotal() {
		System.out.print("총 계산 금액: " + totalPrice + "원");
		System.out.println();
	}
}

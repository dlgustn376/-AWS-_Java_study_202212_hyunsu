

package j12_배열.di;

public class Main {
	
	public static void main(String[] args) {
		
		Test_C tc = new Test_C();
		Test_C tc2 = new Test_C();
		
		// 각각 생성을 해야 한다.
		Test_B tb = new Test_B(tc);
		
		// dependucing Injuction 
		Test_A ta = new Test_A(tb);
		
		// setter를 통한 객체 주입방식
		// 기존에서 다른 객체로 바꾸로 싶을 때.
//		ta.setTb(tb);
		
		ta.testA1();
		ta.testA2();
	}
	
}
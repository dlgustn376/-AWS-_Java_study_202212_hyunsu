package j12_배열;

public class Array1 {
	
	public static void printNames(String[]names) {
		for(int i = 0; i < names.length; i++) {
			System.out.println("이름[" + (i + 1) + "]: " + names[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		
		String[] names = new String[3];

//		들어갈 수 있는 값이 정해져있지 않을 때
//		공간이 100개인데 들어가야 할 값은 하나 인 경우  
		names[0] = "김상현";
		names[1] = "임나영";
		names[2] = "김종환";
		
		
		String[] names2 = new String[] {"이상현", "손지호", "이강용"};
		String[] names3 = {"김두영", "강대협", "이현수", "김재영"};
		
//		for(int i = 0; i < 3; i++ ) {
//			System.out.println("이름[" + (i + 1) + "]: " + names[i]);
//		} 
//				
//		for(int i = 0; i < 3; i++ ) {
//			System.out.println("이름[" + (i + 1) + "]: " + names2[i]);
//		}
//					
//		for(int i = 0; i < 3; i++ ) {
//			System.out.println("이름[" + (i + 1) + "]: " + names3[i]);
//			}
		printNames(names);
//		printNames(names2);
		printNames(new String[] {"이상현", "손지호", "이강용"});
		printNames(names3);
//		printNames({"김두영", "강대협", "이현수"}); -> 불가능하다
		
	}
}

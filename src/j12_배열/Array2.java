package j12_배열;

public class Array2 {
	
	public static void printNames(String[] names) {
		for(int i = 0; i < names.length; i++) {
			System.out.println("이름[" + (i + 1) + "]: " + names[i]);
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		String[] names = new String[3];
		
		names[0] = "홍길동";
		names[1] = "허준";
		names[2] = "임꺽정";
		
		String[] names2 = new String[] {"정약용", "송상현", "박연"};	// 배열 데이터
		String[] names3 = {"장영실", "이순신", "곽재우", "나대용"}; 	// 선언 일 때만, 허용. 

		printNames(names);
		printNames(new String[] {"정약용", "송상현", "박연"});
		printNames(names3);
		
		
		
	}
}

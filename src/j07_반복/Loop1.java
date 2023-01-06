package j07_반복;

public class Loop1 {
	
	public static void main(String[] args) {
		int total = 0;
		
		for (int i = 0; i < 100; i++) {  // 이곳을 건드리면 기준이 변함.
			total += (i + 1);
		}
		
		System.out.println("총합: " + total);
	}
}

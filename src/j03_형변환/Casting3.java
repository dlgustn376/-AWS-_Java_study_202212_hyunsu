package j03_형변환;

public class Casting3 {

	public static void main(String[] args) {
		double kor = 87.5;
		double eng = 95.7;
		double math = 80.5;
		
		/*
		int total = 0;
		int total2 = 0;
		double avg = 0;
		double avg2 = 0;
		 */
		
		
		int total = (int) kor + (int) eng + (int) math;
		double avg = total / 3.0;
		
		
		//total2 = (int)(kor + eng + math);
		//avg2 = (double) total2 / 3;
		
		System.out.println("합계 : " + total);
		System.out.println("평균 :" + avg);
		//System.out.println("----------------------------");
		//System.out.println("합계 : " + total2);
		//System.out.println("평균 :" + avg2);
		
		

	}

}

package j03_형변환;

public class Casting3 {

	public static void main(String[] args) {
		double kor = 87.5;
		double eng = 95.7;
		double math = 80.5;
		
		/*
			(int) (kor + eng + math); 먼저 연산을 한 뒤 형 변환을 함.
			avg = (double) total/3; 
			total/3에서는 둘 다 정수형으로 정수를 형변환 한다. 그래서 (double)로 형 변환 후 나누기 3 연산을 한다.  
			자료형이 다르면 연산을 할 수 없다. 여기선 3이 묵시적 형변환.
		 */
				
		int total = (int) kor + (int) eng + (int) math;
		double avg = total / 3.0;
		
		System.out.println("합계: " + total);
		System.out.println("평균: " + avg);
		
	}

}

package j05_입력;

import java.util.Scanner;

public class N_Input1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double inputKor = 0;
		double inputEng = 0;
		double inputMath = 0;
		int total = 0;
		double avg =0.0;
		char grade = 0;
		char Plus = 0;
		
		System.out.print("국어점수: ");
		inputKor = scanner.nextDouble();
		System.out.print("영어점수: ");
		inputEng = scanner.nextDouble();
		System.out.print("수학점수: ");
		inputMath = scanner.nextDouble();
		
		total = (int) inputKor + (int) inputEng + (int) inputMath;
		avg = total / 3.0;
		
		grade = avg > 100 || avg < 0 ? 'X' 
				: avg > 90 ? 'A' 
				: avg > 80 ? 'B' 
				: avg > 70 ? 'C' 
				: avg > 60 ? 'D' : 'F';
				
		Plus =  avg > 100 || avg < 60 ? '\0' 
				: avg % 10 > 4 || avg == 100 ? '+' : '\0';
		
		System.out.println("합계: " + total);
		System.out.println("평균: " + avg);
		System.out.println("학점: " + grade + Plus); 
		
		
		
	}
}

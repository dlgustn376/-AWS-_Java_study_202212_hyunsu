package j06_조건;

import java.util.Scanner;

public class Conditional3 {

	public static void main(String[] args) {
		/*
		 * 조건
		 * score가 0점보다 작거나 100점보다 크면 X를 출력
		 * score가 95~100점이면 A+학점
		 * score가 90~94점이면 A학점
		 * score가 85~89점이면 B+학점
		 * score가 80~84점이면 B학점
		 * score가 75~79점이면 C+학점
		 * score가 70~74점이면 C학점
		 * score가 65~69점이면 D+학점
		 * score가 60~64점이면 D학점
		 * score가 0~59점이면 F학점
		 */
		Scanner scanner = new Scanner(System.in);
		
		int score = 0;
		String grade = null; // 두 개의 문자열이 들어갈 수 있다.
		
		System.out.println("점수 입력: ");
		score = scanner.nextInt();
		
		if (score > 100 || score < 0) {
			grade = null;
		}else if (score > 89) {
			grade = "A";
		}else if (score > 79) {
			grade = "B";
		}else if (score > 69) {
			grade = "C";
		}else if (score > 59) {
			grade = "D";
		}else {
			grade ="F";
		}
		
		if ((score > 59 && score < 101) && (score % 10 > 4 || score == 100)) {
			grade += "+";
		}
		
		if(grade == null) {
			System.out.println("계산불가");
		}else {
			System.out.println("점수(" + score + ") : " + grade + "학점");	
		}		
	}
}

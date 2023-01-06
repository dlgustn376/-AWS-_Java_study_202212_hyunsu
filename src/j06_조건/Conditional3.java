package j06_조건;

import java.util.Scanner;

/*
 * 시험 성적을 학정으로 계산하는 프로그램
 * 
 * 정수자료형 score변수 선언
 * 88점으로 초기화
 * 
 * 문자자료형 grade 변수 선언
 * 
 * 조건
 * score가 0점보다 작거나 100점보다 계산불가
 * score가 90~100점이면 A학점
 * s8ore가 80~89점이면 B학점
 * score가 70~79점이면 C학점
 * score가 60~69점이면 D학점
 * score가 0~59점이면 F학점
 * 
 */


public class Conditional3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int score = 0;
		String grade = null;
		
		System.out.print("성적 점수 입력: ");
		
		score = scanner.nextInt();
		
		// grade에 입력을 하려는 부분
		if(score > 100 || score < 0) {
			grade = null; 
		} else if(score > 89) {
			grade = "A";
		} else if(score > 79) {
			grade = "B";
		} else if(score > 69) {
			grade = "C";
		} else if(score > 59) {
			grade = "D";
		} else {
			grade = "F";
		}
		
		// + 를 붙여 줄 것인지 판단하는 부분
		if((score > 59 && score < 101) && (score % 10 > 4 || score == 100)) {
			grade += "+";
		}
		
		// 출력을 하는 부분
		if(grade == null) {
			System.out.println("계산불가");
		}else {
			System.out.println("점수(" + score + "): " + grade + " 학점"); 	
		}
	}
}
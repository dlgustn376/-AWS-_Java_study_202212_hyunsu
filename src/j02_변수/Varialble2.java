package j02_변수;

public class Varialble2 {

	public static void main(String[] args) {
		char firstName1 = '가';
		char firstName2 = '수';		
		
		char alphabetA = 'A';
		
		System.out.println("김"+ firstName1+firstName2);
		System.out.println("알파벳A: " + alphabetA);
		
		System.out.println(alphabetA + 'B');
		System.out.println(alphabetA);
		System.out.println("\uAC00"); // 유니코드 표기법
		System.out.println(firstName1 + 0);
	}

}

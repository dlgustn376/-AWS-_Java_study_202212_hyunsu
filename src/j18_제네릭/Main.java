package j18_제네릭;

public class Main {
	
	public static void main(String[] args) {
		TestData<String, Integer> td = new TestData<String, Integer>("이현수", 25);
//		자료형을 바꿀때 제네릭을 사용
//		생성될 때 결정
//		객체는 항상 생성 될때 결정된다.
		TestData<String, Double> td2 = new TestData<String, Double>("hyunsu", 100.05);
		System.out.println(td);
		System.out.println(td2);
				
	}
	
}

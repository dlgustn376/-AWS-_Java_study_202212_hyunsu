package J18_제네릭;

public class Main {
	public static void main(String[] args) {
		TestData<Integer> td = new TestData<Integer>("김준일", 30);
		TestData<Double> td2 = new TestData<Double>("junil", 100.12 ); // 자료형을 바꿀 때 제네릭을 사용한다.
		System.out.println(td);
		System.out.println(td2);
	}
}

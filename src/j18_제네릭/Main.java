package j18_제네릭;

//자료형을 바꿀때 제네릭을 사용
//생성될 때 결정
//객체는 항상 생성 될때 결정된다.
public class Main {
	
	public static void main(String[] args) {
//		TestData<String, Integer> 자체로 자료형이다.
//		TestData<?, ?> 무슨 타입이 들어 올지 모르기에 자료형에서는 선어해 주어야 함.
//		new TestData<String, Integer>("이현수", 25); 뒤에 자료형을 알수 있기에 가능.
//		단, 컴퓨터가 한번 더 판단을 하기에 성능상으로 좋지는 않다.
// 
		TestData<String, Integer> td = new TestData<String, Integer>("이현수", 25);
		TestData<String, Double> td2 = new TestData<String, Double>("hyunsu", 100.05);
		System.out.println(td);
		System.out.println(td2);
		
		CMRespDto<TestData<String, Integer>> cm = 
				new CMRespDto<TestData<String, Integer>>(200, "성공", td);
//		CMRespDto<?> cm = 
//				new CMRespDto<?>(200, "성공", td);
//		CMRespDto<TestData<?, ?>> cm = 
//				new CMRespDto<TestData<?, ?>>(200, "성공", td);
		
		System.out.println(cm);
	}
	
}

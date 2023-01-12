package j17_스태틱.싱글톤;


// 모든 싱글톤은 이런 형식으로 만듬.

public class KIA {
// 한번 생성이 되었으면 다른 곳에서 만들어지지 않는다.	
	private static KIA instance =  null;
	
	private KIA() {}
	
	public static KIA getInstance() {
		if(instance == null) {
			instance = new KIA();
		}
		return instance;
	}
	
	public void printCompanyName() {
		System.out.println(getClass().getSimpleName());
	}
	
	

}

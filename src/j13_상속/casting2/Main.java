package j13_상속.casting2;

public class Main {
	
	public static void main(String[] args) {
		Taxi taxi = new Taxi();
		Subway subway = new Subway();
		
//		Transportation transportation = new Transportation();	// transpotation 형태 하나만 만들어짐. 
//		Taxi t1 = (Taxi) transportation;						// 다운캐스팅 안 됨. 
//		
//		
//		Transportation transportation1 = taxi; 					// 업캐스팅
//		Subway s1 = (Subway) transportation1;					// 다운캐스팅 안됨. taxi와 subway는 다름.
																// 본래의 형태로 돌아갈 때만 허용.
		
//		Transportation transportation2 = subway; 
		
		Transportation[] transportations = new Transportation[6];
		
		transportations[0] = taxi;
		transportations[1] = subway;
		transportations[2] = taxi;
		transportations[3] = subway;
		transportations[4] = taxi;
		transportations[5] = subway;
		
		for(int i = 0; i < transportations.length; i++) {
			// Taxi 객체로 생성된 것이 맞는지 확인
			if(transportations[i] instanceof Taxi) {
				Taxi tx = (Taxi) transportations[i];
				tx.checkTaxiNumber();
				
			// Subway 객체로 생성된 것이 맞는지 확인
			}else if(transportations[i] instanceof Subway) {
				Subway sw = (Subway) transportations[i];
				sw.checkRoute();
				
			}
			
			transportations[i].go();
		}
		
		for(Transportation t : transportations) {
			t.stop();
		}
		
	}
}

package j14_추상;


public class Main {
	
	public static void main(String[] args) {	
		Transportation[] transportations = new Transportation[3];
		
		transportations[0] = new Airplane();
		transportations[1] = new Subway();
		transportations[2] = new Taxi();
		
		System.out.println("이동수단 확인");
		for(Transportation tp : transportations) {
			tp.go();
		}
		System.out.println();
		
		for(Transportation tp : transportations) {
			tp.stop();
		}
		System.out.println();
		
		
		
	}
}

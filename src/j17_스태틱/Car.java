package j17_스태틱;

import java.time.LocalDateTime;

public class Car {
	
	private static final int NOW_YEAR = LocalDateTime.now().getYear();
	
	private static final String CODE = "KIA-" + NOW_YEAR + "-";
	private static int ai = 1;		//auto increment
	
	private String serialCode;
	private String modelName;
	
//	% : 명령시작
//	0 : 0을 채운다.
//	4 : 4자리 수
//	d : 10진수 정수
	
	public Car(String modelName) {
		serialCode = CODE + String.format("%04d", ai);
		ai++;
		this.modelName = modelName;
	}
	
	@Override
	public String toString() {
		return "Car [serialCode=" + serialCode + ", modelName=" + modelName + "]";
	}
	
}

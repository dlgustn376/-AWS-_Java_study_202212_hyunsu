package j17_스태틱;

import java.time.LocalDateTime;

public class Car {
	
//	private final NOW_YEAR = new Date().getYear();
	private static final int NOW_YEAR = LocalDateTime.now().getYear();

//	private static int CODE = "KIA-2023-"; // KIA-2023-0000
	private static String CODE = "KIA-" + NOW_YEAR + "-"; // KIA-2023-0000
	private static int ai = 1;

	private String serialCode; // KIA-2023-0000
	private String modelName;

	public Car(String modelName) {
		serialCode = CODE + String.format("%04d", ai); // %04d -> 네 자리 숫자
		ai++;
		this.modelName = modelName;
		
	}

	@Override
	public String toString() {
		return "Car [serialCode=" + serialCode + ", modelName=" + modelName + "]";
	}
	
	
}

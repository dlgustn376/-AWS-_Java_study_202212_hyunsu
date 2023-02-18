package J17_스태틱.싱글톤;

public class KIA {
	private static KIA instance = null;

	private KIA() {
	}

	public static KIA getInstance() {
		if (instance == null) {
			instance = new KIA();
		}
		return instance;

	}

	public void printCompanyName() {
		System.out.println(getClass().getSimpleName());
	}
}

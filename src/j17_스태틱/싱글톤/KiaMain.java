package j17_스태틱.싱글톤;

public class KiaMain {
	public static void main(String[] args) {
		KIA kia = KIA.getInstance(); // static
//		Kia kia2 = new KIA();

		kia.printCompanyName();

	}
}

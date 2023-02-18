package J18_제네릭;

public class TestData<T> { // <T> -> 제네릭
	private String data1;
	private T data2; //Wrapper Class(래퍼 클래스)

	public TestData(String data1, T data2) {
		this.data1 = data1;
		this.data2 = data2;
	}

	@Override
	public String toString() {
		return "TestData [data1=" + data1 + ", data2=" + data2 + "]";
	}

}

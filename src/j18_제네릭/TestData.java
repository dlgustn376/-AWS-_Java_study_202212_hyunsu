package j18_제네릭;

public class TestData<T , E> {
//	<T> : 제네릭,Type을 줄인 말.
//	int는 일반 자료형 -> Integer
//	Wrapper Class(래퍼 클래스)
	private T data1;
	private E data2;	
	
	public TestData(T data1, E data2) {
		this.data1 = data1;
		this.data2 = data2;
	}

	@Override
	public String toString() {
		return "TestData [data1=" + data1 + ", data2=" + data2 + "]";
	}
	
	
}

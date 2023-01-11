package j16_Object;


// 여기서만 존재하는 클래스
// 패키지 않에서만 참조해서 쓸수 있다.
// 임시로 만든 것. 
class Test {
	private int num;
	
	public Test(int num) {
		super();
		this.num = num;
		System.out.println(num + "생성");
	}
	
//	가비지 컬렉터가 메모리를 보고 필요없는 것을 버려줌.
//	가비지 컬렉터로 소멸이 되어 졌을 때 실행.
//	소멸되면 안되는 경우 메모리에 할당되있던 데이터를 복사해서 살아있도록 한다.
	@Override
	protected void finalize() throws Throwable {
		System.out.println(num + "객체 소멸");
	}
	
	
}


// 외부에서 참조할 수있게끔 접근지정해줌.
// class명이랑 파일명이랑 같아야 함.
public class ObjectFinalize {
	
	public static void main(String[] args) {
		Test test = null;
	
		for(int i = 0; i< 10; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			test = new Test(i);
			
			test = null;
			
//			가비지 컬렉터 실행. 강제 호출
//			JVM이 여유가 있을 때 실행됨.
//			무엇을 소멸시킬지 모르기 때문에
//			주의하면서 사용해야 함.
			System.gc();
		}
	}
	
}

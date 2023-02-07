package j26_스레드;

public class TreadTest {
	
	public static void main(String[] args) {
		LoopThread loopThread1 = new LoopThread("김상현");
		LoopThread loopThread2 = new LoopThread("강대협");
		LoopThread loopThread3 = new LoopThread("손지호");
		LoopThread loopThread4 = new LoopThread("김재영");
		
//		우선순위가 동일한 상태
//		숫자가 높으면 우선순위가 높다.
//		Thread.MAX_PRIORITY = 10
//		Thread.MIN_PRIORITY = 1
//		우선순위의 설정을 잘못하면 교착상태가 발생할 수 있다.
//		Thread는 Runnable 인터페이스를 가지고 있다.
//		run() 메소드를 가지고 있다. 단순실행
		
		loopThread4.setPriority(8);
		System.out.println(loopThread1.getPriority());
		System.out.println(loopThread2.getPriority());
		System.out.println(loopThread3.getPriority());
		System.out.println(loopThread4.getPriority());
//		System.out.println("김상현 스레드의 우선순위: " + loopThread1.getPriority());
//		System.out.println("강대협 스레드의 우선순위: " + loopThread2.getPriority());
//		System.out.println("손지호 스레드의 우선순위: " + loopThread3.getPriority());
//		System.out.println("김재영 스레드의 우선순위: " + loopThread4.getPriority());

//		start()가 호출되면 run()이 실행된다.
		loopThread1.start();
		loopThread2.start();
		loopThread3.start();
		loopThread4.start();

	}
}



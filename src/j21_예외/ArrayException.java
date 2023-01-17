package j21_예외;

public class ArrayException {
	
	public static void main(String[] args) {
		Integer[] nums = {1, 2, 3, 4, 5};
		
		try {	// 예외가 일어날 수도 있는 부분

//			throw는 강제로 예외를 발생시킴
//			throw new NullPointerException();
			
			for(int i = 0; i < 5; i++) {
				System.out.println(nums[i]);
			}
		}catch (IndexOutOfBoundsException e) {
			System.out.println("예외 처리함");
		}catch (NullPointerException e) {
			System.out.println("빈값 처리함");
		}catch (Exception e) {
			System.out.println("예상 못한 예외 처리함");
		}
//		요구 사항, 유지보수의 예외 처리, SM(management), SI(새로 개발, 일용직 노동자 같은...)
//		IndexOutOfBoundsException 인덱스 값 초과
		
		
		System.out.println("프로그램 정상 종료");
	}

}

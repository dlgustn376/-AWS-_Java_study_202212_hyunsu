package j21_예외처리;

import java.util.Arrays;
import java.util.List;

public class ThrowsException {

	public static void printList(List<String> list, int size) throws Exception { // throws -> 예외처리를 반드시 해야 한다. 예외를 미룬다.
		for (int i = 0; i < size; i++) {
			System.out.println("[" + i + "]" + list.get(i));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String[] names = { "김수현", "이종현", "박성진", "김동민" };

		try {
			printList(Arrays.asList(names), 5);

		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 예외가 생기던 안 생기던 무조건 실행이 된다. 임시저장기능
			System.out.println("무조건 실행");
		}
		System.out.println("프로그램 정상 종료");

	}

}

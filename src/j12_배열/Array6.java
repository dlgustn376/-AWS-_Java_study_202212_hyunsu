package j12_배열;

public class Array6 {

	public static void main(String[] args) {

		String[] names = { "박성진", "조병철", "황창욱" };

		for (String name : names) { // 하나를 꺼내고 하나를 출력한다. 꺼내고 나면 없어진다. 객체가 돼도 된다.
			System.out.println(name);
			name = "김준일";
		}

		System.out.println("==============<forEach>=================");

		for (int i = 0; i < names.length; i++) { // 기본 배열 출력
			System.out.println(names[i]);
		}
		
		int[] nums = {1,2,3,4,5};
		
		for(int i : nums) {
			System.out.println("i : " + i);
		}
	}
}

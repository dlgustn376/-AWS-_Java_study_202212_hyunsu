package j12_배열;

public class Array5 {

//	값을 집어 넣으려면 공간을 늘려야 한다.
//	공간을 늘리기

	public static void transferArray(int[] oldArray, int[] newArray) { // 메소드 명만 보고도 이런 동작을 하겠구나 라는 생각이 들게 해야 한다. -> 클린코드
				for (int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
	}

	public static int[] addArrayLength(int[] array) {
		int[] newArray = new int[array.length + 1];
		transferArray(array, newArray);
		return newArray;
	}

	public static int[] addData(int[] array, int data) {
		int[] newArray = addArrayLength(array);
		newArray[array.length] = data;
		return newArray;
	}

	public static void main(String[] args) {

		int[] nums = new int[0];

//		nums = addArrayLength(nums);

		nums = addData(nums, 1);
		nums = addData(nums, 2);
		nums = addData(nums, 3);
		nums = addData(nums, 4);
		nums = addData(nums, 5);

		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}

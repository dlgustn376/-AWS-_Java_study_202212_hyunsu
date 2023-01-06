package j12_배열;

public class Array5 {
	// 이전 배열 데이터를 새로운 배열에 옮겨주는 메소드
	private static void trasnferArray(int[] oldArray, int[] newArray) {
		for(int i = 0; i< oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
	}
	// 배열의 주소값이 같기 때문에 return을 할 필요가 없다.

	// 배열의 길이를 늘려주는 메소드
	private static int[] addArrayLength(int[] array) {
		int[] newArray = new int[array.length + 1]; 
		trasnferArray(array, newArray);
		return newArray;
		
	}
	// 데이터를 추가하는 메소드
	public static int[] addData(int[] array, int data) {
		int[] newArray = addArrayLength(array);
		newArray[array.length] = data;
		return newArray;
	}

	public static void main(String[] args) {
		
		int[] nums = new int[0];
		
		nums = addData(nums, 1);
		nums = addData(nums, 2);
		nums = addData(nums, 3);
		nums = addData(nums, 4);
		nums = addData(nums, 5);
		
		for(int i = 0; i< nums.length; i++) {
			System.out.println(nums[i]);
		}
		
	}

}
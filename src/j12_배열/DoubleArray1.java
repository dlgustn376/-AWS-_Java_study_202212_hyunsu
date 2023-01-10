package j12_배열;

public class DoubleArray1 {
	
	public static void main(String[] args) {
		
		int num = 0;
		
		int [] nums = new int[2];
		
		// int 배열의 배열 [][하위] 
		// 2개짜리 배열이 3개로 묶인 것.
		int[][] d_nums = new int[3][2];
		
		d_nums[0][0] = 1;
		d_nums[0][1] = 2;
		
		d_nums[1][0] = 3;
		d_nums[1][1] = 4;
		
		d_nums[2][0] = 5;
		d_nums[2][1] = 6;
		
		
		
		
		for(int i = 0; i < 2;i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(d_nums[j][i]);
			}
			System.out.println();
		}
		
		System.out.println();
		
		int[][] d_nums2 = new int[][] {{1,2,3},{5,6}};
		
//		for(int i = 0; i < 2;i++) {
//			for(int j = 0; j < 3; j++) {
//				System.out.print(d_nums2[i][j]);
//			}
//			System.out.println();
//		}
	
		System.out.println();
		
		System.out.println(d_nums2.length); 	// 바깥쪽 length의 길이
		System.out.println(d_nums2[1].length); 	// 안쪽 length의 길이
		
		System.out.println();
		
		for(int i = 0; i < d_nums2.length; i++) {
			for(int j = 0; j < d_nums2[i].length; j++) {
				System.out.print(d_nums2[i][j]);
			}
			System.out.println();
		}
		
		
	}
}

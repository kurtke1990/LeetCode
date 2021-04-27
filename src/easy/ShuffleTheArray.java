package easy;

import java.util.Arrays;

/*
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * 
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 * 
 * Example 1:
 * 		Input: nums = [2,5,1,3,4,7], n = 3
 * 		Output: [2,3,5,4,1,7]
 * 		Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
 * 
 * Example 2:
 * 		Input: nums = [1,2,3,4,4,3,2,1], n = 4
 * 		Output: [1,4,2,3,3,2,4,1]
 * 
 * Example 3:
 * 		Input: nums = [1,1,2,2], n = 2
 * 		Output: [1,2,1,2]
 * 
 * Constraints:
 * 		1 <= n <= 500
 * 		nums.length == 2n
 *		1 <= nums[i] <= 10^3
 */
public class ShuffleTheArray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(shuffle(new int[] { 2, 5, 1, 3, 4, 7 }, 3)));
		System.out.println(Arrays.toString(shuffle(new int[] { 1, 2, 3, 4, 4, 3, 2, 1 }, 4)));
		System.out.println(Arrays.toString(shuffle(new int[] { 1, 1, 2, 2 }, 2)));
		System.out.println(Arrays.toString(shuffle2(new int[] { 2, 5, 1, 3, 4, 7 }, 3)));
		System.out.println(Arrays.toString(shuffle2(new int[] { 1, 2, 3, 4, 4, 3, 2, 1 }, 4)));
		System.out.println(Arrays.toString(shuffle2(new int[] { 1, 1, 2, 2 }, 2)));
	}

	public static int[] shuffle(int[] nums, int n) {
		int[] shuffledNums = new int[2 * n];
		for (int numIndex = 0, shuffledIndex = 0; numIndex < n; numIndex++) {
			shuffledNums[shuffledIndex++] = nums[numIndex];
			shuffledNums[shuffledIndex++] = nums[numIndex + n];
		}
		return shuffledNums;
	}

	public static int[] shuffle2(int[] nums, int n) {

		for (int j = nums.length - 1, i = n - 1; j >= n; j--, i--) {
			// 因為題目限制 array 中最大值為 1000
			// 又因為 1000 的 2 進位為 1111101000
			// 因此可以將目前 y 值左移 10 位
			nums[j] <<= 10;

			// 將 x 值透過 OR 一起存放
			nums[j] |= nums[i];
		}

		for (int j = n, i = 0; j < nums.length; j++) {
			// x 值是存放 10 位, 所以透過 AND 將值取出
			int xValue = nums[j] & 1023;

			// 右移回 10 位
			int yValue = nums[j] >> 10;

			// 第 j 個位置放 x 值
			nums[i++] = xValue;

			// 第 j + 1 個位置放 y 值
			nums[i++] = yValue;
		}

		return nums;
	}
}

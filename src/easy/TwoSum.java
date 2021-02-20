package easy;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * Example 1: 
 * 		Input: nums = [2,7,11,15], target = 9
 * 		Output: [0,1]
 *
 * Example 2: 
 * 		Input: nums = [3,2,4], target = 6
 * 		Output: [1,2]
 * 
 * Example 3: 
 * 		Input: nums = [3,3], target = 6
 * 		Output: [0,1]
 * 
 * Constraints:
 * 		2 <= nums.length <= 10^3
 * 		-10^9 <= nums[i] <= 10^9
 * 		-10^9 <= target <= 10^9
 * 		Only one valid answer exists.
 */
public class TwoSum {
	public static void main(String[] args) {
		int[] nums = new int[] { 2, 7, 11, 15 };
		int target = 9;
		int[] result1 = solution(nums, target);
		for (int element : result1) {
			System.out.println(element);
		}
	}

	private static int[] solution(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int remainder = target - nums[i];
			// 如果在 map 中找到餘數，則回傳結果
			// 反之，沒有找到餘數，則將目前在 nums 的值與 index 存放到 map 中
			if (map.containsKey(remainder)) {
				return new int[] { map.get(remainder), i };
			}
			map.put(nums[i], i);
		}
		return new int[] {};
	}
}

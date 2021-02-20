package easy;

/*
 * 
 * Given a signed 32-bit integer x, return x with its digits reversed. If
 * reversing x causes the value to go outside the signed 32-bit integer range
 * [-2^31, 2^31 - 1], then return 0.
 * 
 * Assume the environment does not allow you to store 64-bit integers (signed or
 * unsigned).
 * 
 * Example 1: 
 * 		Input: x = 123
 * 		Output: 321
 * 
 * Example 2: 
 * 		Input: x = -123
 * 		Output: -321
 * 
 * Example 3: 
 * 		Input: x = 120
 * 		Output: 21
 * 
 * Example 4: 
 * 		Input: x = 0
 * 		Output: 0
 * 
 * Constraints: -2^31 <= x <= 2^31 - 1
 * 
 */
public class ReverseInteger {
	public static void main(String[] args) {
		System.out.println(solution(123));
	}

	public static int solution(int x) {
		long result = 0;

		while (x != 0) {
			// 因為每次只放入餘數，所以原本 result 的值都要乘 10
			result = result * 10 + x % 10;

			// 超過最大值與最小值範圍，則回傳 0
			if (result <= -2147483648 || result >= 2147483647) {
				return 0;
			}

			// 計算完之後，取商
			x /= 10;
		}

		return (int) result;
	}
}

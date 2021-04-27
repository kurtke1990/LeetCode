package easy;

/*
 * 
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 		Input: strs = ["flower","flow","flight"]
 * 		Output: "fl"
 *
 * Example 2:
 * 		Input: strs = ["dog","racecar","car"]
 * 		Output: ""
 * 		Explanation: There is no common prefix among the input strings.
 * 
 * Constraints:
 * 		0 <= strs.length <= 200
 * 		0 <= strs[i].length <= 200
 * 		strs[i] consists of only lower-case English letters.
 * 
 */
public class LongestCommonPrefix {
	public static void main(String[] args) {
		String commonPrefix = longestCommonPrefix(new String[] { "ab", "a" });
		System.out.println(commonPrefix);
		String commonPrefix2 = longestCommonPrefix(new String[] { "flower", "flow", "flight" });
		System.out.println(commonPrefix2);
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		// 先取第一個字為 commonPrefix
		String commonPrefix = strs[0];
		for (int i = 0; i < commonPrefix.length(); i++) {
			// 取得待比對的字串
			for (int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != commonPrefix.charAt(i)) {
					return commonPrefix.substring(0, i);
				}
			}
		}
		return commonPrefix;
	}

}

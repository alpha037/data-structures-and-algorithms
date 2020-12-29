package LeetCode.Medium.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

/*
  3. Longest Substring Without Repeating Characters

  Given a string s, find the length of the longest substring without repeating characters.


  Example 1:
  Input: s = "abcabcbb"
  Output: 3
  Explanation: The answer is "abc", with the length of 3.

  Example 2:
  Input: s = "bbbbb"
  Output: 1
  Explanation: The answer is "b", with the length of 1.

  Example 3:
  Input: s = "pwwkew"
  Output: 3
  Explanation: The answer is "wke", with the length of 3.
  Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

  Example 4:
  Input: s = ""
  Output: 0


  Constraints:
  0 <= s.length <= 5 * 104
  s consists of English letters, digits, symbols and spaces.
*/

public class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s.length() <= 1) return s.length();

    int maxLength = 0, i = 0, j = 0;
    HashMap<Character, Boolean> visited = new HashMap<>();

    while (j < s.length())
      if (!visited.containsKey(s.charAt(j)) || !visited.get(s.charAt(j))) {
        visited.put(s.charAt(j++), true);
        maxLength = Math.max(maxLength, visited.keySet().size());
      } else visited.remove(s.charAt(i++));

    return maxLength;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 3
    System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));

    // should be 1
    System.out.println(solution.lengthOfLongestSubstring("bbbbb"));

    // should be 3
    System.out.println(solution.lengthOfLongestSubstring("pwwkew"));

    // should be 0
    System.out.println(solution.lengthOfLongestSubstring(""));

    // should be 3
    System.out.println(solution.lengthOfLongestSubstring("dvdf"));
  }
}

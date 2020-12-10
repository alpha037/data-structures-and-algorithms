package LeetCode.Easy.LongestCommonPrefix;

/*
 14. Longest Common Prefix

 Write a function to find the longest common prefix string amongst an array of strings.

 If there is no common prefix, return an empty string "".


 Example 1:
 Input: strs = ["flower","flow","flight"]
 Output: "fl"

 Example 2:
 Input: strs = ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.


 Constraints:
 0 <= strs.length <= 200
 0 <= strs[i].length <= 200
 strs[i] consists of only lower-case English letters.
*/

public class Solution {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";

    if (strs.length == 1) return strs[0];

    int minLength = strs[0].length();
    for (int i = 1; i < strs.length; i++) minLength = Math.min(minLength, strs[i].length());

    String prefix = "";
    char match;

    for (int i = 0; i < minLength; i++) {
      match = strs[0].charAt(i);

      for (int j = 1; j < strs.length; j++) if (strs[j].charAt(i) != match) return prefix;

      prefix += match;
    }

    return prefix;

    // Another method for faster running time

    // String prefix = strs[0];

    // for (int i=1; i<strs.length; i++)
    //   while (strs[i].indexOf(prefix) != 0) {
    //     prefix = prefix.substring(0, prefix.length() - 1);

    //     if (prefix.isEmpty())
    //       return "";
    //   }

    // return prefix;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be fl
    System.out.println(solution.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));

    // should be ""
    System.out.println(solution.longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
  }
}

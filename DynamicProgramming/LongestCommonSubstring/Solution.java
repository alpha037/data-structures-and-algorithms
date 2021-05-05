package DynamicProgramming.LongestCommonSubstring;

// import java.util.Arrays;

/**
 * * Longest Common Substring (Variation of LCS Problem)
 */
public class Solution {
  public int longestCommonSubstring(String s1, String s2) {
    // return longestCommonSubstringRec(
    //   s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length(), 0
    // );

    return longestCommonSubstringDP(s1, s2);
  }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(mn)
   * * SC: O(mn)
   */
  private int longestCommonSubstringDP(String s1, String s2) {
    int m = s1.length(), n = s2.length(), maxLen = 0;
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
        else dp[i][j] = 0;

        maxLen = max(maxLen, dp[i][j]);
      }
    }

    return maxLen;
  }

  /**
   * * Recursive Approach
   *
   * * TC: O(3^(m + n)) approximately
   * * SC: O(3^(m + n)) approximately
   */
  // private int longestCommonSubstringRec(char[] s1, char[] s2, int m, int n, int length) {
  //   if (m == 0 || n == 0) return length;

  //   if (s1[m - 1] == s2[n - 1])
  //     length = longestCommonSubstringRec(s1, s2, m - 1, n - 1, length + 1);

  //   length = max(
  //     length,
  //     longestCommonSubstringRec(s1, s2, m - 1, n, 0),
  //     longestCommonSubstringRec(s1, s2, m, n - 1, 0)
  //   );

  //   return length;
  // }

  private int max(int... a) {
    int maxValue = Integer.MIN_VALUE;
    for (int val : a) maxValue = Math.max(maxValue, val);
    return maxValue;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 4
    System.out.println(solution.longestCommonSubstring("abcdxyz", "xyzabcd"));

    // should be 6
    System.out.println(solution.longestCommonSubstring("zxabcdezy", "yzabcdezx"));
  }
}

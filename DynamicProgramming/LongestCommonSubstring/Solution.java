package DynamicProgramming.LongestCommonSubstring;

// import java.util.ArrayList;
// import java.util.List;

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
    int m = s1.length(), n = s2.length(), maxLen = 0, row = 0, col = 0;
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
          if (maxLen < dp[i][j]) {
            maxLen = dp[i][j];
            row = i;
            col = j;
          }
        } else dp[i][j] = 0;
      }
    }

    System.out.println(buildSequence(s1, row, col, dp));

    return maxLen;
  }

  private String buildSequence(String s1, int row, int col, int[][] dp) {
    StringBuilder seq = new StringBuilder();

    while (dp[row][col] != 0) {
      seq.append(String.valueOf(s1.charAt(row - 1)));

      --row;
      --col;
    }

    return seq.reverse().toString();
  }

  /**
   * * Recursive Approach
   *
   * * TC: O(3^(m + n)) approximately
   * * SC: O(3^(m + n)) approximately
   */
  // private int longestCommonSubstringRec(char[] c1, char[] c2, int m, int n, int length) {
  //   if (m == 0 || n == 0) return length;

  //   if (c1[m - 1] == c2[n - 1])
  //     length = longestCommonSubstringRec(c1, c2, m - 1, n - 1, length + 1);

  //   length = max(
  //     length,
  //     longestCommonSubstringRec(c1, c2, m - 1, n, 0),
  //     longestCommonSubstringRec(c1, c2, m, n - 1, 0)
  //   );

  //   return length;
  // }

  // private int max(int... a) {
  //   int maxValue = Integer.MIN_VALUE;
  //   for (int val : a) maxValue = Math.max(maxValue, val);
  //   return maxValue;
  // }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 4
    System.out.println(solution.longestCommonSubstring("abcdxyz", "xyzabcd"));

    // should be 6
    System.out.println(solution.longestCommonSubstring("zxabcdezy", "yzabcdezx"));
  }
}

package DynamicProgramming.LongestRepeatingSubsequence;

// import java.util.Arrays;

/**
 * * Longest Repeating Subsequence (Variation of LCS problem)
 */
public class Solution {
  public int longestRepeatingSubsequence(String str) {

    /**
     * This problem is just the modification of Longest Common
     * problem. The idea is to find the LCS(str, str) where str is the
     * string with the restriction that when both the characters are same,
     * shouldn’t be on the same index in the two strings.
     */

    // return longestCommonSubsequenceRec(str.length(), str.length(), str.toCharArray(),
    // str.toCharArray());

    // int[][] cache = new int[str.length() + 1][str.length() + 1];
    // for (int[] row : cache) Arrays.fill(row, -1);

    // return longestCommonSubsequenceMem(str.length(), str.length(), str.toCharArray(),
    // str.toCharArray(), cache);

    return longestCommonSubsequenceDP(str, str);

    // return longestCommonSubsequenceDPSpaceOpt(str, str);
  }

  /**
   * * Dynamic Programming Approach (Space Optimized)
   *
   * * TC: O(mn)
   * * SC: O(n)
   */
  // private int longestCommonSubsequenceDPSpaceOpt(String s1, String s2) {
  //   int m = s1.length(), n = s2.length(), idx = 0;
  //   int[][] dp = new int[2][n + 1];

  //   for (int i = 1; i < m + 1; i++) {
  //     // Calculate whether the the
  //     // current row is even/odd.
  //     idx = i & 1;
  //     for (int j = 1; j < n + 1; j++) {
  //       if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j)
  //         dp[idx][j] = 1 + dp[1 - idx][j - 1];
  //       else
  //         dp[idx][j] = Math.max(
  //           dp[1 - idx][j],
  //           dp[idx][j - 1]
  //         );
  //     }
  //   }

  //   return dp[idx][n];
  // }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(mn)
   * * SC: O(mn)
   */
  private int longestCommonSubsequenceDP(String s1, String s2) {
    int m = s1.length(), n = s2.length();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j) dp[i][j] = 1 + dp[i - 1][j - 1];
        else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }

    System.out.println(buildSequence(s1, dp));

    return dp[m][n];
  }

  private String buildSequence(String str, int[][] dp) {
    StringBuilder seq = new StringBuilder();
    int i = str.length(), j = str.length();

    while (i > 0 && j > 0) {
      // If this cell is same as diagonally
      // adjacent cell just above it, then
      // same characters are present at
      // str[i - 1] and str[j - 1]. Append any
      // of them to result.
      if (dp[i][j] == 1 + dp[i - 1][j - 1]) {
        seq.append(String.valueOf(str.charAt(i - 1)));

        --i;
        --j;
      }
      // Otherwise we move to the side
      // that that gave us maximum result
      else if (dp[i][j] == dp[i - 1][j]) --i;
      else --j;
    }

    return seq.reverse().toString();
  }

  /**
   * * Memoization Approach
   *
   * * TC: O(mn)
   * * SC: O(mn)
   */
  // private int longestCommonSubsequenceMem(int m, int n, char[] c1, char[] c2, int[][] cache) {
  //   if (m == 0 || n == 0) return 0;

  //   if (cache[m][n] != -1) return cache[m][n];

  //   if (c1[m - 1] == c2[n - 1] && m != n)
  //     return cache[m][n] = 1 + longestCommonSubsequenceMem(m - 1, n - 1, c1, c2, cache);

  //   return cache[m][n] = Math.max(
  //     longestCommonSubsequenceMem(m - 1, n, c1, c2, cache),
  //     longestCommonSubsequenceMem(m, n - 1, c1, c2, cache)
  //   );
  // }

  /**
   * * Recursive Approach
   *
   * * TC: O(3^(m + n)) approximately
   * * SC: O(3^(m + n)) approximately
   */
  // private int longestCommonSubsequenceRec(int m, int n, char[] c1, char[] c2) {
  //   if (m == 0 || n == 0) return 0;

  //   if (c1[m - 1] == c2[n - 1] && m != n)
  //     return 1 + longestCommonSubsequenceRec(m - 1, n - 1, c1, c2);

  //   return Math.max(
  //     longestCommonSubsequenceRec(m - 1, n, c1, c2),
  //     longestCommonSubsequenceRec(m, n - 1, c1, c2)
  //   );
  // }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 3
    System.out.println(solution.longestRepeatingSubsequence("AABEBCDD"));
  }
}

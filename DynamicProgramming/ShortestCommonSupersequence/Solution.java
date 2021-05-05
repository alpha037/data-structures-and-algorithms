package DynamicProgramming.ShortestCommonSupersequence;

// import java.util.ArrayList;
// import java.util.List;

// import java.util.Arrays;

/**
 * * Shortest Common Supersequence (Variation of LCS Problem)
 */

public class Solution {
  public int shortestCommonSupersequence(String s1, String s2) {
    int lcsLength;

    // lcsLength = longestCommonSubsequenceRec(s1.length(), s2.length(), s1.toCharArray(), s2.toCharArray());

    // lcsLength = longestCommonSubsequenceDP(s1, s2);

    lcsLength = longestCommonSubsequenceDPSpaceOpt(s1, s2);

    /**
     * ? Length of the shortest supersequence = 
     *    Sum of lengths of given two strings - 
     *    Length of LCS of two given strings
     */
    return s1.length() + s2.length() - lcsLength;
  }

  /**
   * * Dynamic Programming Approach (Space Optimized)
   *
   * * TC: O(mn)
   * * SC: O(n)
   */
  private int longestCommonSubsequenceDPSpaceOpt(String s1, String s2) {
    int m = s1.length(), n = s2.length(), idx = 0;
    int[][] dp = new int[2][n + 1];

    for (int i = 1; i < m + 1; i++) {
      // Calculate whether the the
      // current row is even/odd.
      idx = i & 1;
      for (int j = 1; j < n + 1; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1))
          dp[idx][j] = 1 + dp[1 - idx][j - 1];
        else
          dp[idx][j] = Math.max(
            dp[1 - idx][j],
            dp[idx][j - 1]
          );
      }
    }

    return dp[idx][n];
  }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(mn)
   * * SC: O(mn)
   */
  // private int longestCommonSubsequenceDP(String s1, String s2) {
  //   int m = s1.length(), n = s2.length();
  //   int[][] dp = new int[m + 1][n + 1];

  //   for (int i = 1; i < m + 1; i++) {
  //     for (int j = 1; j < n + 1; j++) {
  //       if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
  //       else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
  //     }
  //   }

  //   return dp[m][n];
  // }

  /**
   * * Memoization Approach
   *
   * * TC: O(mn)
   * * SC: O(mn)
   */
  // private int longestCommonSubsequenceMem(int m, int n, char[] c1, char[] c2, int[][] cache) {
  //   if (m == 0 || n == 0) return 0;

  //   if (cache[m][n] != -1) return cache[m][n];

  //   if (c1[m - 1] == c2[n - 1])
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

  //   if (c1[m - 1] == c2[n - 1])
  //     return 1 + longestCommonSubsequenceRec(m - 1, n - 1, c1, c2);

  //   return Math.max(
  //     longestCommonSubsequenceRec(m - 1, n, c1, c2),
  //     longestCommonSubsequenceRec(m, n - 1, c1, c2)
  //   );
  // }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 5
    System.out.println(solution.shortestCommonSupersequence("geek", "eke"));

    // should be 9
    System.out.println(solution.shortestCommonSupersequence("AGGTAB", "GXTXAYB"));
  }
}

package DynamicProgramming.MinimumNumberOfDeletionsToMakeAStringPalindrome;

// import java.util.List;
// import java.util.ArrayList;
// import java.util.Arrays;

/**
 * * Minimum Number of Deletions to Make a String Palindrome
 * * (Variation of LCS problem)
 */
public class Solution {
  public int minimumNumberOfDeletions(String str) {
    String reversed = new StringBuilder(str).reverse().toString();

    /**
     * * Minimum number of deletions to make a string palindrome =
     * *  Length of string - LPS(string)
     */
    return str.length() - longestCommonSubsequenceDP(str, reversed);
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
  //     idx = i & 1;
  //     for (int j = 1; j < n + 1; j++) {
  //       if (s1.charAt(i - 1) == s2.charAt(j - 1))
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
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
        else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }

    System.out.println(buildSequence(s1, s2, dp));

    return dp[m][n];
  }

  private String buildSequence(String s1, String s2, int[][] dp) {
    StringBuilder seq = new StringBuilder();

    int i = s1.length(), j = s2.length();

    while (i > 0 && j > 0) {
      if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
        seq.append(String.valueOf(s1.charAt(i - 1)));
        --i;
        --j;
      } else if (dp[i - 1][j] > dp[i][j - 1]) --i;
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

    // should be 1
    System.out.println(solution.minimumNumberOfDeletions("agbcba"));

    // should be 2
    System.out.println(solution.minimumNumberOfDeletions("aebcbda"));
  }
}

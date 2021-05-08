package DynamicProgramming.SequencePatternMatching;

/**
 * * Sequence Pattern Matching
 * * (Variation of LCS Problem but can be efficiently
 * * solved using Two pointers approach)
 */
public class Solution {
  public boolean isSubsequence(String str, String probableSeq) {
    // return probableSeq.length() == longestCommonSubsequenceDPSpaceOpt(str, probableSeq);

    return isSubsequenceHelper(str, probableSeq);
  }

  /**
   * * Two Pointers Approach
   *
   * * TC: O(m + n)
   * * SC: O(1)
   */
  private boolean isSubsequenceHelper(String str, String probableSeq) {
    if (probableSeq.length() > str.length()) return false;

    int charsFound = 0;
    int start = 0, end = str.length();
    int seqStart = 0, seqEnd = probableSeq.length();

    while (start < end && seqStart < seqEnd) {
      char currentChar = probableSeq.charAt(seqStart);

      if (currentChar == str.charAt(start++)) {
        ++charsFound;
        ++seqStart;
      }
    }

    return charsFound == seqEnd;
  }

  /**
   * * Dynamic Programming Approach
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
  //           dp[idx][j - 1],
  //           dp[1 - idx][j]
  //         );
  //     }
  //   }

  //   return dp[idx][n];
  // }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be true
    System.out.println(solution.isSubsequence("ADXCPY", "AXY"));
  }
}

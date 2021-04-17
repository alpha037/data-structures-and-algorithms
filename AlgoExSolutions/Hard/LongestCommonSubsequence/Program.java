package AlgoExSolutions.Hard.LongestCommonSubsequence;

import java.util.*;

/**
 * * Longest Common Subsequence
 */
class Program {
  /**
   * * TC: O(mn)
   * * SC: O(mn)
   */
  public static List<Character> longestCommonSubsequence(String str1, String str2) {
    // Write your code here.
    int[][] lcs = new int[str1.length() + 1][str2.length() + 1];

    for (int i = 1; i < lcs.length; i++) {
      for (int j = 1; j < lcs[i].length; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) lcs[i][j] = 1 + lcs[i - 1][j - 1];
        else lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
      }
    }

    return buildSequence(lcs, str1, str2);
  }

  private static List<Character> buildSequence(int[][] lcs, String str1, String str2) {
    List<Character> sequence = new ArrayList<>();
    int i = lcs.length - 1, j = lcs[0].length - 1;

    while (i > 0 && j > 0) {
      if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
        sequence.add(0, str1.charAt(i - 1));
        --i;
        --j;
      } else if (lcs[i - 1][j] > lcs[i][j - 1]) --i;
      else --j;
    }

    return sequence;
  }
}

package AlgoExSolutions.VeryHard.KnuthMorrisPrattAlgorithm;

import java.util.*;

/**
 * * Knuth Morris Pratt Algorithm
 */
class Program {
  /**
   * * TC: O(m + n)
   * * SC: O(m)
   */
  public static boolean knuthMorrisPrattAlgorithm(String string, String substring) {
    // Write your code here.
    return matchPattern(string, substring, buildLongestPrefixSuffix(string, substring));
  }

  private static int[] buildLongestPrefixSuffix(String string, String substring) {
    int[] lps = new int[substring.length()];
    Arrays.fill(lps, -1);
    int i = 1, j = 0;

    while (i < substring.length()) {
      if (substring.charAt(i) == substring.charAt(j)) {
        lps[i] = j;
        ++i;
        ++j;
      } else if (j > 0) j = lps[j - 1] + 1;
      else ++i;
    }

    return lps;
  }

  private static boolean matchPattern(String string, String substring, int[] lps) {
    int i = 0, j = 0;

    while ((i + substring.length() - j) <= string.length()) {
      if (string.charAt(i) == substring.charAt(j)) {
        if (j == substring.length() - 1) return true;

        ++i;
        ++j;
      } else if (j > 0) j = lps[j - 1] + 1;
      else ++i;
    }

    return false;
  }
}

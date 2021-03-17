package AlgoExSolutions.Medium.LevenshteinDistance;

// import java.util.*;

/**
 * * Levenshtein Distance
 */
class Program {
  private static int min(int value1, int value2, int value3) {
    return value1 <= value2 && value1 <= value3
        ? value1
        : (value2 <= value3 && value2 <= value1 ? value2 : value3);
  }

  private static boolean isEven(int num) {
    return num % 2 == 0;
  }

  /**
   * * TC: O(MN)
   * * SC: O(min(M, N))
   */
  public static int levenshteinDistance(String str1, String str2) {
    // Write your code here.
    String small = str1.length() < str2.length() ? str1 : str2;
    String big = str1.length() >= str2.length() ? str1 : str2;

    int[] evenRow = new int[small.length() + 1];
    int[] oddRow = new int[small.length() + 1];

    int[] currentRow, previousRow;

    for (int j = 0; j <= small.length(); j++) evenRow[j] = j;

    for (int i = 1; i <= big.length(); i++) {
      if (isEven(i)) {
        currentRow = evenRow;
        previousRow = oddRow;
      } else {
        currentRow = oddRow;
        previousRow = evenRow;
      }

      currentRow[0] = i;

      for (int j = 1; j <= small.length(); j++) {
        if (big.charAt(i - 1) == small.charAt(j - 1)) currentRow[j] = previousRow[j - 1];
        else currentRow[j] = 1 + min(currentRow[j - 1], previousRow[j - 1], previousRow[j]);
      }
    }

    return isEven(big.length()) ? evenRow[small.length()] : oddRow[small.length()];
  }

  /**
   * * TC: O(MN)
   * * SC: O(MN)
   */
  // public static int levenshteinDistance(String str1, String str2) {
  //   // Write your code here.
  //   int m = str1.length(), n = str2.length();
  //   int[][] minOps = new int[m + 1][n + 1];

  //   for (int i = 0; i <= m; i++) minOps[i][0] = i;

  //   for (int j = 1; j <= n; j++) minOps[0][j] = j;

  //   for (int i = 1; i <= m; i++) {
  //     for (int j = 1; j <= n; j++) {
  //       if (str1.charAt(i - 1) == str2.charAt(j - 1)) minOps[i][j] = minOps[i - 1][j - 1];
  //       else minOps[i][j] = 1 + min(minOps[i][j - 1], minOps[i - 1][j - 1], minOps[i - 1][j]);
  //     }
  //   }

  //   return minOps[m][n];
  // }
}

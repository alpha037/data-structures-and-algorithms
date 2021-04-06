package AlgoExSolutions.Hard.InterweavingStrings;

// import java.util.*;

/**
 * * Interweaving Strings
 */
class Program {
  /**
   * * Memoization Approach
   *
   * * TC: O(nm)
   * * SC: O(nm)
   */
  public static boolean interweavingStrings(String one, String two, String three) {
    // Write your code here.
    if (one.length() + two.length() != three.length()) return false;

    boolean[][] cache = new boolean[one.length() + 1][two.length() + 1];
    return interweavingStrings(one, 0, two, 0, three, cache);
  }

  private static boolean interweavingStrings(
      String one, int i, String two, int j, String three, boolean[][] cache) {
    if (cache[i][j]) return cache[i][j];

    int k = i + j;
    if (k == three.length()) return true;

    if (i < one.length() && one.charAt(i) == three.charAt(k)) {
      cache[i][j] = interweavingStrings(one, i + 1, two, j, three, cache);
      if (cache[i][j]) return true;
    }

    if (j < two.length() && two.charAt(j) == three.charAt(k)) {
      cache[i][j] = interweavingStrings(one, i, two, j + 1, three, cache);
      return cache[i][j];
    }

    return cache[i][j];
  }

  /**
   * * Recursive Approach
   *
   * * TC: O(2^(n + m))
   * * SC: O(n + m)
   */
  // public static boolean interweavingStrings(String one, String two, String three) {
  //   // Write your code here.
  // 	if (one.length() + two.length() != three.length()) return false;

  // 	return interweavingStrings(one, 0, two, 0, three);
  // }

  // private static boolean interweavingStrings(
  // 	String one, int i, String two, int j, String three
  // ) {
  //   int k = i + j;
  // 	if (k == three.length()) return true;

  // 	if (i < one.length() && one.charAt(i) == three.charAt(k)) {
  // 		if (interweavingStrings(one, i + 1, two, j, three)) return true;
  // 	}

  // 	if (j < two.length() && two.charAt(j) == three.charAt(k)) {
  // 		return interweavingStrings(one, i, two, j + 1, three);
  // 	}

  // 	return false;
  // }
}

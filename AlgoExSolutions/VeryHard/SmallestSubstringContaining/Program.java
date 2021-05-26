package AlgoExSolutions.VeryHard.SmallestSubstringContaining;

import java.util.*;

/**
 * * Smallest Substring Containing
 */
class Program {
  /**
   * * TC: O(b + s)
   * * SC: O(b + s)
   */
  public static String smallestSubstringContaining(String bigString, String smallString) {
    // Write your code here.
    Map<Character, Integer> smallStringCount = getSmallStringCharCount(smallString);
    Map<Character, Integer> bigStringCount = new HashMap<>();
    int len = bigString.length(), leftIdx = 0, rightIdx = 0;
    int start = 0, end = Integer.MAX_VALUE;
    int totalChars = smallStringCount.keySet().size(), charsFound = 0;

    while (rightIdx < len) {
      char rightChar = bigString.charAt(rightIdx);
      if (!smallStringCount.containsKey(rightChar)) {
        ++rightIdx;
        continue;
      }

      bigStringCount.put(rightChar, bigStringCount.getOrDefault(rightChar, 0) + 1);
      if (smallStringCount.get(rightChar) == bigStringCount.get(rightChar)) ++charsFound;

      while (totalChars == charsFound && leftIdx <= rightIdx) {
        int[] closerBounds = getCloserBounds(start, end, leftIdx, rightIdx);
        start = closerBounds[0];
        end = closerBounds[1];

        char leftChar = bigString.charAt(leftIdx);
        if (!smallStringCount.containsKey(leftChar)) {
          ++leftIdx;
          continue;
        }

        if (smallStringCount.get(leftChar) == bigStringCount.get(leftChar)) --charsFound;
        bigStringCount.put(leftChar, bigStringCount.get(leftChar) - 1);

        ++leftIdx;
      }

      ++rightIdx;
    }

    return end == Integer.MAX_VALUE ? "" : bigString.substring(start, end + 1);
  }

  private static Map<Character, Integer> getSmallStringCharCount(String str) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : str.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
    return map;
  }

  private static int[] getCloserBounds(int idx1, int idx2, int idx3, int idx4) {
    return idx2 - idx1 > idx4 - idx3 ? new int[] {idx3, idx4} : new int[] {idx1, idx2};
  }
}

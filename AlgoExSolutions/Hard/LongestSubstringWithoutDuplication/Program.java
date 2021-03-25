package AlgoExSolutions.Hard.LongestSubstringWithoutDuplication;

import java.util.*;

/**
 * * Longest Substring Without Duplication
 */
class Program {
  /**
   * * Sliding Window Approach
   * * TC: O(n)
   * * SC: O(min(n, substring))
   */
  public static String longestSubstringWithoutDuplication(String str) {
    // Write your code here
    Map<Character, Boolean> map = new HashMap<>();
    int start = 0, end = 0;
    int[] longestSubstringPosition = new int[] {0, 0};

    while (end < str.length()) {
      char currChar = str.charAt(end);
      if (map.containsKey(currChar)) {
        updateLongestSubstringPosition(start, end, longestSubstringPosition);
        map.remove(str.charAt(start++));
      } else {
        map.put(currChar, true);
        ++end;
      }
    }

    updateLongestSubstringPosition(start, end, longestSubstringPosition);

    return str.substring(longestSubstringPosition[0], longestSubstringPosition[1]);
  }

  private static void updateLongestSubstringPosition(
      int start, int end, int[] longestSubstringPosition) {
    int currentLength = end - start;
    int maxLength = longestSubstringPosition[1] - longestSubstringPosition[0];

    if (currentLength > maxLength) {
      longestSubstringPosition[0] = start;
      longestSubstringPosition[1] = end;
    }
  }
}

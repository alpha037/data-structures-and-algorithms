package AlgoExSolutions.Hard.PatternMatcher;

import java.util.*;

/**
 * * Pattern Matcher
 */
class Program {
  /**
   * * TC: O(n^2 + m)
   * * SC: O(n + m)
   */
  public static String[] patternMatcher(String pattern, String str) {
    // Write your code here.
    if (pattern.length() > str.length()) return new String[] {};

    char[] newPattern = getNewPattern(pattern);
    Map<String, Integer> map = getCountsAndFirstYPosition(newPattern);

    boolean didSwitch = newPattern[0] != pattern.charAt(0);
    int len = str.length(), countOfX = map.get("x"), countOfY = map.get("y");
    int firstYPos = map.get("firstYPos");

    if (countOfY != 0) {
      for (int currLengthOfX = 1; currLengthOfX < len; currLengthOfX++) {
        int currLengthOfY = (len - (currLengthOfX * countOfX)) / countOfY;

        if (currLengthOfY <= 0) continue;

        int yIdx = firstYPos * currLengthOfX;

        String potentialX = str.substring(0, currLengthOfX);
        String potentialY = str.substring(yIdx, yIdx + currLengthOfY);

        String potentialMatch = replaceOccurences(newPattern, potentialX, potentialY);

        if (potentialMatch.equals(str))
          return didSwitch
              ? new String[] {potentialY, potentialX}
              : new String[] {potentialX, potentialY};
      }
    }

    int currLengthOfX = len / countOfX;
    String potentialX = str.substring(0, currLengthOfX);
    String potentialY = "";
    String potentialMatch = replaceOccurences(newPattern, potentialX, potentialY);

    if (potentialMatch.equals(str))
      return didSwitch
          ? new String[] {potentialY, potentialX}
          : new String[] {potentialX, potentialY};

    return new String[] {};
  }

  private static char[] getNewPattern(String pattern) {
    char[] patternChars = pattern.toCharArray();

    if (patternChars[0] == 'x') return patternChars;

    for (int i = 0; i < patternChars.length; i++) {
      if (patternChars[i] == 'y') patternChars[i] = 'x';
      else patternChars[i] = 'y';
    }

    return patternChars;
  }

  private static Map<String, Integer> getCountsAndFirstYPosition(char[] pattern) {
    Map<String, Integer> map = new HashMap<>();
    String x = "x", y = "y", firstYPos = "firstYPos";

    for (int i = 0; i < pattern.length; i++) {
      if (pattern[i] == 'x') map.put(x, map.getOrDefault(x, 0) + 1);
      else {
        if (!map.containsKey(firstYPos)) map.put(firstYPos, i);
        map.put(y, map.getOrDefault(y, 0) + 1);
      }
    }

    if (!map.containsKey(y)) {
      map.put(y, 0);
      map.put(firstYPos, -1);
    }

    return map;
  }

  private static String replaceOccurences(char[] pattern, String x, String y) {
    StringBuilder potentialMatch = new StringBuilder("");

    for (char c : pattern) {
      if (c == 'x') potentialMatch.append(x);
      else potentialMatch.append(y);
    }

    return potentialMatch.toString();
  }
}

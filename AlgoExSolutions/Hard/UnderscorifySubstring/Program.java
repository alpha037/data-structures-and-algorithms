package AlgoExSolutions.Hard.UnderscorifySubstring;

import java.util.*;

/**
 * * Underscorify Substring
 */
class Program {
  /**
   * * TC: Average: O(n + m); Worst Upper-Bound: O(n * (n + m))
   * * SC: O(n)
   */
  public static String underscorifySubstring(String str, String substring) {
    // Write your code here.
    List<Integer[]> locations = collapse(getLocations(str, substring));
    return underscorifySubstring(str, locations);
  }

  private static List<Integer[]> getLocations(String str, String substring) {
    List<Integer[]> locations = new ArrayList<>();
    int startIdx = 0;

    while (startIdx < str.length()) {
      int nextIdx = str.indexOf(substring, startIdx);
      if (nextIdx == -1) break;

      locations.add(new Integer[] {nextIdx, nextIdx + substring.length()});
      startIdx = nextIdx + 1;
    }

    return locations;
  }

  private static List<Integer[]> collapse(List<Integer[]> locations) {
    if (locations.size() == 0) return locations;

    List<Integer[]> collapsedLocations = new ArrayList<>();
    collapsedLocations.add(locations.get(0));
    Integer[] previous = locations.get(0);

    for (int i = 1; i < locations.size(); i++) {
      Integer[] current = locations.get(i);

      if (current[0] <= previous[1]) previous[1] = current[1];
      else {
        collapsedLocations.add(current);
        previous = current;
      }
    }

    return collapsedLocations;
  }

  private static String underscorifySubstring(String str, List<Integer[]> locations) {
    int stringIdx = 0, locationsIdx = 0, i = 0;
    boolean inBetweenUnderScores = false;
    List<String> finalChars = new ArrayList<>();

    while (stringIdx < str.length() && locationsIdx < locations.size()) {
      if (stringIdx == locations.get(locationsIdx)[i]) {
        finalChars.add("_");
        inBetweenUnderScores = !inBetweenUnderScores;

        if (!inBetweenUnderScores) locationsIdx++;

        i = i == 0 ? 1 : 0;
      }
      finalChars.add(str.charAt(stringIdx) + "");
      stringIdx++;
    }

    if (locationsIdx < locations.size()) finalChars.add("_");

    if (stringIdx < str.length()) finalChars.add(str.substring(stringIdx));

    return String.join("", finalChars);
  }
}

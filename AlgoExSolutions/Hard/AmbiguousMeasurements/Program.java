package AlgoExSolutions.Hard.AmbiguousMeasurements;

import java.util.*;

/**
 * * Ambiguous Measurements
 */
class Program {
  /**
   * * TC: O(low * high * n)
   * * SC: O(low * high)
   */
  public boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
    // Write your code here.
    Map<String, Boolean> cache = new HashMap<>();
    return ambiguousMeasurements(measuringCups, cache, low, high);
  }

  private boolean ambiguousMeasurements(
      int[][] measuringCups, Map<String, Boolean> cache, int low, int high) {
    String key = getKey(low, high);
    if (cache.containsKey(key)) return cache.get(key);

    if (low <= 0 && high <= 0) return false;

    // Can also put this as our
    // base since we're already
    // capping the low and high
    // values at 0 if it ever
    // becomes negative
    // if (low == 0 && high == 0) return false;

    boolean canMeasure = false;
    for (int[] cup : measuringCups) {
      int cupLow = cup[0], cupHigh = cup[1];
      if (low <= cupLow && cupHigh <= high) {
        canMeasure = true;
        break;
      }

      int newLow = Math.max(0, low - cupLow);
      int newHigh = Math.max(0, high - cupHigh);
      canMeasure = ambiguousMeasurements(measuringCups, cache, newLow, newHigh);

      if (canMeasure) break;
    }

    cache.put(key, canMeasure);
    return cache.get(key);
  }

  private String getKey(int low, int high) {
    return low + ":" + high;
  }
}

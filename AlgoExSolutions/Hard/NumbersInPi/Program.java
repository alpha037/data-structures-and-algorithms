package AlgoExSolutions.Hard.NumbersInPi;

import java.util.*;

/**
 * * Numbers In Pi
 */
class Program {
  public static int numbersInPi(String pi, String[] numbers) {
    // Write your code here.

    // int minSpaces = numbersInPiRec(0, pi, getNumbersMap(numbers));

    int[] cache = new int[pi.length()];
    Arrays.fill(cache, Integer.MAX_VALUE);
    int minSpaces = numbersInPiMem(0, pi, getNumbersMap(numbers), cache);

    return minSpaces == Integer.MAX_VALUE ? -1 : minSpaces;
  }

  private static Map<String, Boolean> getNumbersMap(String[] numbers) {
    Map<String, Boolean> map = new HashMap<>();
    for (String number : numbers) map.put(number, true);
    return map;
  }

  /**
   * * Memoization Approach
   *
   * * TC: O(n^3 + m)
   * * SC: O(n + m) approximately
   */
  private static int numbersInPiMem(
      int index, String pi, Map<String, Boolean> numbersMap, int[] cache) {
    if (index == pi.length()) return -1;

    if (cache[index] != Integer.MAX_VALUE) return cache[index];

    int minSpaces = Integer.MAX_VALUE;
    for (int i = index; i < pi.length(); i++) {
      String prefix = pi.substring(index, i + 1);

      if (numbersMap.containsKey(prefix)) {
        int minSpacesInSuffix = 1 + numbersInPiMem(i + 1, pi, numbersMap, cache);

        if (minSpacesInSuffix != Integer.MIN_VALUE) minSpaces = min(minSpaces, minSpacesInSuffix);
      }
    }

    return cache[index] = minSpaces;
  }

  /**
   * * Recursive Approach
   *
   * * TC: O(n^3 + m)
   * * SC: O(n^3 + m) approximately
   */
  // private static int numbersInPiRec(
  // 	int index, String pi, Map<String, Boolean> numbersMap
  // ) {
  // 	if (index == pi.length()) return -1;

  // 	int minSpaces = Integer.MAX_VALUE;
  // 	for (int i = index; i < pi.length(); i++) {
  // 		String prefix = pi.substring(index, i + 1);

  // 		if (numbersMap.containsKey(prefix)) {
  // 			int minSpacesInSuffix = 1 + numbersInPiRec(i + 1, pi, numbersMap);

  // 			if (minSpacesInSuffix != Integer.MIN_VALUE)
  // 				minSpaces = min(minSpaces, minSpacesInSuffix);
  // 		}
  // 	}

  // 	return minSpaces;
  // }

  private static int min(int... a) {
    int minValue = Integer.MAX_VALUE;
    for (int val : a) minValue = Math.min(minValue, val);
    return minValue;
  }
}

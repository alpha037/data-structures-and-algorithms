package AlgoExSolutions.Easy.TwoNumberSum;

import java.util.*;

/**
 * * Two Number Sum
 */
class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    // Write your code here.
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < array.length; i++) {
      int res = targetSum - array[i];
      if (map.containsKey(res) && (i != map.get(res))) return new int[] {array[i], res};
      else map.put(array[i], i);
    }

    return new int[0];
  }
}

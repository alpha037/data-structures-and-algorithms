package AlgoExSolutions.Medium.ThreeNumberSum;

import java.util.*;

/**
 * * Three Number Sum
 */
class Program {
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    // Write your code here.
    if (array.length < 3) return new ArrayList<Integer[]>();

    Arrays.sort(array);
    List<Integer[]> res = new ArrayList<>();

    for (int i = 0; i < array.length - 1; i++) {
      int j = i + 1, k = array.length - 1;

      while (j < k) {
        int sum = array[i] + array[j] + array[k];

        if (sum > targetSum) --k;
        else if (sum < targetSum) ++j;
        else {
          res.add(new Integer[] {array[i], array[j++], array[k--]});

          while (j < k && array[j] == array[j + 1]) ++j;

          while (j < k && array[k] == array[k - 1]) --k;
        }
      }
    }

    return res;
  }
}

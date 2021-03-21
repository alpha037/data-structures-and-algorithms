package AlgoExSolutions.Hard.FourNumberSum;

import java.util.*;

/**
 * * Four Number Sum
 */
class Program {
  static class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  /**
   * * TC: O(n^2) Average, O(n^3) Worst
   * * SC: O(n^2)
   */
  public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
    // Write your code here.
    List<Integer[]> quadruplets = new ArrayList<>();
    Map<Integer, List<Pair>> twoSumPairs = new HashMap<>();
    int len = array.length;

    for (int i = 0; i < len - 1; i++) {
      for (int j = i + 1; j < len; j++) {
        int currentSum = array[i] + array[j];
        int diff = targetSum - currentSum;

        if (twoSumPairs.containsKey(diff)) {
          for (Pair pair : twoSumPairs.get(diff))
            quadruplets.add(new Integer[] {pair.first, pair.second, array[i], array[j]});
        }
      }

      for (int k = 0; k < i; k++) {
        int twoSum = array[k] + array[i];

        if (!twoSumPairs.containsKey(twoSum)) twoSumPairs.put(twoSum, new ArrayList<>());

        twoSumPairs.get(twoSum).add(new Pair(array[k], array[i]));
      }
    }

    return quadruplets;
  }

  /**
   * * TC: O(n^3) Average
   * * SC: O(n^2)
   */
  // public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
  //   // Write your code here.
  // 	List<Integer[]> quadruplets = new ArrayList<>();
  //   Arrays.sort(array);
  // 	int len = array.length;

  // 	for (int i = 0; i < len - 2; i++) {
  // 		for (int j = i + 1; j < len - 1; j++) {
  // 			int start = j + 1, end = len - 1;

  // 			while (start < end) {
  // 				int currentSum = array[i] + array[j] + array[start] + array[end];

  // 				if (currentSum == targetSum) {
  // 					quadruplets.add(
  // 						new Integer[] {array[i], array[j], array[start], array[end]}
  // 					);
  // 					++start;
  // 					--end;
  // 				}
  // 				else if (currentSum > targetSum) --end;

  // 				else ++start;
  // 			}
  // 		}
  // 	}

  // 	return quadruplets;
  // }
}

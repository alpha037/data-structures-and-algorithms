package DynamicProgramming.MinimumSubsetSumDifference;

import java.util.Arrays;

/**
 * * Minimum Subset Sum Difference (Extension of 0/1 Knapsack)
 */
public class Solution {
  public int minimumSubsetSumDifference(int[] array) {
    int sum = Arrays.stream(array).sum();

    // return minimumSubsetSumDifferenceRec(array.length, array, sum, 0);

    // int[][] cache = new int[sum + 1][sum + 1];
    // for (int[] row : cache) Arrays.fill(row, Integer.MAX_VALUE);

    // return minimumSubsetSumDifferenceMem(array.length, array, sum, 0, cache);

    return minimumSubsetSumDifferenceDP(array, sum);
  }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(ns)
   * * SC: O(ns)
   */
  private int minimumSubsetSumDifferenceDP(int[] array, int sum) {
    boolean[] subsetSums = subsetSum(array, sum);

    for (int j = sum / 2; j >= 0; --j) {
      if (subsetSums[j]) return sum - 2 * j;
    }

    return -1;
  }

  private boolean[] subsetSum(int[] array, int sum) {
    int len = array.length;
    boolean[][] dp = new boolean[len + 1][sum + 1];

    // If the sum is 0, then every
    // element can make that target
    for (int i = 0; i < len + 1; i++) dp[i][0] = true;

    // If there is no element, then it won't
    // make any of the sums, except 0
    for (int j = 1; j < sum + 1; j++) dp[0][j] = false;

    for (int i = 1; i < len + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        int currentSum = j;
        boolean isSubsetWithoutCurrentItem = dp[i - 1][currentSum];

        if (array[i - 1] <= currentSum) {
          boolean isSubsetWithCurrentItem = dp[i - 1][currentSum - array[i - 1]];

          dp[i][j] = isSubsetWithCurrentItem || isSubsetWithoutCurrentItem;
        } else dp[i][j] = isSubsetWithoutCurrentItem;
      }
    }

    return dp[len];
  }

  /**
   * * Memoization Approach
   *
   * * TC: O(ns)
   * * SC: O(ns)
   */
  // private int minimumSubsetSumDifferenceMem(int index, int[] array, int sumOne, int sumTwo,
  // int[][] cache) {
  //   if (index == 0)
  //     return Math.abs(sumOne - sumTwo);

  //   if (cache[sumOne][sumTwo] != Integer.MAX_VALUE)
  //     return cache[sumOne][sumTwo];

  //   return cache[sumOne][sumTwo] = Math.min(
  //     minimumSubsetSumDifferenceMem(
  //       index - 1, array, sumOne - array[index - 1], sumTwo + array[index - 1], cache
  //     ),
  //     minimumSubsetSumDifferenceMem(index - 1, array, sumOne, sumTwo, cache)
  //   );
  // }

  /**
   * * Recursive Approach
   *
   * * TC: O(2^n) approximately
   * * SC: O(2^n) approximately
   */
  // private int minimumSubsetSumDifferenceRec(int index, int[] array, int sumOne, int sumTwo) {
  //   if (index == 0) return Math.abs(sumOne - sumTwo);

  // return Math.min(
  //   minimumSubsetSumDifferenceRec(
  //     index - 1, array, sumOne - array[index - 1], sumTwo + array[index - 1]
  //   ),
  //   minimumSubsetSumDifferenceRec(index - 1, array, sumOne, sumTwo)
  // );
  // }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 1
    System.out.println(solution.minimumSubsetSumDifference(new int[] {1, 6, 5, 11}));

    // should be 1
    System.out.println(solution.minimumSubsetSumDifference(new int[] {2, 7, 4, 1, 8, 1}));
  }
}

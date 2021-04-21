package DynamicProgramming.EqualSumPartitionProblem;

import java.util.Arrays;

/**
 * * Equal Sum Partition Problem (Variation of 0/1 Knapsack)
 */
public class Solution {
  public boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();

    if (sum % 2 != 0) return false;

    // return canPartitionRec(array.length, array, sum / 2);

    // boolean[][] cache = new boolean[array.length + 1][(sum / 2) + 1];
    // return canPartitionMem(array.length, array, sum / 2, cache);

    return canPartitionDP(nums, sum / 2);
  }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(ns)
   * * SC: O(ns)
   */
  private boolean canPartitionDP(int[] array, int sum) {
    int len = array.length;
    boolean[][] dp = new boolean[len + 1][sum + 1];

    for (int i = 0; i < len + 1; i++) dp[i][0] = true;

    for (int i = 1; i < len + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (array[i - 1] <= j) dp[i][j] = dp[i - 1][j] || dp[i - 1][j - array[i - 1]];
        else dp[i][j] = dp[i - 1][j];
      }
    }

    return dp[len][sum];
  }

  /**
   * * Memoization Approach
   *
   * * TC: O(ns)
   * * SC: O(ns)
   */
  // private boolean canPartitionMem(int index, int[] array, int sum, boolean[][] cache) {
  //   if (sum == 0) return true;
  //   if (index == 0) return false;

  //   if (cache[index][sum]) return true;

  //   if (array[index - 1] <= sum)
  //     return cache[index][sum] =
  //       canPartitionMem(index - 1, array, sum - array[index - 1], cache) ||
  //       canPartitionMem(index - 1, array, sum, cache);

  //   return cache[index][sum] = canPartitionMem(index - 1, array, sum, cache);
  // }

  /**
   * * Recursive Approach
   *
   * * TC: O(2^n) approximately
   * * SC: O(2^n) approximately
   */
  // private boolean canPartitionRec(int index, int[] array, int sum) {
  //   if (sum == 0) return true;
  //   if (index == 0) return false;

  //   if (array[index - 1] <= sum)
  //     return
  //       canPartitionRec(index - 1, array, sum - array[index - 1]) ||
  //       canPartitionRec(index - 1, array, sum);

  //   return canPartitionRec(index - 1, array, sum);
  // }

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.canPartition(new int[] {1, 5, 11, 5}));
  }
}

package DynamicProgramming.CountOfSubsetSumsEqualToGivenSum;

/**
 * * Count of Subsets Equal To A Given Sum (Variation of 0/1 Knapsack)
 */
public class Solution {
  public int countOfSubsets(int[] array, int sum) {
    // return countOfSubset(array.length, array, sum);

    // int[][] cache = new int[array.length + 1][sum + 1];
    // return countOfSubsetsMem(array.length, array, sum, cache);

    return countOfSubsetsDP(array, sum);
  }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(ns)
   * * SC: O(ns)
   */
  private int countOfSubsetsDP(int[] array, int sum) {
    int len = array.length;
    int[][] dp = new int[len + 1][sum + 1];

    for (int i = 0; i < len + 1; i++) dp[i][0] = 1;

    for (int i = 1; i < len + 1; i++) {
      for (int j = 0; j < sum + 1; j++) {
        // If the current item is less than
        // or equal to the current sum, then we
        // need to consider both the scenarios
        // where we include this current item and
        // where we don't include this current item
        if (array[i - 1] <= j) dp[i][j] = dp[i - 1][j] + dp[i - 1][j - array[i - 1]];

        // If the current item is greater
        // than our current sum, then there's
        // only one scenario where we don't
        // include this current item
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
  // private int countOfSubsetsMem(int index, int[] array, int sum, int[][] cache) {
  //   if (sum == 0) return 1;
  //   if (index == 0) return 0;

  //   if (array[index - 1] <= sum)
  //     return cache[index][sum] = countOfSubsetsMem(index - 1, array, sum - array[index - 1],
  // cache) + countOfSubsetsMem(index - 1, array, sum, cache);

  //   return cache[index][sum] = countOfSubsetsMem(index - 1, array, sum, cache);
  // }

  /**
   * * Recursive Approach
   *
   * * TC: O(2^n) approximately
   * * SC: O(2^n) approximately
   */
  // private int countOfSubset(int index, int[] array, int sum) {
  //   if (sum == 0) return 1;
  //   if (index == 0) return 0;

  //   if (array[index - 1] <= sum)
  //     return countOfSubset(index - 1, array, sum - array[index - 1]) + countOfSubset(index - 1,
  // array, sum);

  //   return countOfSubset(index - 1, array, sum);
  // }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 3
    System.out.println(solution.countOfSubsets(new int[] {1, 2, 3, 3}, 6));
  }
}

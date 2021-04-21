package DynamicProgramming.SubsetSumProblem;

// import java.util.*;

/**
 * * Subset Sum Problem (Variation of 0/1 Knapsack)
 */
public class Solution {
  public boolean hasSubsetSum(int[] array, int sum) {
    // return hasSubsetSumRec(array.length - 1, array, sum);

    // boolean[][] cache = new boolean[array.length + 1][sum + 1];
    // return hasSubsetSumMem(array.length, array, sum, cache);

    return hasSubsetSumDP(array, sum);
  }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(ns)
   * * SC: O(ns)
   */
  private boolean hasSubsetSumDP(int[] array, int sum) {
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

    return dp[len][sum];
  }

  // private List<Integer> buildSequence(int[] array, boolean[][] dp, int sum) {
  //   List<Integer> seq = new ArrayList<>();
  //   int len = dp.length;

  //   while (len > 0) {
  //     if (dp[len][sum] == dp[len - 1][sum]) --len;
  //     else {
  //       seq.add(0, array[len - 1]);
  //       sum -= array[len - 1];
  //       --len;
  //     }
  //   }

  //   return seq;
  // }

  /**
   * * Memoization Approach
   *
   * * TC: O(ns)
   * * SC: O(ns)
   */
  // private boolean hasSubsetSumMem(int index, int[] array, int sum, boolean[][] cache) {
  //   if (sum == 0) return true;
  //   if (index == 0) return false;

  //   if (cache[index][sum]) return true;

  //   if (array[index - 1] <= sum)
  //     return cache[index][sum] =
  //         hasSubsetSumMem(index - 1, array, sum - array[index - 1], cache)
  //             || hasSubsetSumMem(index - 1, array, sum, cache);

  //   return cache[index][sum] = hasSubsetSumMem(index - 1, array, sum, cache);
  // }

  /**
   * * Recursive Approach
   *
   * * TC: Exponential time
   * * SC: Exponential time
   */
  // private boolean hasSubsetSumRec(int index, int[] array, int sum) {
  //   if (sum == 0) return true;
  //   if (index == 0) return false;

  //   if (array[index] <= sum)
  //     return hasSubsetSumRec(index - 1, array, sum - array[index])
  //         || hasSubsetSumRec(index - 1, array, sum);

  //   return hasSubsetSumRec(index - 1, array, sum);
  // }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be true
    System.out.println(solution.hasSubsetSum(new int[] {3, 34, 4, 12, 5, 2}, 9));
  }
}

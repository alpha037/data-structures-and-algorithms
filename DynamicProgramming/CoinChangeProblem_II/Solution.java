package DynamicProgramming.CoinChangeProblem_II;

// import java.util.Arrays;

/**
 * * Coin Change Problem II (Variation of Unbounded Knapsack Problem)
 *
 * Problem: https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 */
public class Solution {
  public int minimumNumberOfCoins(int[] coins, int target) {
    // return minimumNumberOfCoinsRec(coins.length, coins, target);

    // int[][] cache = new int[coins.length + 1][target + 1];
    // for (int[] row : cache) Arrays.fill(row, Integer.MAX_VALUE - 1);

    // return minimumNumberOfCoinsMem(coins.length, coins, target, cache);

    return minimumNumberOfCoinsDP(coins, target);
  }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(nt)
   * * SC: O(nt)
   */
  private int minimumNumberOfCoinsDP(int[] coins, int target) {
    int len = coins.length;
    int[][] dp = new int[len + 1][target + 1];

    for (int i = 0; i < len + 1; i++) dp[i][0] = 0;

    for (int j = 1; j < target + 1; j++) dp[0][j] = Integer.MAX_VALUE - 1;

    for (int i = 1; i < len + 1; i++) {
      for (int j = 1; j < target + 1; j++) {
        if (coins[i - 1] <= j) dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
        else dp[i][j] = dp[i - 1][j];
      }
    }

    return dp[len][target];
  }

  /**
   * * Memoization Approach
   *
   * * TC: O(nt)
   * * SC: O(nt)
   */
  // private int minimumNumberOfCoinsMem(int index, int[] coins, int target, int[][] cache) {
  //   if (target == 0) return 0;
  //   if (index == 0) return Integer.MAX_VALUE - 1; // - 1 to prevent overflow

  //   if (cache[index][target] != Integer.MAX_VALUE - 1)
  //     return cache[index][target];

  //   if (coins[index - 1] <= target)
  //     return cache[index][target] = Math.min(
  //       1 + minimumNumberOfCoinsMem(index, coins, target - coins[index - 1], cache),
  //       minimumNumberOfCoinsMem(index - 1, coins, target, cache)
  //     );

  //   return cache[index][target] = minimumNumberOfCoinsMem(index - 1, coins, target, cache);
  // }

  /**
   * * Recursive Approach
   *
   * * TC: O(2^n) approximately
   * * SC: O(2^n) approximately
   */
  // private int minimumNumberOfCoinsRec(int index, int[] coins, int target) {
  //   if (target == 0) return 0;
  //   if (index == 0) return Integer.MAX_VALUE - 1; // - 1 to prevent overflow

  //   if (coins[index - 1] <= target)
  //     return Math.min(
  //       1 + minimumNumberOfCoinsRec(index, coins, target - coins[index - 1]),
  //       minimumNumberOfCoinsRec(index - 1, coins, target)
  //     );

  //   return minimumNumberOfCoinsRec(index - 1, coins, target);
  // }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 2
    System.out.println(solution.minimumNumberOfCoins(new int[] {25, 10, 5}, 30));

    // should be 2
    System.out.println(solution.minimumNumberOfCoins(new int[] {9, 6, 5, 1}, 11));
  }
}

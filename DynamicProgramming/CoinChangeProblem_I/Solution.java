package DynamicProgramming.CoinChangeProblem_I;

// import java.util.Arrays;

/**
 * * Coin Change Problem I (Variation of Unbounded Knapsack Problem)
 *
 * Problem: https://www.geeksforgeeks.org/coin-change-dp-7/
 */
public class Solution {
  public int numberOfWays(int[] coins, int target) {
    // return numberOfWaysRec(coins.length, coins, target);

    // int[][] cache = new int[coins.length + 1][target + 1];
    // for (int[] row : cache) Arrays.fill(row, Integer.MIN_VALUE);

    // return numberOfWaysMem(coins.length, coins, target, cache);

    // return numberOfWaysDP(coins, target);

    return numberOfWaysDPSpaceOpt(coins, target);
  }

  /**
   * * Dynamic Programming Approach (Space optimized)
   *
   * * TC: O(nt)
   * * SC: O(t)
   */
  private int numberOfWaysDPSpaceOpt(int[] coins, int target) {
    int[] dp = new int[target + 1];

    dp[0] = 1;

    for (int i = 1; i < coins.length + 1; i++) {
      for (int j = 1; j < target + 1; j++) if (coins[i - 1] <= j) dp[j] += dp[j - coins[i - 1]];
    }

    return dp[target];
  }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(nt)
   * * SC: O(nt)
   */
  // private int numberOfWaysDP(int[] coins, int target) {
  //   int len = coins.length;
  //   int[][] dp = new int[len + 1][target + 1];

  //   for (int i = 0; i < len + 1; i++)
  //     dp[i][0] = 1;

  //   for (int i = 1; i < len + 1; i++) {
  //     for (int j = 1; j < target + 1; j++) {
  //       if (coins[i - 1] <= j)
  //         dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
  //       else dp[i][j] = dp[i - 1][j];
  //     }
  //   }

  //   return dp[len][target];
  // }

  /**
   * * Memoization Approach
   *
   * * TC: O(nt)
   * * SC: O(nt)
   */
  // private int numberOfWaysMem(int index, int[] coins, int target, int[][] cache) {
  //   if (target == 0) return 1;
  //   if (index == 0) return 0;

  //   if (cache[index][target] != Integer.MIN_VALUE)
  //     return cache[index][target];

  //   if (coins[index - 1] <= target)
  //     return cache[index][target] =
  //       numberOfWaysMem(index, coins, target - coins[index - 1], cache) +
  //       numberOfWaysMem(index - 1, coins, target, cache);

  //   return cache[index][target] = numberOfWaysMem(index - 1, coins, target, cache);
  // }

  /**
   * * Recursive Approach
   *
   * * TC: O(2^n) approximately
   * * SC: O(2^n) approximately
   */
  // private int numberOfWaysRec(int index, int[] coins, int target) {
  //   if (target == 0) return 1;
  //   if (index == 0) return 0;

  //   if (coins[index - 1] <= target)
  //     return
  //       numberOfWaysRec(index, coins, target - coins[index - 1]) +
  //       numberOfWaysRec(index - 1, coins, target);

  //   return numberOfWaysRec(index - 1, coins, target);
  // }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 4
    System.out.println(solution.numberOfWays(new int[] {1, 2, 5}, 5));
  }
}

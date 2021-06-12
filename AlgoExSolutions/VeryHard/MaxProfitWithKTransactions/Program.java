package AlgoExSolutions.VeryHard.MaxProfitWithKTransactions;

// import java.util.*;

/**
 * * Max Profit With K Transactions
 */
class Program {
  /**
   * * Dynamic Programming Approach (Space optimized)
   *
   * * TC: O(nk)
   * * SC: O(n)
   */
  public static int maxProfitWithKTransactions(int[] prices, int k) {
    // Write your code here.
    int len = prices.length;
    int[] evenProfits = new int[len + 1], oddProfits = new int[len + 1];

    for (int i = 1; i < k + 1; i++) {
      int maxSoFar = Integer.MIN_VALUE;
      int[] currentProfits, previousProfits;

      currentProfits = i % 2 == 0 ? evenProfits : oddProfits;
      previousProfits = i % 2 == 0 ? oddProfits : evenProfits;

      for (int j = 1; j < len + 1; j++) {
        maxSoFar = Math.max(maxSoFar, previousProfits[j - 1] - prices[j - 1]);
        currentProfits[j] = Math.max(maxSoFar + prices[j - 1], currentProfits[j - 1]);
      }
    }

    return k % 2 == 0 ? evenProfits[len] : oddProfits[len];
  }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(nk)
   * * SC: O(nk)
   */
  // public static int maxProfitWithKTransactions(int[] prices, int k) {
  //   int len = prices.length;
  //   int[][] profits = new int[k + 1][len + 1];

  //   for (int i = 1; i < k + 1; i++) {
  //     int maxSoFar = Integer.MIN_VALUE;
  //     for (int j = 1; j < len + 1; j++) {
  //       maxSoFar = Math.max(maxSoFar, profits[i - 1][j - 1] - prices[j - 1]);
  //       profits[i][j] = Math.max(profits[i][j - 1], maxSoFar + prices[j - 1]);
  //     }
  //   }

  //   return profits[k][len];
  // }
}

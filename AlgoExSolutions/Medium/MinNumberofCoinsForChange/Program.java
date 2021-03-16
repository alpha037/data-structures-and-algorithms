package AlgoExSolutions.Medium.MinNumberofCoinsForChange;

import java.util.*;

/**
 * * Min Number Of Coins For Change
 */
class Program {
  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    // Write your code here.
    int[] minCoinsRequired = new int[n + 1];
    Arrays.fill(minCoinsRequired, Integer.MAX_VALUE);

    minCoinsRequired[0] = 0;
    int minCoins = 0;

    for (int denom : denoms) {
      for (int target = 0; target <= n; target++) {
        if (target < denom) continue;

        minCoins =
            minCoinsRequired[target - denom] == Integer.MAX_VALUE
                ? Integer.MAX_VALUE
                : 1 + minCoinsRequired[target - denom];

        minCoinsRequired[target] = Math.min(minCoinsRequired[target], minCoins);
      }
    }

    return minCoinsRequired[n] != Integer.MAX_VALUE ? minCoinsRequired[n] : -1;
  }
}

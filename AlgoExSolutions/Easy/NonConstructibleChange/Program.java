package AlgoExSolutions.Easy.NonConstructibleChange;

import java.util.*;

/**
 * * Non-Constructible Change
 */
class Program {

  public int nonConstructibleChange(int[] coins) {
    // Write your code here.
    if (coins == null || coins.length == 0) return 1;

    Arrays.sort(coins);

    int currentChange = 0;

    for (int coin : coins) {
      if (coin > currentChange + 1) return currentChange + 1;

      currentChange += coin;
    }

    return currentChange + 1;
  }
}

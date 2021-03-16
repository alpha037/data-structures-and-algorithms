package AlgoExSolutions.Medium.NumberofWaysToMakeChange;

import java.util.*;

/**
 * * Number Of Ways To Make Change
 */
class Program {
  public static int numberOfWaysToMakeChange(int n, int[] denoms) {
    // Write your code here.
    int[] numberOfWays = new int[n + 1];
    Arrays.fill(numberOfWays, 0);
    numberOfWays[0] = 1;

    for (int denom : denoms) {
      for (int target = 1; target <= n; target++) {
        if (target >= denom) numberOfWays[target] += numberOfWays[target - denom];
      }
    }

    return numberOfWays[n];
  }
}

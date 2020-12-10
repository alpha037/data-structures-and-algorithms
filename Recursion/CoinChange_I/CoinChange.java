package Recursion.CoinChange_I;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinChange {

  /**
   * * CoinChange_I:
   * This is the first variation of the Coin Change Problem.
   * In this variation, you're asked to return the minimum
   * number of coins needed to make the change amount.
   */

  // ? Efficient solution, as it uses DP
  // ? to store the previously calculated results

  private static int minCoinsRequired(
      int target, List<Integer> coins, Map<Integer, Integer> results) {

    int minimumCoins = target;

    // * Base case
    if (coins.contains(target)) {
      results.put(target, 1);
      return 1;
    } else if (results.containsKey(target) && results.get(target) > 0) return results.get(target);
    else
      for (Integer coin : coins)
        if (coin <= target) {
          int numberOfCoins = 1 + minCoinsRequired(target - coin, coins, results);

          if (numberOfCoins < minimumCoins) {
            minimumCoins = numberOfCoins;
            results.put(target, minimumCoins);
          }
        }

    return minimumCoins;
  }

  public static int minCoinsRequired(int target, List<Integer> coins) {

    /**
     * ? Works only for American-Style coins.
     * ? WON'T work with odd/prime coin values.
     *
     * ! Inefficient, as it constantly makes a lot
     * ! of similar recursive calls.
     */
    // int minimumCoins = target;

    // *  Base Case
    // if (coins.contains(target))
    //   return 1;

    // for (Integer coin : coins)
    //   if (coin <= target) {

    //     int numberOfCoins = 1 + minCoinsRequired(target - coin, coins);
    //     minimumCoins = Math.min(numberOfCoins, minimumCoins);
    //   }

    // return minimumCoins;

    return minCoinsRequired(target, coins, new HashMap<>());
  }
}

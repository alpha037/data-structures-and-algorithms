package DynamicProgramming.KnapsackProblem;

// import java.util.*;

/**
 * * 0/1 Knapsack Problem
 */
public class Solution {
  public int knapsackProblem(int[][] items, int capacity) {
    // return knapsackProblemRec(items.length - 1, items, capacity);

    // int[][] cache = new int[items.length + 1][capacity + 1];
    // for (int[] row : cache) Arrays.fill(row, Integer.MIN_VALUE);

    // return knapsackProblemMem(items.length, items, capacity, cache);

    return knapsackProblemDP(items, capacity);
  }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(nc)
   * * SC: O(nc)
   */
  private int knapsackProblemDP(int[][] items, int capacity) {
    int len = items.length;
    int[][] knapsack = new int[len + 1][capacity + 1];

    for (int i = 0; i < len + 1; i++) {
      for (int j = 0; j < capacity + 1; j++) {
        if (i == 0 || j == 0) knapsack[i][j] = 0;
      }
    }

    for (int i = 1; i < len + 1; i++) {
      for (int j = 1; j < capacity + 1; j++) {
        int currentCapacity = j, valWithoutCurrentItem = knapsack[i - 1][currentCapacity];

        if (items[i - 1][1] <= currentCapacity) {
          int valWithCurrentItem =
              items[i - 1][0] + knapsack[i - 1][currentCapacity - items[i - 1][1]];
          knapsack[i][j] = Math.max(valWithCurrentItem, valWithoutCurrentItem);
        } else knapsack[i][j] = valWithoutCurrentItem;
      }
    }

    return knapsack[len][capacity];
  }

  /**
   * * Memoization Approach
   *
   * * TC: O(nc)
   * * SC: O(nc)
   */
  // private int knapsackProblemMem(int index, int[][] items, int capacity, int[][] cache) {
  //   if (index == 0 || capacity == 0) return 0;

  //   if (cache[index][capacity] != Integer.MIN_VALUE) return cache[index][capacity];

  //   if (items[index - 1][1] <= capacity)
  //     return cache[index][capacity] =
  //         Math.max(
  //             items[index - 1][0]
  //                 + knapsackProblemMem(index - 1, items, capacity - items[index - 1][1], cache),
  //             knapsackProblemMem(index - 1, items, capacity, cache));

  //   return cache[index][capacity] = knapsackProblemMem(index - 1, items, capacity, cache);
  // }

  /**
   * * Recursive Approach
   *
   * * TC: O(2^n)
   * * SC: O(2^n)
   */
  // private int knapsackProblemRec(int index, int[][] items, int capacity) {
  //   if (index == 0 || capacity == 0) return 0;

  //   if (items[index][1] <= capacity)
  //     return Math.max(
  //         items[index][0] + knapsackProblemRec(index - 1, items, capacity - items[index][1]),
  //         knapsackProblemRec(index - 1, items, capacity));

  //   return knapsackProblemRec(index - 1, items, capacity);
  // }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] items =
        new int[][] {
          {60, 10},
          {100, 20},
          {120, 30},
        };

    // should be 220
    System.out.println(solution.knapsackProblem(items, 50));
  }
}

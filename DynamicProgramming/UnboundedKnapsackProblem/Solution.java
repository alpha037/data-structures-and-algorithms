package DynamicProgramming.UnboundedKnapsackProblem;

// import java.util.Arrays;

/**
 * * Unbounded Knapsack Problem
 */
public class Solution {
  public int unboundedKnapsackProblem(int[][] items, int capacity) {
    // return unboundedKnapsackProblemRec(items.length, items, capacity);

    // int[][] cache = new int[items.length + 1][capacity + 1];
    // for (int[] row : cache) Arrays.fill(row, Integer.MIN_VALUE);

    // return unboundedKnapsackProblemMem(items.length, items, capacity, cache);

    // return unboundedKnapsackProblemDP(items, capacity);

    return unboundedKnapsackProblemDPSpaceOpt(items, capacity);
  }

  /**
   * * Dynamic Programming Approach (Space Optimized)
   *
   * * TC: O(nc)
   * * SC: O(c)
   */
  private int unboundedKnapsackProblemDPSpaceOpt(int[][] items, int capacity) {
    int[] knapsack = new int[capacity + 1];

    for (int i = 0; i < capacity + 1; i++) {
      for (int j = 0; j < items.length; j++) {
        if (items[j][1] <= i)
          knapsack[i] = Math.max(knapsack[i], items[j][0] + knapsack[i - items[j][1]]);
      }
    }

    return knapsack[capacity];
  }

  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(nc)
   * * SC: O(nc)
   */
  // private int unboundedKnapsackProblemDP(int[][] items, int capacity) {
  //   int len = items.length;
  //   int[][] knapsack = new int[len + 1][capacity + 1];

  //   for (int i = 1; i < len + 1; i++) {
  //     for (int j = 1; j < capacity + 1; j++) {
  //       int currentCapacity = j;
  //       int valWithoutCurrentItem = knapsack[i - 1][currentCapacity];

  //       if (items[i - 1][1] <= currentCapacity) {
  //         int valWithCurrentItem = items[i - 1][0] + knapsack[i][currentCapacity - items[i -
  // 1][1]];
  //         knapsack[i][j] = Math.max(valWithCurrentItem, knapsack[i][j]);
  //       }
  //       else knapsack[i][j] = valWithoutCurrentItem;
  //     }
  //   }

  //   return knapsack[len][capacity];
  // }

  /**
   * * Memoization Approach
   *
   * * TC: O(nc)
   * * SC: O(nc)
   */
  // private int unboundedKnapsackProblemMem(int index, int[][] items, int capacity, int[][] cache)
  // {
  //   if (index == 0 || capacity == 0) return 0;

  //   if (cache[index][capacity] != Integer.MIN_VALUE)
  //     return cache[index][capacity];

  //   if (items[index - 1][1] <= capacity) {
  //     return cache[index][capacity] = Math.max(
  //       items[index - 1][0] + unboundedKnapsackProblemMem(index, items, capacity - items[index -
  // 1][1], cache),
  //       unboundedKnapsackProblemMem(index - 1, items, capacity, cache)
  //     );
  //   }

  //   return cache[index][capacity] = unboundedKnapsackProblemMem(index - 1, items, capacity,
  // cache);
  // }

  /**
   * * Recursive Approach
   *
   * * TC: O(2^n) approximately
   * * SC: O(2^n) approximately
   */
  // private int unboundedKnapsackProblemRec(int index, int[][] items, int capacity) {
  //   if (index == 0 || capacity == 0) return 0;

  //   if (items[index - 1][1] <= capacity) {
  //     return Math.max(
  //       items[index - 1][0] + unboundedKnapsackProblemRec(index, items, capacity - items[index -
  // 1][1]),
  //       unboundedKnapsackProblemRec(index - 1, items, capacity)
  //     );
  //   }

  //   return unboundedKnapsackProblemRec(index - 1, items, capacity);
  // }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] items =
        new int[][] {
          {1, 1},
          {30, 50}
        };

    // should be 100
    System.out.println(solution.unboundedKnapsackProblem(items, 100));
  }
}

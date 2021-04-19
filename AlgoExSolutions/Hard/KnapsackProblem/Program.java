package AlgoExSolutions.Hard.KnapsackProblem;

import java.util.*;

/**
 * * Knapsack Problem
 */
class Program {
  /**
   * * Dynamic Programming Approach
   *
   * * TC: O(nc)
   * * SC: O(nc)
   */
  public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
    // Write your code here.
    int len = items.length;
    int[][] knapsack = new int[len + 1][capacity + 1];

    for (int i = 0; i < len + 1; i++) {
      for (int j = 0; j < capacity + 1; j++) {
        if (i == 0 || j == 0) knapsack[i][j] = 0;
      }
    }

    for (int i = 1; i < len + 1; i++) {
      for (int j = 1; j < capacity + 1; j++) {
        int itemCapacity = items[i - 1][1], currentCapacity = j;
        int valWithoutCurrentItem = knapsack[i - 1][j];

        if (itemCapacity <= currentCapacity) {
          int valWithCurrentItem = items[i - 1][0] + knapsack[i - 1][j - itemCapacity];
          knapsack[i][j] = Math.max(valWithCurrentItem, valWithoutCurrentItem);
        } else knapsack[i][j] = valWithoutCurrentItem;
      }
    }

    return buildResult(knapsack, items);
  }

  private static List<List<Integer>> buildResult(int[][] knapsack, int[][] items) {
    List<List<Integer>> result = new ArrayList<>();
    int len = knapsack.length - 1, capacity = knapsack[0].length - 1;

    result.add(List.of(knapsack[len][capacity]));
    result.add(new ArrayList<>());

    while (len > 0) {
      // This means that we haven't
      // considered the current item
      // while building out solution,
      // so we move to the previous
      // row. Check Line 30 and 37
      if (knapsack[len][capacity] == knapsack[len - 1][capacity]) --len;

      // Otherwise, we consider the
      // current item and we subtract
      // the item capacity from the
      // current capacity and move to
      // the previous row.
      else {
        result.get(1).add(0, len - 1);
        capacity -= items[len - 1][1];
        --len;

        if (capacity == 0) break;
      }
    }

    return result;
  }

  /**
   * * Recursive Approach
   *
   * * TC: O(2^n)
   * * SC: O(2^n)
   */
  // public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
  // 	List<List<Integer>> output = new ArrayList<List<Integer>>();
  // 	List<List<Integer>> sack = new ArrayList<List<Integer>>();

  // 	output.add(List.of(0));
  // 	output.add(new ArrayList<>());
  // 	sack.add(List.of(0));
  // 	sack.add(new ArrayList<>());

  // 	knapsackProblem(0, items, capacity, output, sack);

  // 	return sack;
  // }

  // private static void knapsackProblem(
  // 	int index, int[][] items, int capacity,
  // 	List<List<Integer>> output, List<List<Integer>> sack
  // ) {
  // 	if (index == items.length || capacity == 0) {
  // 		int currValue = output.get(0).get(0), sackValue = sack.get(0).get(0);
  // 		if (currValue > sackValue) {
  // 			sack.set(0, List.of(currValue));
  // 			sack.set(1, new ArrayList<>(output.get(1)));
  // 		}
  // 		return;
  // 	}

  // 	if (capacity >= items[index][1]) {
  // 		int currentValue = output.get(0).get(0);
  // 		int updatedValue = currentValue + items[index][0];
  // 		output.set(0, List.of(updatedValue));
  // 		output.get(1).add(index);

  // 		knapsackProblem(index + 1, items, capacity - items[index][1], output, sack);

  // 		output.set(0, List.of(currentValue));
  // 		output.get(1).remove(output.get(1).size() - 1);

  // 		knapsackProblem(index + 1, items, capacity, output, sack);
  // 	}
  // 	else knapsackProblem(index + 1, items, capacity, output, sack);
  // }
}

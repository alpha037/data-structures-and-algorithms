package Recursion.SortArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * * Sort an Array using Recursion
 */
public class Solution {
  private void insert(List<Integer> array, int element) {
    /**
     * Base Case.
     */
    if (array.size() == 0 || array.get(array.size() - 1) <= element) {
      array.add(element);
      return;
    }

    int lastValue = array.get(array.size() - 1);

    array.remove(array.size() - 1);
    insert(array, element);

    array.add(lastValue);
  }

  public void sort(List<Integer> array) {
    /**
     * Base Case.
     *
     * This means that the array
     * is already sorted.
     */
    if (array.size() == 1) return;

    int lastValue = array.get(array.size() - 1);

    array.remove(array.size() - 1);
    sort(array);

    insert(array, lastValue);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    List<Integer> array = new ArrayList<>(Arrays.asList(-1, 5, 4, 8, 6, 10, 8));

    solution.sort(array);

    for (int value : array) System.out.print(value + " ");
  }
}

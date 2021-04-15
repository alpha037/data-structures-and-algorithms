package AlgoExSolutions.Medium.SortStack;

import java.util.*;

/**
 * * Sort Stack
 */
class Program {

  /**
   * * TC: O(n^2)
   * * SC: O(n)
   */
  public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
    // Write your code here.
    if (stack.isEmpty()) return stack;

    sort(stack);
    return stack;
  }

  private void sort(ArrayList<Integer> stack) {
    if (stack.size() == 1) return;

    int poppedValue = stack.remove(stack.size() - 1);

    sort(stack);

    insert(stack, poppedValue);
  }

  private void insert(ArrayList<Integer> stack, int value) {
    if (stack.isEmpty() || stack.get(stack.size() - 1) <= value) {
      stack.add(value);
      return;
    }

    int poppedValue = stack.remove(stack.size() - 1);

    insert(stack, value);

    stack.add(poppedValue);
  }
}

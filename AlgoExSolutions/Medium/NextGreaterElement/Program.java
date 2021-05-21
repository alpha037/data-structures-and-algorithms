package AlgoExSolutions.Medium.NextGreaterElement;

import java.util.*;

/**
 * * Next Greater Element
 */
class Program {
  /**
   * * TC: O(n)
   * * SC: O(n)
   */
  public int[] nextGreaterElement(int[] array) {
    // Write your code here.
    int len = array.length;
    Stack<Integer> stack = new Stack<>();
    int[] res = new int[len];
    Arrays.fill(res, -1);

    for (int i = 0; i < 2 * len; i++) {
      int idx = i % len;

      while (!stack.isEmpty() && array[idx] > array[stack.peek()]) res[stack.pop()] = array[idx];

      stack.push(idx);
      ++idx;
    }

    return res;
  }
}

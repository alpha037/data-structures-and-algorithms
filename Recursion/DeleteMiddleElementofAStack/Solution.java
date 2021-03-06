package Recursion.DeleteMiddleElementofAStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * * Remove Kth (Middle, in this case) Element From Stack
 */
public class Solution {
  public void remove(Stack<Integer> stack, int k) {
    /**
     * Edge Case.
     */
    if (stack.isEmpty()) return;

    /**
     * Base Case.
     *
     * This means that we've
     * found out the element
     * that needs to be deleted.
     */
    if (k == 1) {
      stack.pop();
      return;
    }

    int top = stack.pop();

    remove(stack, k - 1);

    stack.push(top);
  }

  public void print(Stack<Integer> stack) {
    if (stack.isEmpty()) return;

    int item = stack.pop();

    print(stack);
    System.out.print(item + " ");

    stack.push(item);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    Stack<Integer> stack = new Stack<>();
    stack.addAll(Arrays.asList(5, 4, 3, 8, 1));

    int mid = stack.size() / 2 + 1;

    solution.remove(stack, mid);

    solution.print(stack);
  }
}

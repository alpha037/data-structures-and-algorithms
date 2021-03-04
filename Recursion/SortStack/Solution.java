package Recursion.SortStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * * Sort a Stack using Recursion
 */
public class Solution {
  private void insert(Stack<Integer> stack, int item) {
    /**
     * Base Case
     */
    if (stack.isEmpty() || stack.peek() <= item) {
      stack.push(item);
      return;
    }

    int topValue = stack.pop();

    insert(stack, item);

    stack.push(topValue);
  }

  public void sort(Stack<Integer> stack) {
    /**
     * Base Case
     *
     * This means that the
     * stack is already sorted.
     */
    if (stack.size() == 1) return;

    int topValue = stack.pop();

    sort(stack);

    insert(stack, topValue);
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
    stack.addAll(Arrays.asList(-1, 5, 4, 8, 6, 10, 8));

    solution.sort(stack);
    solution.print(stack);
  }
}

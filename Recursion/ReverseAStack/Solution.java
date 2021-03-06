package Recursion.ReverseAStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * * Reverse A Stack Using Recursion
 */
public class Solution {
  private void insert(Stack<Integer> stack, int element) {
    /**
     * Base Case.
     *
     * If the stack is empty,
     * then we can just insert
     * the element right away
     * in the stack.
     */
    if (stack.isEmpty()) {
      stack.push(element);
      return;
    }

    int top = stack.pop();

    insert(stack, element);

    stack.push(top);
  }

  public void reverse(Stack<Integer> stack) {
    /**
     * Base Case.
     *
     * If the stack has only
     * 1 element, this means
     * that the stack is already
     * reversed.
     */
    if (stack.size() == 1) return;

    int top = stack.pop();

    reverse(stack);

    insert(stack, top);
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

    solution.reverse(stack);

    solution.print(stack);
  }
}

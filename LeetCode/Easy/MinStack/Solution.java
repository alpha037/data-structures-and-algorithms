package LeetCode.Easy.MinStack;

/**
 * Solution class for testing only
 */
public class Solution {
  public static void main(String[] args) {
    MinStack minStack = new MinStack();

    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);

    System.out.println(minStack.getMin()); // returns -3
    minStack.pop();
    System.out.println(minStack.top()); // returns 0
    System.out.println(minStack.getMin()); // returns -2
  }
}

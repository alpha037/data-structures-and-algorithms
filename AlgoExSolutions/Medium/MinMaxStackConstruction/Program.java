package AlgoExSolutions.Medium.MinMaxStackConstruction;

import java.util.*;

/**
 * * Min Max Stack Construction
 */
class Program {
  // Feel free to add new properties and methods to the class.
  static class Pair {
    int value;
    int min;
    int max;

    public Pair(int value, int min, int max) {
      this.value = value;
      this.min = min;
      this.max = max;
    }
  }

  static class MinMaxStack {
    Stack<Pair> stack = new Stack<>();

    public int peek() {
      // Write your code here.
      return stack.peek() != null ? stack.peek().value : -1;
    }

    public int pop() {
      // Write your code here.
      return stack.peek() != null ? stack.pop().value : -1;
    }

    public void push(Integer number) {
      // Write your code here.
      if (stack.isEmpty()) {
        stack.push(new Pair(number, number, number));
        return;
      }

      int minValue = getMin();
      if (minValue != -1) minValue = Math.min(minValue, number);

      int maxValue = getMax();
      if (maxValue != -1) maxValue = Math.max(maxValue, number);

      stack.push(new Pair(number, minValue, maxValue));
    }

    public int getMin() {
      // Write your code here.
      return stack.peek() != null ? stack.peek().min : -1;
    }

    public int getMax() {
      // Write your code here.
      return stack.peek() != null ? stack.peek().max : -1;
    }
  }
}

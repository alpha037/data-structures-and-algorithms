package StacksAndQueues.BalancedParenthesesCheck;

import java.util.Stack;

public class BalancedParenthesesCheck {
  public static boolean isBalanced(String string) {

    // * Edge Cases
    if (string == null || string.length() % 2 != 0) return false;

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < string.length(); i++) {
      char c = string.charAt(i);

      if (c == '(' || c == '{' || c == '[') stack.push(c);

      if (stack.isEmpty()) return false;

      char popped;
      switch (c) {
        case ')':
          popped = stack.pop();
          if (popped != '(') return false;
          break;

        case '}':
          popped = stack.pop();
          if (popped != '{') return false;
          break;

        case ']':
          popped = stack.pop();
          if (popped != '[') return false;
          break;

        default:
          break;
      }
    }

    return stack.isEmpty();
  }
}

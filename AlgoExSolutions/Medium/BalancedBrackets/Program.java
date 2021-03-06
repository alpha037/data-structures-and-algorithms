package AlgoExSolutions.Medium.BalancedBrackets;

import java.util.*;

/**
 * * Balanced Brackets
 */
class Program {
  private static boolean isValidBracket(char character) {
    switch (character) {
      case '(':
      case '{':
      case '[':
      case ')':
      case '}':
      case ']':
        return true;

      default:
        return false;
    }
  }

  public static boolean balancedBrackets(String str) {
    // Write your code here.
    Stack<Character> stack = new Stack<>();

    for (char character : str.toCharArray()) {
      if (!isValidBracket(character)) continue;

      switch (character) {
        case ')':
        case '}':
        case ']':
          if (stack.isEmpty() || stack.pop() != character) return false;
          break;

        case '(':
          stack.push(')');
          break;

        case '{':
          stack.push('}');
          break;

        case '[':
          stack.push(']');
          break;

        default:
          break;
      }
    }

    return stack.isEmpty();
  }
}

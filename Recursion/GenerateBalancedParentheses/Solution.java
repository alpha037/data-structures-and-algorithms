package Recursion.GenerateBalancedParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * * Generate Valid Parentheses
 */
public class Solution {
  private void generateValidParentheses(
      int open, int close, StringBuilder current, List<String> parentheses) {
    if (open == 0 && close == 0) {
      parentheses.add(current.toString());
      return;
    }

    if (open > 0) {
      current.append("(");
      generateValidParentheses(open - 1, close, current, parentheses);
      current.deleteCharAt(current.length() - 1);
    }

    if (close > open) {
      current.append(")");
      generateValidParentheses(open, close - 1, current, parentheses);
      current.deleteCharAt(current.length() - 1);
    }
  }

  public List<String> generateValidParentheses(int n) {
    List<String> parentheses = new ArrayList<>();

    generateValidParentheses(n, n, new StringBuilder(""), parentheses);

    return parentheses;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.generateValidParentheses(3));
  }
}

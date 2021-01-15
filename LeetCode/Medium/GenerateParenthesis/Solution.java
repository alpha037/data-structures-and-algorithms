package LeetCode.Medium.GenerateParenthesis;

import java.util.ArrayList;
import java.util.List;

/*
  22. Generate Parentheses

  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.


  Example 1:
  Input: n = 3
  Output: ["((()))","(()())","(())()","()(())","()()()"]

  Example 2:
  Input: n = 1
  Output: ["()"]

  Constraints:
  1 <= n <= 8
*/

public class Solution {
  private List<String> generateParenthesis(
      List<String> res, StringBuilder current, int open, int close, int len) {
    // If the current string length
    // is equal to 2 * len, then we
    // can add the string to our list
    // as we have to generate len pairs
    // of opening and closing parenthesis
    if (current.length() == 2 * len) {
      res.add(current.toString());
      return res;
    }

    // If the number of opening
    // parenthesis is less than
    // len, then we can add an
    // opening parenthesis
    if (open < len) {
      generateParenthesis(res, current.append("("), open + 1, close, len);

      // Remove the last character to
      // get back the previous string
      current.deleteCharAt(current.length() - 1);
    }

    // If the number of closing
    // parenthesis is less than
    // open, then we can add a
    // closing parenthesis
    if (close < open) {
      generateParenthesis(res, current.append(")"), open, close + 1, len);

      // Remove the last character to
      // get back the previous string
      current.deleteCharAt(current.length() - 1);
    }

    return res;
  }

  public List<String> generateParenthesis(int n) {
    if (n == 0) List.of();

    return generateParenthesis(new ArrayList<>(), new StringBuilder(), 0, 0, n);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be ["((()))","(()())","(())()","()(())","()()()"]
    System.out.println(solution.generateParenthesis(3).toString());

    // should be ["()"]
    System.out.println(solution.generateParenthesis(1).toString());
  }
}

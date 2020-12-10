package StacksAndQueues.BalancedParenthesesCheck;

public class BalancedParenthesesCheckTest {
  public static void main(String[] args) {

    // should be true
    System.out.println(BalancedParenthesesCheck.isBalanced("[](){([[[]]])}"));

    // should be true
    System.out.println(BalancedParenthesesCheck.isBalanced("[]"));

    // should be false
    System.out.println(BalancedParenthesesCheck.isBalanced("()(){]}"));

    // should be false
    System.out.println(BalancedParenthesesCheck.isBalanced("[](){([[[]]])}("));

    // should be true
    System.out.println(BalancedParenthesesCheck.isBalanced("[{{{(())}}}]((()))"));

    // should be false
    System.out.println(BalancedParenthesesCheck.isBalanced("[[[]])]"));
  }
}

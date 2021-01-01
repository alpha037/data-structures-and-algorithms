package LeetCode.Easy.FactorialTrailingZeroes;

/*
  172. Factorial Trailing Zeroes

  Given an integer n, return the number of trailing zeroes in n!.

  Follow up: Could you write a solution that works in logarithmic time complexity?


  Example 1:
  Input: n = 3
  Output: 0
  Explanation: 3! = 6, no trailing zero.

  Example 2:
  Input: n = 5
  Output: 1
  Explanation: 5! = 120, one trailing zero.

  Example 3:
  Input: n = 0
  Output: 0


  Constraints:
  0 <= n <= 104
*/

public class Solution {
  public int trailingZeroes(int n) {
    if (n == 0) return 0;

    int count = 0;

    for (int i = 5; n / i >= 1; i *= 5) count += Math.floor(n / i);

    return count;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 0
    System.out.println(solution.trailingZeroes(3));

    // should be 1
    System.out.println(solution.trailingZeroes(5));

    // should be 0
    System.out.println(solution.trailingZeroes(0));

    // should be 7
    System.out.println(solution.trailingZeroes(30));
  }
}

package LeetCode.Easy.ReverseInteger;

/*
  7. Reverse Integer

  Given a 32-bit signed integer, reverse digits of an integer.

  Note:
  Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

  Example 1:
  Input: x = 123
  Output: 321

  Example 2:
  Input: x = -123
  Output: -321

  Example 3:
  Input: x = 120
  Output: 21

  Example 4:
  Input: x = 0
  Output: 0

  Constraints:
  -231 <= x <= 231 - 1
*/

public class Solution {
  public int reverse(int x) {
    if (x < 10 && x >= 0) return x;

    boolean isNegative = false;

    if (x < 0) {
      isNegative = true;
      x = -x;
    }

    int sum = 0, previousSum = 0;
    while (x > 0) {
      int digit = x % 10;
      sum = (sum * 10) + digit;

      // Case to handle integer overflow
      if ((sum - digit) / 10 != previousSum) return 0;

      previousSum = sum;
      x /= 10;
    }

    if (isNegative) return -sum;

    return sum;
  }

  public static void main(String[] args) {

    Solution solution = new Solution();

    // should be 321
    System.out.println(solution.reverse(123));

    // should be -321
    System.out.println(solution.reverse(-123));

    // should be 21
    System.out.println(solution.reverse(120));

    // should be 0
    System.out.println(solution.reverse(0));
  }
}

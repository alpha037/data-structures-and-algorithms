package LeetCode.Medium.DivideTwoIntegers;

/*
  29. Divide Two Integers

  Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

  Return the quotient after dividing dividend by divisor.

  The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

  Note:
  Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.


  Example 1:
  Input: dividend = 10, divisor = 3
  Output: 3
  Explanation: 10/3 = truncate(3.33333..) = 3.

  Example 2:
  Input: dividend = 7, divisor = -3
  Output: -2
  Explanation: 7/-3 = truncate(-2.33333..) = -2.

  Example 3:
  Input: dividend = 0, divisor = 1
  Output: 0

  Example 4:
  Input: dividend = 1, divisor = 1
  Output: 1


  Constraints:
  -2^31 <= dividend, divisor <= 2^31 - 1
  divisor != 0
*/

public class Solution {
  public int divide(int dividend, int divisor) {

    // Check if the dividend is
    // equal to INT_MIN
    boolean isDividendMin = false;

    if (dividend == Integer.MIN_VALUE)
      if (divisor == -1) return Integer.MAX_VALUE;
      else if (divisor == 1) return Integer.MIN_VALUE;
      else isDividendMin = true;

    // If the divisor is also equal
    // to INT_MIN, return 1 / 0
    if (divisor == Integer.MIN_VALUE) return isDividendMin ? 1 : 0;

    // Check if any of the numbers are negative
    boolean isNegative = dividend < 0 ^ divisor < 0;
    int n = 1, newDividend = 1;

    // Make them positive
    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);

    // Count the number of bits in the dividend
    while (newDividend < dividend && newDividend != Integer.MIN_VALUE) {
      newDividend <<= 1;
      ++n;
    }

    int quotient = 0, remainder = 0;

    // If the dividend is
    // INT_MIN, handle
    // accordingly
    if (isDividendMin) {
      n = 31;
      remainder = 1;
    }

    // Perform binary division
    // upto n bits of dividend
    for (n--; n >= 0; n--) {
      remainder <<= 1;
      remainder += (dividend >> n) & 1;

      if (remainder >= divisor || remainder == Integer.MIN_VALUE) {
        remainder -= divisor;
        quotient += 1 << n;
      }
    }

    return isNegative ? -quotient : quotient;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 3
    System.out.println(solution.divide(10, 3));

    // should be -2
    System.out.println(solution.divide(7, -3));

    // should be 0
    System.out.println(solution.divide(0, 1));

    // should be 1
    System.out.println(solution.divide(1, 1));

    // should be 2147483647
    System.out.println(solution.divide(-2147483648, -1));
  }
}

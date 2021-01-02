package LeetCode.Easy.HappyNumber;

// import java.util.HashSet;

/*
  202. Happy Number

  Write an algorithm to determine if a number n is happy.

  A happy number is a number defined by the following process:

  Starting with any positive integer, replace the number by the sum of the squares of its digits.
  Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
  Those numbers for which this process ends in 1 are happy.
  Return true if n is a happy number, and false if not.


  Example 1:
  Input: n = 19
  Output: true
  Explanation:
  12 + 92 = 82
  82 + 22 = 68
  62 + 82 = 100
  12 + 02 + 02 = 1

  Example 2:
  Input: n = 2
  Output: false


  Constraints:
  1 <= n <= 231 - 1
*/

public class Solution {
  private int squareOfDigits(int n) {
    int res = 0;

    while (n > 0) {
      res += (n % 10) * (n % 10);
      n /= 10;
    }

    return res;
  }

  public boolean isHappy(int n) {
    // Since, 1 and 7 are the
    // only happy numbers
    if (n == 1 || n == 7) return true;

    /**
     * * HashSet approach
     */

    // We can use a set to keep
    // track of all the computed
    // values, because, if a
    // computed value is not 1,
    // then it's bound to have the
    // same value as a previously
    // computed value.

    // HashSet<Integer> visited = new HashSet<>();
    // while (true) {
    //   n = squareOfDigits(n);

    //   if (n == 1)
    //     return true;

    //   if (visited.contains(n))
    //     return false;

    //   visited.add(n);
    // }

    /**
     * * Floyd's Cycle-Finding approach
     */
    int fastTracker = n;
    int slowTracker = n;

    // The fastTracker and the
    // slowTracker are bound to
    // meet at 1, if and only if
    // n is a happy number.
    do {
      slowTracker = squareOfDigits(slowTracker);
      fastTracker = squareOfDigits(squareOfDigits(fastTracker));
    } while (fastTracker != slowTracker);

    return slowTracker == 1;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be true
    System.out.println(solution.isHappy(19));

    // should be false
    System.out.println(solution.isHappy(2));
  }
}

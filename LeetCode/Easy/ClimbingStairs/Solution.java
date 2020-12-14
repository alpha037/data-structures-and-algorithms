package LeetCode.Easy.ClimbingStairs;

/*
  70. Climbing Stairs

  You are climbing a staircase. It takes n steps to reach the top.

  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


  Example 1:
  Input: n = 2
  Output: 2
  Explanation: There are two ways to climb to the top.
  1. 1 step + 1 step
  2. 2 steps

  Example 2:
  Input: n = 3
  Output: 3
  Explanation: There are three ways to climb to the top.
  1. 1 step + 1 step + 1 step
  2. 1 step + 2 steps
  3. 2 steps + 1 step


  Constraints:
  1 <= n <= 45
*/

public class Solution {
  public int climbStairs(int n) {

    /**
     * * Bottom up approach
     */

    // In this case, we can find out
    // the current problem by solving
    // the previous two sub-problems
    // Therefore, we can further optimize
    // this to constant space of O(1) by
    // using just three variables
    int[] dp = new int[n + 1];
    dp[0] = dp[1] = 1;

    for (int i = 2; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];

    return dp[n];

    /**
     * * O(1) space approach
     */
    // if (n == 1) return 1;

    // int first = 1, second = 2;
    // for (int i=3; i<=n; i++) {
    //   int third = first + second;
    //   first = second;
    //   second = third;
    // }

    // return second;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 13
    System.out.println(solution.climbStairs(6));

    // should be 2
    System.out.println(solution.climbStairs(2));

    // should be 1836311903
    System.out.println(solution.climbStairs(45));
  }
}

package LeetCode.Medium.JumpGame;

/*
  55. Jump Game

  Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

  Each element in the array represents your maximum jump length at that position.

  Determine if you are able to reach the last index.


  Example 1:
  Input: nums = [2,3,1,1,4]
  Output: true
  Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

  Example 2:
  Input: nums = [3,2,1,0,4]
  Output: false
  Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


  Constraints:
  1 <= nums.length <= 3 * 104
  0 <= nums[i] <= 105
*/

public class Solution {
  public boolean canJump(int[] nums) {
    if (nums == null || nums.length <= 1) return true;

    if (nums[0] == 0) return false;

    int reachable = 0, lastIdx = nums.length - 1;

    for (int i = 0; i <= lastIdx; i++) {
      if (i > reachable) return false;

      reachable = Math.max(reachable, i + nums[i]);
    }

    return reachable >= lastIdx;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be true
    System.out.println(solution.canJump(new int[] {2, 3, 1, 1, 4}));

    // should be false
    System.out.println(solution.canJump(new int[] {3, 2, 1, 0, 4}));
  }
}

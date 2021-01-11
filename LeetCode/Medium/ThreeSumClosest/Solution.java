package LeetCode.Medium.ThreeSumClosest;

import java.util.Arrays;

/*
  16. 3Sum Closest

  Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.


  Example 1:
  Input: nums = [-1,2,1,-4], target = 1
  Output: 2
  Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


  Constraints:
  3 <= nums.length <= 10^3
  -10^3 <= nums[i] <= 10^3
  -10^4 <= target <= 10^4
*/

public class Solution {
  public int threeSumClosest(int[] nums, int target) {
    if (nums.length <= 2) return -1;

    int res = nums[0] + nums[1] + nums[nums.length - 1];
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      int j = i + 1, k = nums.length - 1;

      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];

        if (sum < target) ++j;
        else --k;

        if (Math.abs(sum - target) < Math.abs(res - target)) res = sum;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 2
    System.out.println(solution.threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
  }
}

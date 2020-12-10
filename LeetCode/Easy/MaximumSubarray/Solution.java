package LeetCode.Easy.MaximumSubarray;

/*
  53. Maximum Subarray

  Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

  Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.


  Example 1:
  Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
  Output: 6
  Explanation: [4,-1,2,1] has the largest sum = 6.

  Example 2:
  Input: nums = [1]
  Output: 1

  Example 3:
  Input: nums = [0]
  Output: 0

  Example 4:
  Input: nums = [-1]
  Output: -1

  Example 5:
  Input: nums = [-2147483647]
  Output: -2147483647

  Constraints:
  1 <= nums.length <= 2 * 104
  -231 <= nums[i] <= 231 - 1
*/

public class Solution {
  public int maxSubArray(int[] nums) {
    if (nums.length == 0) return 0;

    int maxSum = nums[0], currentSum = nums[0];

    // Kadane's Algorithm
    for (int i = 1; i < nums.length; ++i) {
      currentSum = Math.max(nums[i], currentSum + nums[i]);
      maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 6
    System.out.println(solution.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }
}

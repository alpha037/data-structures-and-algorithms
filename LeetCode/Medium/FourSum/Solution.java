package LeetCode.Medium.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  18. 4Sum

  Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

  Notice that the solution set must not contain duplicate quadruplets.


  Example 1:
  Input: nums = [1,0,-1,0,-2,2], target = 0
  Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

  Example 2:
  Input: nums = [], target = 0
  Output: []


  Constraints:
  0 <= nums.length <= 200
  -109 <= nums[i] <= 109
  -109 <= target <= 109
*/

public class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    if (nums == null || nums.length < 4) return List.of();

    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < nums.length - 3; i++) {
      if (i != 0 && nums[i] == nums[i - 1]) continue;

      for (int j = i + 1; j < nums.length - 2; j++) {
        if (j != i + 1 && nums[j] == nums[j - 1]) continue;

        int left = j + 1, right = nums.length - 1;

        while (left < right) {
          int sum = nums[i] + nums[j] + nums[left] + nums[right];

          if (sum > target) --right;
          else if (sum < target) ++left;
          else {
            res.add(List.of(nums[i], nums[j], nums[left++], nums[right--]));

            while (left < right && nums[left] == nums[left - 1]) ++left;

            while (right > left && nums[right] == nums[right + 1]) --right;
          }
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be "[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]"
    System.err.println(solution.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0).toString());

    // should be "[]"
    System.err.println(solution.fourSum(new int[] {}, 0).toString());
  }
}

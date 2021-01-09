package LeetCode.Medium.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  15. 3Sum

  Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

  Notice that the solution set must not contain duplicate triplets.


  Example 1:
  Input: nums = [-1,0,1,2,-1,-4]
  Output: [[-1,-1,2],[-1,0,1]]

  Example 2:
  Input: nums = []
  Output: []

  Example 3:
  Input: nums = [0]
  Output: []


  Constraints:
  0 <= nums.length <= 3000
  -105 <= nums[i] <= 105
*/

public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    if (nums.length <= 2) return List.of();

    List<List<Integer>> lists = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++)
      // Only unique elements
      if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
        int j = i + 1, k = nums.length - 1;

        // Since el1 + el2 + (-el3) = 0
        int sum = -nums[i];

        while (j < k) {
          if (nums[j] + nums[k] > sum) --k;
          else if (nums[j] + nums[k] < sum) ++j;
          else {
            lists.add(List.of(nums[i], nums[j++], nums[k--]));

            // Check for unique elements
            while (j < k && nums[j] == nums[j - 1]) ++j;

            while (j < k && nums[k] == nums[k + 1]) --k;
          }
        }
      }

    return lists;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be [[-1,-1,2],[-1,0,1]]
    System.out.println(solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4}).toString());

    // should be []
    System.out.println(solution.threeSum(new int[] {}).toString());

    // should be []
    System.out.println(solution.threeSum(new int[] {0}).toString());
  }
}

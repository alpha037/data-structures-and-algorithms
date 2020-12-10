package LeetCode.Easy.TwoSum;

import java.util.HashMap;
import java.util.Map;

/*
 1. Two Sum

 Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 You can return the answer in any order.


 Example 1:
 Input: nums = [2,7,11,15], target = 9
 Output: [0,1]
 Output: Because nums[0] + nums[1] == 9, we return [0, 1].

 Example 2:
 Input: nums = [3,2,4], target = 6
 Output: [1,2]

 Example 3:
 Input: nums = [3,3], target = 6
 Output: [0,1]


 Constraints:
 2 <= nums.length <= 103
 -109 <= nums[i] <= 109
 -109 <= target <= 109
 Only one valid answer exists.
*/

public class Solution {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int res = target - nums[i];

      if (map.containsKey(res) && i != map.get(res)) return new int[] {map.get(res), i};
      else map.put(nums[i], i);
    }

    return null;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] res = new int[2];

    // should be [0, 1]
    res = solution.twoSum(new int[] {2, 7, 11, 15}, 9);
    System.out.println(res[0] + " " + res[1]);

    // should be [0, 1]
    res = solution.twoSum(new int[] {3, 3}, 6);
    System.out.println(res[0] + " " + res[1]);

    // should be [1, 2]
    res = solution.twoSum(new int[] {3, 2, 4}, 6);
    System.out.println(res[0] + " " + res[1]);
  }
}

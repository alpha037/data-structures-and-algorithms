package LeetCode.Easy.ContainsDuplicate_II;

import java.util.HashMap;

/*
  219. Contains Duplicate II

  Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

  Example 1:
  Input: nums = [1,2,3,1], k = 3
  Output: true

  Example 2:
  Input: nums = [1,0,1,1], k = 1
  Output: true

  Example 3:
  Input: nums = [1,2,3,1,2,3], k = 2
  Output: false
*/

public class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    if (nums.length <= 1) return false;

    /**
     * * Hashmap approach
     * * TC: O(n), SC: O(n)
     */
    HashMap<Integer, Integer> visited = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (visited.containsKey(nums[i]) && Math.abs(i - visited.get(nums[i])) <= k) return true;

      visited.put(nums[i], i);
    }

    return false;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be true
    System.out.println(solution.containsNearbyDuplicate(new int[] {1, 2, 3, 1}, 3));

    // should be true
    System.out.println(solution.containsNearbyDuplicate(new int[] {1, 0, 1, 1}, 1));

    // should be false
    System.out.println(solution.containsNearbyDuplicate(new int[] {1, 2, 3, 1, 2, 3}, 2));
  }
}

package LeetCode.Medium.FirstAndLastPositionOfElementInSortedArray;

/*
  34. Find First and Last Position of Element in Sorted Array

  Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

  If target is not found in the array, return [-1, -1].

  Follow up: Could you write an algorithm with O(log n) runtime complexity?


  Example 1:
  Input: nums = [5,7,7,8,8,10], target = 8
  Output: [3,4]

  Example 2:
  Input: nums = [5,7,7,8,8,10], target = 6
  Output: [-1,-1]

  Example 3:
  Input: nums = [], target = 0
  Output: [-1,-1]


  Constraints:
  0 <= nums.length <= 105
  -109 <= nums[i] <= 109
  nums is a non-decreasing array.
  -109 <= target <= 109
*/

public class Solution {
  private int searchFirst(int[] nums, int target) {
    int index = -1, low = 0, high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (target == nums[mid]) {
        index = mid;
        high = mid - 1;
      } else if (target < nums[mid]) high = mid - 1;
      else low = mid + 1;
    }

    return index;
  }

  private int searchLast(int[] nums, int target) {
    int index = -1, low = 0, high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (target == nums[mid]) {
        index = mid;
        low = mid + 1;
      } else if (target < nums[mid]) high = mid - 1;
      else low = mid + 1;
    }

    return index;
  }

  public int[] searchRange(int[] nums, int target) {
    return new int[] {searchFirst(nums, target), searchLast(nums, target)};
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] res;

    // should be [3, 4]
    res = solution.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8);
    System.out.println(res[0] + ", " + res[1]);

    // should be [-1, -1]
    res = solution.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6);
    System.out.println(res[0] + ", " + res[1]);

    // should be [-1, -1]
    res = solution.searchRange(new int[] {}, 0);
    System.out.println(res[0] + ", " + res[1]);
  }
}

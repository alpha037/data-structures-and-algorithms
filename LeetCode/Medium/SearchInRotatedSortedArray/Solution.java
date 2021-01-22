package LeetCode.Medium.SearchInRotatedSortedArray;

/*
  33. Search in Rotated Sorted Array

  You are given an integer array nums sorted in ascending order (with distinct values), and an integer target.

  Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

  If target is found in the array return its index, otherwise, return -1.


  Example 1:
  Input: nums = [4,5,6,7,0,1,2], target = 0
  Output: 4

  Example 2:
  Input: nums = [4,5,6,7,0,1,2], target = 3
  Output: -1

  Example 3:
  Input: nums = [1], target = 0
  Output: -1


  Constraints:
  1 <= nums.length <= 5000
  -104 <= nums[i] <= 104
  All values of nums are unique.
  nums is guaranteed to be rotated at some pivot.
  -104 <= target <= 104
*/

public class Solution {
  private int search(int[] nums, int target, int low, int high) {
    if (low > high) return -1;

    int mid = low + (high - low) / 2;

    if (nums[mid] == target) return mid;

    if (nums[low] <= nums[mid]) {
      if (target >= nums[low] && target <= nums[mid]) return search(nums, target, low, mid - 1);

      return search(nums, target, mid + 1, high);
    }

    if (target >= nums[mid] && target <= nums[high]) return search(nums, target, mid + 1, high);

    return search(nums, target, low, mid - 1);
  }

  public int search(int[] nums, int target) {
    return search(nums, target, 0, nums.length - 1);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 4
    System.out.println(solution.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));

    // should be -1
    System.out.println(solution.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 3));

    // should be -1
    System.out.println(solution.search(new int[] {1}, 0));
  }
}

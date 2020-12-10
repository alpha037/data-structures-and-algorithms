package LeetCode.Easy.SearchInsertPosition;

/*
  35. Search Insert Position

  Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

  Example 1:
  Input: nums = [1,3,5,6], target = 5
  Output: 2

  Example 2:
  Input: nums = [1,3,5,6], target = 2
  Output: 1

  Example 3:
  Input: nums = [1,3,5,6], target = 7
  Output: 4

  Example 4:
  Input: nums = [1,3,5,6], target = 0
  Output: 0

  Example 5:
  Input: nums = [1], target = 0
  Output: 0

  Constraints:
  1 <= nums.length <= 104
  -104 <= nums[i] <= 104
  nums contains distinct values sorted in ascending order.
  -104 <= target <= 104
*/
public class Solution {
  public int searchInsert(int[] nums, int target) {

    if (nums[0] > target) return 0;

    if (nums[nums.length - 1] < target) return nums.length;

    int i = 0;
    while (i < nums.length) {
      if (target == nums[i]) break;
      else if (target > nums[i]) i++;
      else break;
    }

    return i;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.searchInsert(new int[] {0, 1, 3, 4}, 2));
  }
}

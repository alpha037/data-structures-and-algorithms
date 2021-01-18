package LeetCode.Medium.NextPermutation;

/*
  31. Next Permutation

  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

  If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

  The replacement must be in place and use only constant extra memory.


  Example 1:
  Input: nums = [1,2,3]
  Output: [1,3,2]

  Example 2:
  Input: nums = [3,2,1]
  Output: [1,2,3]

  Example 3:
  Input: nums = [1,1,5]
  Output: [1,5,1]

  Example 4:
  Input: nums = [1]
  Output: [1]


  Constraints:
  1 <= nums.length <= 100
  0 <= nums[i] <= 100
*/

public class Solution {
  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private void reverse(int[] nums, int start, int end) {
    while (start < end) swap(nums, start++, end--);
  }

  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length == 0) return;

    /**
     * * Brute force
     * approach would be to generate
     * all the possible permutations
     * and then sort them and find out
     * the next greater permutation
     *
     * * TC: O(n!)
     */

    /**
     * * Intuitive approach using Case Analysis
     * * TC: O(n), SC: O(1)
     */
    int i = nums.length - 2, j = nums.length - 1;

    // Find the first minimum element
    // from the last
    while (i >= 0 && nums[i] >= nums[i + 1]) --i;

    if (i >= 0) {
      // Find the second minimum element
      // from the last upto the first
      // minimum element
      while (nums[j] <= nums[i]) --j;

      // Swap the first
      // and second min
      // elements
      swap(nums, i, j);
    }

    // Reverse the sub-array from i
    // to the rest of the array and
    // now the array contains the next
    // permutation
    reverse(nums, i + 1, nums.length - 1);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums = new int[] {3, 2, 1};

    solution.nextPermutation(nums);

    for (int num : nums) System.out.print(num + " ");
  }
}

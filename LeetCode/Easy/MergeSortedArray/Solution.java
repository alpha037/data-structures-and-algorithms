package LeetCode.Easy.MergeSortedArray;

/*
  88. Merge Sorted Array

  Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

  Note:

  The number of elements initialized in nums1 and nums2 are m and n respectively.
  You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.

  Example:
  Input:
  nums1 = [1,2,3,0,0,0], m = 3
  nums2 = [2,5,6],       n = 3
  Output: [1,2,2,3,5,6]

  Constraints:
  -10^9 <= nums1[i], nums2[i] <= 10^9
  nums1.length == m + n
  nums2.length == n
*/
public class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1, k = nums1.length - 1;

    while (k >= 0) {
      // If the nums1 array index
      // runs out, copy over the
      // remaining elements from nums2
      if (i < 0) nums1[k] = nums2[j--];

      // If the nums2 array index
      // runs out, copy over the
      // remaining elements from nums1
      else if (j < 0) nums1[k] = nums1[i--];
      else {
        // If current nums2 element
        // is greater than the current
        // nums1 element, copy the
        // nums2 element into the array
        if (nums1[i] < nums2[j]) nums1[k] = nums2[j--];

        // Can remove this block as both
        // the else and else-if statements
        // are same
        // else if (nums1[i] > nums2[j])
        //   nums1[k] = nums1[i--];

        // Otherwise, copy the nums1
        // element into the array
        else nums1[k] = nums1[i--];
      }

      --k;
    }
  }

  public static void main(String[] args) {
    int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
    int[] nums2 = new int[] {2, 5, 6};

    Solution solution = new Solution();

    solution.merge(nums1, 3, nums2, 3);

    for (int el : nums1) System.out.print(el + " ");
  }
}

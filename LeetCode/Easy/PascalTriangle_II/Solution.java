package LeetCode.Easy.PascalTriangle_II;

import java.util.Arrays;
import java.util.List;

/*
  119. Pascal's Triangle II

  Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.

  Notice that the row index starts from 0.

  In Pascal's triangle, each number is the sum of the two numbers directly above it.

  Follow up:
  Could you optimize your algorithm to use only O(k) extra space?
*/

public class Solution {
  public List<Integer> getRow(int rowIndex) {
    Integer[] arr = new Integer[rowIndex + 1];
    Arrays.fill(arr, 0);
    arr[0] = 1;

    for (int i = 1; i <= rowIndex; ++i) for (int j = i; j > 0; --j) arr[j] = arr[j] + arr[j - 1];

    return Arrays.asList(arr);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be [1, 3, 3, 1]
    System.out.println(solution.getRow(3));
  }
}

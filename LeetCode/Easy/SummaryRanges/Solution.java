package LeetCode.Easy.SummaryRanges;

import java.util.ArrayList;
import java.util.List;

/*
  228. Summary Ranges

  You are given a sorted unique integer array nums.

  Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

  Each range [a,b] in the list should be output as:

  "a->b" if a != b
  "a" if a == b

  Example 1:
  Input: nums = [0,1,2,4,5,7]
  Output: ["0->2","4->5","7"]
  Explanation: The ranges are:
  [0,2] --> "0->2"
  [4,5] --> "4->5"
  [7,7] --> "7"

  Example 2:
  Input: nums = [0,2,3,4,6,8,9]
  Output: ["0","2->4","6","8->9"]
  Explanation: The ranges are:
  [0,0] --> "0"
  [2,4] --> "2->4"
  [6,6] --> "6"
  [8,9] --> "8->9"

  Example 3:
  Input: nums = []
  Output: []

  Example 4:
  Input: nums = [-1]
  Output: ["-1"]

  Example 5:
  Input: nums = [0]
  Output: ["0"]


  Constraints:
  0 <= nums.length <= 20
  -231 <= nums[i] <= 231 - 1
  All the values of nums are unique.
  nums is sorted in ascending order.
*/

public class Solution {
  public List<String> summaryRanges(int[] nums) {
    if (nums.length == 0) return List.of();

    List<String> list = new ArrayList<>();
    int i = 0, start = nums[0];

    while (i < nums.length - 1)
      if (nums[i + 1] - nums[i] == 1) ++i;
      else {
        if (start != nums[i]) list.add(start + "->" + nums[i]);
        else list.add(String.valueOf(start));

        start = nums[++i];
      }

    if (start != nums[i]) list.add(start + "->" + nums[i]);
    else list.add(String.valueOf(start));

    return list;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be ["0->2","4->5","7"]
    System.out.println(solution.summaryRanges(new int[] {0, 1, 2, 4, 5, 7}).toString());

    // should be ["0","2->4","6","8->9"]
    System.out.println(solution.summaryRanges(new int[] {0, 2, 3, 4, 6, 8, 9}).toString());

    // should be []
    System.out.println(solution.summaryRanges(new int[] {}).toString());

    // should be ["-1"]
    System.out.println(solution.summaryRanges(new int[] {-1}).toString());
  }
}

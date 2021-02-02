package LeetCode.Medium.Permutations;

import java.util.ArrayList;
import java.util.List;

/*
  46. Permutations

  Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.


  Example 1:
  Input: nums = [1,2,3]
  Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

  Example 2:
  Input: nums = [0,1]
  Output: [[0,1],[1,0]]

  Example 3:
  Input: nums = [1]
  Output: [[1]]


  Constraints:
  1 <= nums.length <= 6
  -10 <= nums[i] <= 10
  All the integers of nums are unique.
*/

public class Solution {
  private void generatePermutations(
      int[] nums, int len, List<Integer> current, boolean[] visited, List<List<Integer>> res) {
    if (current.size() == len) {
      res.add(new ArrayList<>(current));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) continue;

      // Simulate taking the
      // current digit
      current.add(nums[i]);
      visited[i] = true;

      generatePermutations(nums, len, current, visited, res);

      // Simulate not taking
      // the current digit
      current.remove(current.size() - 1);
      visited[i] = false;
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();

    boolean[] visited = new boolean[nums.length];
    generatePermutations(nums, nums.length, new ArrayList<>(), visited, res);

    return res;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    System.out.println(solution.permute(new int[] {1, 2, 3}).toString());

    // should be [[0,1],[1,0]]
    System.out.println(solution.permute(new int[] {0, 1}).toString());

    // should be [[1]]
    System.out.println(solution.permute(new int[] {1}).toString());
  }
}

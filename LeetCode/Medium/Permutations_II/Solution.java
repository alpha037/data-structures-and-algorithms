package LeetCode.Medium.Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  47. Permutations II

  Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.


  Example 1:
  Input: nums = [1,1,2]
  Output:
  [
    [1,1,2],
    [1,2,1],
    [2,1,1]
  ]

  Example 2:
  Input: nums = [1,2,3]
  Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


  Constraints:
  1 <= nums.length <= 8
  -10 <= nums[i] <= 10
*/

public class Solution {
  private void generatePermutations(
      int[] nums, List<Integer> current, boolean[] visited, List<List<Integer>> res) {
    if (current.size() == nums.length) {
      res.add(new ArrayList<>(current));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) continue;

      // Simulate taking the
      // current element
      current.add(nums[i]);
      visited[i] = true;

      generatePermutations(nums, current, visited, res);

      // Simulate not taking
      // the current element
      current.remove(current.size() - 1);
      visited[i] = false;

      // Ignore duplicate elements
      while (i + 1 < nums.length && nums[i] == nums[i + 1]) ++i;
    }
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();

    Arrays.sort(nums);
    boolean[] visited = new boolean[nums.length];
    generatePermutations(nums, new ArrayList<>(), visited, res);

    return res;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be [[1,1,2], [1,2,1], [2,1,1]]
    System.out.println(solution.permuteUnique(new int[] {1, 1, 2}).toString());

    // should be [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    System.out.println(solution.permuteUnique(new int[] {1, 2, 3}).toString());
  }
}

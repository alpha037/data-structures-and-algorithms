package LeetCode.Medium.CombinationSum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  40. Combination Sum II

  Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

  Each number in candidates may only be used once in the combination.

  Note: The solution set must not contain duplicate combinations.


  Example 1:
  Input: candidates = [10,1,2,7,6,1,5], target = 8
  Output:
  [
  [1,1,6],
  [1,2,5],
  [1,7],
  [2,6]
  ]

  Example 2:
  Input: candidates = [2,5,2,1,2], target = 5
  Output:
  [
  [1,2,2],
  [5]
  ]


  Constraints:
  1 <= candidates.length <= 100
  1 <= candidates[i] <= 50
  1 <= target <= 30
*/

public class Solution {
  private void generateCombinations(
      int[] candidates, int startIdx, int target, List<Integer> current, List<List<Integer>> res) {
    if (target == 0) {
      res.add(new ArrayList<>(current));
      return;
    }

    for (int i = startIdx; i < candidates.length; i++) {
      if (target - candidates[i] < 0) continue;

      // This block will only be executed
      // if the current index is the current
      // starting index of the array or if
      // the current element is not equal to
      // the previous element in the array
      if (i == startIdx || candidates[i] != candidates[i - 1]) {
        current.add(candidates[i]);
        generateCombinations(candidates, i + 1, target - candidates[i], current, res);
        current.remove(current.size() - 1);
      }
    }
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();

    // Sort the array to
    // avoid taking duplicates
    Arrays.sort(candidates);
    generateCombinations(candidates, 0, target, new ArrayList<>(), res);

    return res;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be [[1,1,6], [1,2,5], [1,7], [2,6]]
    System.out.println(solution.combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8).toString());

    // should be [[1,2,2], [5]]
    System.out.println(solution.combinationSum2(new int[] {2, 5, 2, 1, 2}, 5).toString());
  }
}

package LeetCode.Medium.CombinationSum;

import java.util.ArrayList;
import java.util.List;

/*
  39. Combination Sum

  Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

  The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

  It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.


  Example 1:
  Input: candidates = [2,3,6,7], target = 7
  Output: [[2,2,3],[7]]
  Explanation:
  2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
  7 is a candidate, and 7 = 7.
  These are the only two combinations.

  Example 2:
  Input: candidates = [2,3,5], target = 8
  Output: [[2,2,2,2],[2,3,3],[3,5]]

  Example 3:
  Input: candidates = [2], target = 1
  Output: []

  Example 4:
  Input: candidates = [1], target = 1
  Output: [[1]]

  Example 5:
  Input: candidates = [1], target = 2
  Output: [[1,1]]


  Constraints:
  1 <= candidates.length <= 30
  1 <= candidates[i] <= 200
  All elements of candidates are distinct.
  1 <= target <= 500
*/

public class Solution {
  private void generateCombinations(
      int[] candidates,
      int startIdx,
      int target,
      List<Integer> currentCombination,
      List<List<Integer>> res) {
    // If the target becomes 0,
    // then we can add this
    // combination
    if (target == 0) {
      res.add(new ArrayList<>(currentCombination));
      return;
    }

    // Now, we have to try for
    // all the possible combinations
    // available to us
    for (int i = startIdx; i < candidates.length; i++) {
      // While considering the current
      // candidate, if the value
      // after subtracting target
      // from the current candidate
      // reaches -ve, then we won't
      // consider the current candidate
      if (target - candidates[i] < 0) continue;

      currentCombination.add(candidates[i]);
      generateCombinations(candidates, i, target - candidates[i], currentCombination, res);
      currentCombination.remove(currentCombination.size() - 1);
    }
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();

    generateCombinations(candidates, 0, target, new ArrayList<>(), res);

    return res;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be [[2,2,3], [7]]
    System.out.println(solution.combinationSum(new int[] {2, 3, 6, 7}, 7).toString());

    // should be [[2,2,2,2], [2,3,3], [3,5]]
    System.out.println(solution.combinationSum(new int[] {2, 3, 5}, 8).toString());

    // should be []
    System.out.println(solution.combinationSum(new int[] {2}, 1).toString());

    // should be [[1]]
    System.out.println(solution.combinationSum(new int[] {1}, 1).toString());

    // should be [[1, 1]]
    System.out.println(solution.combinationSum(new int[] {1}, 2).toString());
  }
}

package Recursion.JosephusProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * * Josephus Problem
 */
public class Solution {
  private int solveJosephusProblem(List<Integer> soldiers, int k, int index) {
    /**
     * Base Case.
     */
    if (soldiers.size() == 1) return soldiers.get(0);

    int killIdx = (index + k) % soldiers.size();
    soldiers.remove(killIdx);

    return solveJosephusProblem(soldiers, k, killIdx);
  }

  public int solveJosephusProblem(int n, int k) {
    List<Integer> soldiers = new ArrayList<>();

    for (int idx = 1; idx <= n; idx++) soldiers.add(idx);

    return solveJosephusProblem(soldiers, k - 1, 0);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.solveJosephusProblem(14, 2));
  }
}

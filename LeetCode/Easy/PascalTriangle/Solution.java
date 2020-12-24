package LeetCode.Easy.PascalTriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  118. Pascal's Triangle

  Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


  In Pascal's triangle, each number is the sum of the two numbers directly above it.

  Example:

  Input: 5
  Output:
  [
            [1],
          [1 , 1],
        [1 , 2 , 1],
      [1 , 3 , 3 , 1],
    [1 , 4 , 6 , 4 , 1]
  ]
*/

public class Solution {
  public List<List<Integer>> generate(int numRows) {
    if (numRows == 0) return List.of(List.of(1));

    List<List<Integer>> lists = new ArrayList<>();
    lists.add(Arrays.asList(1));
    for (int i = 1; i < numRows; ++i) {
      lists.add(new ArrayList<>());
      for (int j = 0; j <= i; ++j)
        if (j == 0 || j == i) lists.get(i).add(1);
        else lists.get(i).add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
    }

    return lists;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be [
    //    [1], [1 , 1], [1 , 2 , 1], [1 , 3 , 3 , 1], [1 , 4 , 6 , 4 , 1]
    // ]
    System.out.println(solution.generate(5));
  }
}

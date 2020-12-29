package LeetCode.Easy.TwoSum_II;

// import java.util.HashMap;

/*
  167. Two Sum II - Input array is sorted

  Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

  The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

  Note:

  Your returned answers (both index1 and index2) are not zero-based.
  You may assume that each input would have exactly one solution and you may not use the same element twice.


  Example 1:
  Input: numbers = [2,7,11,15], target = 9
  Output: [1,2]
  Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

  Example 2:
  Input: numbers = [2,3,4], target = 6
  Output: [1,3]

  Example 3:
  Input: numbers = [-1,0], target = -1
  Output: [1,2]


  Constraints:
  2 <= nums.length <= 3 * 104
  -1000 <= nums[i] <= 1000
  nums is sorted in increasing order.
  -1000 <= target <= 1000
*/

public class Solution {
  public int[] twoSum(int[] numbers, int target) {
    if (numbers == null || numbers.length == 0) return new int[0];

    /**
     * * HashMap approach
     */
    // HashMap<Integer, Integer> map = new HashMap<>();

    // for (int i=0; i<numbers.length; i++)
    //   if (map.containsKey(target - numbers[i]))
    //     return new int[] {map.get(target - numbers[i]), i + 1};
    //   else
    //     map.put(numbers[i], i + 1);

    /**
     * * Since the array is already
     * * sorted, so we can use binary
     * * search to check
     */
    int i = 0, j = numbers.length - 1;
    while (i < j) {
      if (numbers[i] + numbers[j] == target) return new int[] {i + 1, j + 1};
      else if (numbers[i] + numbers[j] > target) --j;
      else ++i;
    }

    return new int[0];
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] res = solution.twoSum(new int[] {2, 7, 11, 15}, 9);

    for (int n : res) System.out.print(n + " ");
  }
}

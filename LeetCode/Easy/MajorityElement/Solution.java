package LeetCode.Easy.MajorityElement;

// import java.util.HashMap;

/*
  169. Majority Element


  Given an array nums of size n, return the majority element.

  The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.


  Example 1:
  Input: nums = [3,2,3]
  Output: 3

  Example 2:
  Input: nums = [2,2,1,1,1,2,2]
  Output: 2


  Constraints:
  n == nums.length
  1 <= n <= 5 * 104
  -231 <= nums[i] <= 231 - 1


  Follow-up: Could you solve the problem in linear time and in O(1) space?
*/

public class Solution {
  public int majorityElement(int[] nums) {

    /**
     * * Hashmap approach
     * * TC: O(n), SC: O(n)
     */
    // HashMap<Integer, Integer> map = new HashMap<>();

    // for (int num : nums) {
    //   map.put(num, map.getOrDefault(num, 0) + 1);

    //   if (map.get(num) > (nums.length / 2))
    //     return num;
    // }

    /**
     * * Moore's Voting Algorithm
     * * TC: O(n), SC: O(1)
     */
    int majorityIndex = 0, count = 1;

    for (int i = 1; i < nums.length; i++)
      // If the element at majorityIndex
      // is equal to the current element
      // increment the count
      if (nums[majorityIndex] == nums[i]) ++count;
      else {

        // Otherwise, decrement the
        // count
        --count;

        // If the count reaches 0,
        // then set the majorityIndex
        // to the current index and
        // reset the count value to 1
        if (count == 0) {
          majorityIndex = i;
          count = 1;
        }
      }

    // Finally, return the
    // majority element
    return nums[majorityIndex];
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be 3
    System.out.println(solution.majorityElement(new int[] {3, 2, 3}));

    // should be 2
    System.out.println(solution.majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
  }
}

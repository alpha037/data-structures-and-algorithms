package LeetCode.Easy.ContainsDuplicate;

// import java.util.Arrays;
// import java.util.HashMap;
import java.util.HashSet;

/*
  217. Contains Duplicate

  Given an array of integers, find if the array contains any duplicates.

  Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

  Example 1:
  Input: [1,2,3,1]
  Output: true

  Example 2:
  Input: [1,2,3,4]
  Output: false

  Example 3:
  Input: [1,1,1,3,3,4,3,2,4,2]
  Output: true
*/

public class Solution {
  public boolean containsDuplicate(int[] nums) {
    if (nums.length <= 1) return false;

    /**
     * * Sorting approach
     * * TC: O(n * log(n)), SC: O(1)
     */
    // Arrays.sort(nums);

    // for (int i=0; i<nums.length-1; i++)
    //   if (nums[i] == nums[i+1])
    //     return true;

    // return false;

    /**
     * * Hashmap approach
     * * TC: O(n), SC: O(n)
     */
    // HashMap<Integer, Integer> visited = new HashMap<>();

    // for (int num : nums)
    //   if (visited.containsKey(num))
    //     return true;
    //   else
    //     visited.put(num, visited.getOrDefault(num, 0) + 1);

    // return false;

    /**
     * * HashSet approach
     * * TC: O(n), SC: O(n)
     */
    HashSet<Integer> set = new HashSet<>();
    for (int num : nums) set.add(num);

    return set.size() != nums.length;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be true
    System.out.println(solution.containsDuplicate(new int[] {1, 2, 3, 1}));

    // should be false
    System.out.println(solution.containsDuplicate(new int[] {1, 2, 3, 4}));

    // should be true
    System.out.println(solution.containsDuplicate(new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
  }
}

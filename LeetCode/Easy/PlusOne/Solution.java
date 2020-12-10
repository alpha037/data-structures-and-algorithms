package LeetCode.Easy.PlusOne;

/*
  66. Plus One

  Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

  The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

  You may assume the integer does not contain any leading zero, except the number 0 itself.


  Example 1:
  Input: digits = [1,2,3]
  Output: [1,2,4]
  Explanation: The array represents the integer 123.

  Example 2:
  Input: digits = [4,3,2,1]
  Output: [4,3,2,2]
  Explanation: The array represents the integer 4321.

  Example 3:
  Input: digits = [0]
  Output: [1]

  Constraints:
  1 <= digits.length <= 100
  0 <= digits[i] <= 9
*/

public class Solution {
  public int[] plusOne(int[] digits) {
    if (digits.length == 0) return null;

    for (int i = digits.length - 1; i >= 0; --i) {
      if (digits[i] < 9) {
        digits[i] += 1;
        break;
      } else {
        digits[i] = 0;

        if (i == 0) {
          int[] arr = new int[digits.length + 1];
          arr[0] = 1;
          digits = arr;
        }
      }
    }

    return digits;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] digits = solution.plusOne(new int[] {4, 3, 2, 1});
    for (int digit : digits) System.out.print(digit + " ");
    System.out.println();

    digits = solution.plusOne(new int[] {1, 2, 3});
    for (int digit : digits) System.out.print(digit + " ");
    System.out.println();

    digits = solution.plusOne(new int[] {0});
    for (int digit : digits) System.out.print(digit + " ");
    System.out.println();
  }
}

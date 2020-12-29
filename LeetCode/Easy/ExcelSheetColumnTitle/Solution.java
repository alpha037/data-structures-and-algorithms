package LeetCode.Easy.ExcelSheetColumnTitle;

/*
  168. Excel Sheet Column Title

  Given a positive integer, return its corresponding column title as appear in an Excel sheet.

  For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...

  Example 1:
  Input: 1
  Output: "A"

  Example 2:
  Input: 28
  Output: "AB"

  Example 3:
  Input: 701
  Output: "ZY"
*/

public class Solution {
  public String convertToTitle(int n) {
    if (n == 0) return "";

    StringBuilder res = new StringBuilder("");

    /**
     * * Lookup approach
     */
    // final char[] ALPHABETS  =
    // {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    // while (n > 0) {
    //   int r = n % 26;

    //   // If the remainder is 0,
    //   // then we append Z and
    //   // decrease n by n/26 - 1,
    //   // as we are considering
    //   // 26 to be 'Z', whereas
    //   // it's actually the 25th
    //   // alphabet w.r.t 'A'

    //   if (r == 0) {
    //     n = (n /26) - 1;
    //     r = 26;
    //   }

    //   // Otherwise, we decrease
    //   // n by 26
    //   else
    //     n /= 26;

    //   res.append(ALPHABETS[r - 1]);
    // }

    /**
     * * ASCII value approach
     */
    while (n > 0) {
      res.append((char) (n % 26 == 0 ? 'Z' : (n % 26) + 'A' - 1));
      n = (n % 26 == 0 ? (n / 26) - 1 : n / 26);
    }

    return res.reverse().toString();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    // should be A
    System.out.println(solution.convertToTitle(1));

    // should be AB
    System.out.println(solution.convertToTitle(28));

    // should be ZY
    System.out.println(solution.convertToTitle(701));

    // should be AZ
    System.out.println(solution.convertToTitle(52));
  }
}

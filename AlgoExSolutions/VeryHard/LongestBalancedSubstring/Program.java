package AlgoExSolutions.VeryHard.LongestBalancedSubstring;

// import java.util.*;

/**
 * * Longest Balanced Substring
 */
class Program {
  /**
   * * Approach using two passes (optimized)
   *
   * * TC: O(n)
   * * SC: O(1)
   */
  public int longestBalancedSubstring(String string) {
    // Write your code here.
    return Math.max(
        longestBalancedSubstring(string, true), longestBalancedSubstring(string, false));
  }

  private int longestBalancedSubstring(String string, boolean leftToRight) {
    char target = leftToRight ? '(' : ')';
    int openingBracesCount = 0, closingBracesCount = 0;
    int len = string.length(), maxLen = 0;
    int start = leftToRight ? 0 : len - 1, step = leftToRight ? 1 : -1;

    while (start >= 0 && start < len) {
      char c = string.charAt(start);

      if (c == target) ++openingBracesCount;
      else ++closingBracesCount;

      if (openingBracesCount == closingBracesCount)
        maxLen = Math.max(maxLen, closingBracesCount * 2);
      else if (closingBracesCount > openingBracesCount) {
        openingBracesCount = 0;
        closingBracesCount = 0;
      }

      start += step;
    }

    return maxLen;
  }

  /**
   * * Approach using two passes
   *
   * * TC: O(n)
   * * SC: O(1)
   */
  // public int longestBalancedSubstring(String string) {
  // 	int openingBracesCount = 0, closingBracesCount = 0;
  // 	int len = string.length(), maxLen = 0;

  // 	for (int i = 0; i < len; i++) {
  // 		char c = string.charAt(i);

  // 		if (c == '(') ++openingBracesCount;
  // 		else ++closingBracesCount;

  // 		if (openingBracesCount == closingBracesCount)
  // 			maxLen = Math.max(maxLen, closingBracesCount * 2);
  // 		else if (closingBracesCount > openingBracesCount) {
  // 			openingBracesCount = 0;
  // 			closingBracesCount = 0;
  // 		}
  // 	}

  // 	openingBracesCount = 0;
  // 	closingBracesCount = 0;

  // 	for (int i = len - 1; i >= 0; i--) {
  // 		char c = string.charAt(i);

  // 		if (c == '(') ++openingBracesCount;
  // 		else ++closingBracesCount;

  // 		if (openingBracesCount == closingBracesCount)
  // 			maxLen = Math.max(maxLen, openingBracesCount * 2);
  // 		else if (openingBracesCount > closingBracesCount) {
  // 			openingBracesCount = 0;
  // 			closingBracesCount = 0;
  // 		}
  // 	}

  //   return maxLen;
  // }

  /**
   * * Approach using a Stack
   *
   * * TC: O(n)
   * * SC: O(n)
   */
  // public int longestBalancedSubstring(String string) {
  // 	Stack<Integer> stack = new Stack<>();
  // 	stack.push(-1);
  // 	int maxLen = 0;

  // 	for (int i = 0; i < string.length(); i++) {
  // 		char c = string.charAt(i);

  // 		if (c == '(') stack.push(i);
  // 		else {
  // 			stack.pop();
  // 			if (stack.isEmpty()) stack.push(i);

  // 			maxLen = Math.max(maxLen, i - stack.peek());
  // 		}
  // 	}

  //   return maxLen;
  // }
}

package AlgoExSolutions.Hard.ShortenPath;

import java.util.*;
import java.util.stream.*;

/**
 * * Shorten Path
 */
class Program {
  /**
   * * TC: O(n)
   * * SC: O(n)
   */
  public static String shortenPath(String path) {
    // Write your code here;
    Stack<String> stack = new Stack<>();
    List<String> filteredTokens = filter(path.split("/"));
    boolean isAbsolutePath = path.charAt(0) == '/';

    if (isAbsolutePath) stack.add("");

    for (String token : filteredTokens) {
      if (token.equals("..") && !stack.isEmpty()) {
        if (stack.peek().equals("")) continue;
        else if (stack.peek().equals("..")) stack.push(token);
        else stack.pop();
      } else stack.push(token);
    }

    return stack.size() == 1 && stack.peek().equals("") ? "/" : String.join("/", stack);
  }

  private static List<String> filter(String[] tokens) {
    List<String> tokensList = Arrays.asList(tokens);
    return tokensList.stream()
        .filter(token -> !token.equals(".") && !token.equals(""))
        .collect(Collectors.toList());
  }
}

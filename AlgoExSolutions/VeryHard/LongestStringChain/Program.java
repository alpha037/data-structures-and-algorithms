package AlgoExSolutions.VeryHard.LongestStringChain;

import java.util.*;

/**
 * * Longest String Chain
 */
class Program {
  /**
   * * TC: O(n * m^2 + n log(n))
   * * SC: O(nm)
   */
  public static List<String> longestStringChain(List<String> strings) {
    // Write your code here.
    Collections.sort(strings, (s1, s2) -> s1.length() - s2.length());
    Map<String, Chain> chainMap = getChainMap(strings);
    int maxChainLength = -1;
    String start = "";

    for (String string : strings) {
      Chain currentChain = chainMap.get(string);

      tryUpdateLongestStringChain(chainMap, currentChain, string);

      if (maxChainLength < currentChain.length) {
        maxChainLength = currentChain.length;
        start = string;
      }
    }

    return buildLongestStringChain(chainMap, start);
  }

  private static Map<String, Chain> getChainMap(List<String> strings) {
    Map<String, Chain> chainMap = new HashMap<>();
    for (String string : strings) chainMap.put(string, new Chain("", 1));
    return chainMap;
  }

  private static void tryUpdateLongestStringChain(
      Map<String, Chain> chainMap, Chain currentChain, String string) {
    for (int i = 0; i < string.length(); i++) {
      String newString = string.substring(0, i) + string.substring(i + 1);

      if (!chainMap.containsKey(newString)) continue;

      int newChainLength = chainMap.get(newString).length + 1;

      if (newChainLength > currentChain.length) {
        currentChain.nextString = newString;
        currentChain.length = newChainLength;
      }
    }
  }

  private static List<String> buildLongestStringChain(Map<String, Chain> chainMap, String start) {
    List<String> stringChain = new ArrayList<>();

    while (!start.equals("")) {
      stringChain.add(start);
      start = chainMap.get(start).nextString;
    }

    return stringChain.size() == 1 ? new ArrayList<>() : stringChain;
  }

  static class Chain {
    String nextString;
    int length;

    public Chain(String nextString, int length) {
      this.nextString = nextString;
      this.length = length;
    }
  }
}

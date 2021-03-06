package AlgoExSolutions.Medium.GroupAnagrams;

import java.util.*;

/**
 * * Group Anagrams
 */
class Program {
  public static List<List<String>> groupAnagrams(List<String> words) {
    // Write your code here.
    HashMap<String, List<String>> map = new HashMap<>();
    List<List<String>> res = new ArrayList<>();

    for (String word : words) {
      char[] chars = word.toCharArray();
      Arrays.sort(chars);
      String sortedWord = new String(chars);

      if (!map.containsKey(sortedWord)) map.put(sortedWord, new ArrayList<>());

      map.get(sortedWord).add(word);
    }

    res.addAll(map.values());
    return res;
  }
}

package AlgoExSolutions.Medium.MinimumCharactersForWords;

import java.util.*;

/**
 * * Minimum Characters For Words
 */
class Program {
  /**
   * * TC: O(n * l)
   * * SC: O(c)
   */
  public String[] minimumCharactersForWords(String[] words) {
    // Write your code here.

    // If we want to maintain
    // the insertion order, then
    // we can use LinkedHashMap
    // Map<Character, Integer>
    // 	outerMap = new LinkedHashMap<>(), innerMap = new LinkedHashMap<>();

    Map<Character, Integer> outerMap = new HashMap<>(), innerMap = new HashMap<>();

    for (String word : words) {
      for (char letter : word.toCharArray()) {
        innerMap.put(letter, innerMap.getOrDefault(letter, 0) + 1);

        if (!outerMap.containsKey(letter) || outerMap.get(letter) < innerMap.get(letter))
          outerMap.put(letter, innerMap.get(letter));
      }

      innerMap.clear();
    }

    return getMinimumChars(outerMap);
  }

  private String[] getMinimumChars(Map<Character, Integer> map) {
    List<String> list = new ArrayList<>();

    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      String s = String.valueOf(entry.getKey());
      for (int i = 0; i < entry.getValue(); i++) list.add(s);
    }

    String[] chars = new String[list.size()];
    chars = list.toArray(chars);
    return chars;
  }
}

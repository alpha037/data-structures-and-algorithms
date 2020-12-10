package Arrays.AnagramChecker;

import java.util.HashMap;
import java.util.Map;

public class AnagramChecker {
  public static boolean isAnagram(String s1, String s2) {

    s1 = s1.replaceAll("\\s", "").toLowerCase();
    s2 = s2.replaceAll("\\s", "").toLowerCase();

    if (s1.length() != s2.length()) return false;

    Map<Character, Integer> map = new HashMap<>();

    for (Character character : s1.toCharArray())
      if (map.containsKey(character)) map.put(character, map.get(character) + 1);
      else map.put(character, 1);

    for (Character character : s2.toCharArray())
      if (map.containsKey(character)) map.put(character, map.get(character) - 1);
      else return false;

    for (Character character : s1.toCharArray()) if (map.get(character) != 0) return false;

    return true;
  }
}

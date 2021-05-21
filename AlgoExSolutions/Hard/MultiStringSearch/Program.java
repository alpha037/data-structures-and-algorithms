package AlgoExSolutions.Hard.MultiStringSearch;

import java.util.*;

/**
 * * Multi String Search
 */
class Program {
  /**
   * * TC: O(bs + ns)
   * * SC: O(ns)
   */
  public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
    // Write your code here.
    List<Boolean> res = new ArrayList<>();
    Map<String, Boolean> matches = new HashMap<>();
    Trie trie = new Trie();

    for (String word : smallStrings) trie.insert(word);

    for (int i = 0; i < bigString.length(); i++) contains(bigString, i, trie, matches);

    for (String word : smallStrings) {
      if (matches.containsKey(word)) res.add(true);
      else res.add(false);
    }

    return res;
  }

  private static void contains(String str, int startIdx, Trie trie, Map<String, Boolean> matches) {
    TrieNode node = trie.root;

    for (char letter : str.substring(startIdx).toCharArray()) {
      if (!node.children.containsKey(letter)) break;

      node = node.children.get(letter);

      if (node.children.containsKey(trie.endSymbol)) matches.put(node.word, true);
    }
  }

  static class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String word;
  }

  static class Trie {
    TrieNode root = new TrieNode();
    char endSymbol = '*';

    public void insert(String str) {
      TrieNode node = root;

      for (char letter : str.toCharArray()) {
        if (!node.children.containsKey(letter)) node.children.put(letter, new TrieNode());

        node = node.children.get(letter);
      }

      node.children.put(endSymbol, null);
      node.word = str;
    }
  }

  /**
   * * TC: O(bns)
   * * SC: O(n)
   */
  // public static List<Boolean> multiStringSearch(
  // 	String bigString, String[] smallStrings
  // ) {
  // 	int len = smallStrings.length;
  // 	List<Boolean> matches = new ArrayList<>(len);

  // 	for (int i = 0; i < len; i++)
  // 		matches.add(contains(bigString, smallStrings[i]));

  //   return matches;
  // }

  // private static boolean contains(String bigString, String smallString) {
  // 	for (int i = 0; i < bigString.length(); i++) {
  // 		if (i + smallString.length() > bigString.length()) return false;

  // 		if (contains(bigString, smallString, i)) return true;
  // 	}

  // 	return false;
  // }

  // private static boolean contains(
  // 	String bigString, String smallString, int startIdx
  // ) {
  // 	int leftBigIdx = startIdx, rightBigIdx = startIdx + smallString.length() - 1;
  // 	int leftSmallIdx = 0, rightSmallIdx = smallString.length() - 1;

  // 	while (leftBigIdx <= rightBigIdx) {
  // 		if (
  // 			bigString.charAt(leftBigIdx) != smallString.charAt(leftSmallIdx) ||
  // 			bigString.charAt(rightBigIdx) != smallString.charAt(rightSmallIdx)
  // 		) return false;

  // 		++leftBigIdx;
  // 		++leftSmallIdx;
  // 		--rightBigIdx;
  // 		--rightSmallIdx;
  // 	}

  // 	return true;
  // }
}

package AlgoExSolutions.Medium.SuffixTrieConstruction;

import java.util.*;

/**
 * * Suffix Trie Construction
 */
class Program {
  // Do not edit the class below except for the
  // populateSuffixTrieFrom and contains methods.
  // Feel free to add new properties and methods
  // to the class.
  static class TrieNode {
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  }

  static class SuffixTrie {
    TrieNode root = new TrieNode();
    char endSymbol = '*';

    public SuffixTrie(String str) {
      populateSuffixTrieFrom(str);
    }

    private void insertSubstringStartingAt(int idx, String str) {
      TrieNode node = root;

      for (char letter : str.substring(idx).toCharArray()) {
        if (!node.children.containsKey(letter)) node.children.put(letter, new TrieNode());

        node = node.children.get(letter);
      }

      node.children.put(endSymbol, null);
    }

    // O(n^2) time | O(n^2) space
    public void populateSuffixTrieFrom(String str) {
      // Write your code here.
      for (int idx = 0; idx < str.length(); idx++) insertSubstringStartingAt(idx, str);
    }

    // O(m) time | O(1) space
    public boolean contains(String str) {
      // Write your code here.
      TrieNode node = root;

      for (char letter : str.toCharArray()) {
        if (!node.children.containsKey(letter)) return false;

        node = node.children.get(letter);
      }

      return node.children.containsKey(endSymbol);
    }
  }
}

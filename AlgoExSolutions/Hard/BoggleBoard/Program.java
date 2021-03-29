package AlgoExSolutions.Hard.BoggleBoard;

import java.util.*;

/**
 * * Boggle Board
 */
class Program {
  /**
   * * TC: O((nm * 8^s) + wm)
   * * SC: O(ws + nm)
   */
  public static List<String> boggleBoard(char[][] board, String[] words) {
    // Write your code here.
    int height = board.length, width = board[0].length;
    Trie trie = new Trie();
    Set<String> finalWords = new HashSet<>();
    boolean[][] visited = new boolean[height][width];

    for (String word : words) trie.add(word);

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) explore(i, j, board, trie.root, visited, finalWords);
    }

    return new ArrayList<>(finalWords);
  }

  private static void explore(
      int i, int j, char[][] board, TrieNode root, boolean[][] visited, Set<String> finalWords) {
    if (visited[i][j]) return;

    char letter = board[i][j];
    if (!root.children.containsKey(letter)) return;

    visited[i][j] = true;
    root = root.children.get(letter);

    if (root.children.containsKey('*')) finalWords.add(root.word);

    for (Integer[] neighbor : getNeighbors(i, j, board))
      explore(neighbor[0], neighbor[1], board, root, visited, finalWords);

    visited[i][j] = false;
  }

  private static List<Integer[]> getNeighbors(int i, int j, char[][] board) {
    List<Integer[]> neighbors = new ArrayList<>();
    int height = board.length - 1, width = board[i].length - 1;

    if (i > 0 && j > 0) neighbors.add(new Integer[] {i - 1, j - 1});
    if (i > 0) neighbors.add(new Integer[] {i - 1, j});
    if (i > 0 && j < width) neighbors.add(new Integer[] {i - 1, j + 1});
    if (j < width) neighbors.add(new Integer[] {i, j + 1});
    if (i < height && j < width) neighbors.add(new Integer[] {i + 1, j + 1});
    if (i < height) neighbors.add(new Integer[] {i + 1, j});
    if (i < height && j > 0) neighbors.add(new Integer[] {i + 1, j - 1});
    if (j > 0) neighbors.add(new Integer[] {i, j - 1});

    return neighbors;
  }

  static class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String word = "";
  }

  static class Trie {
    TrieNode root;
    final char endSymbol;

    public Trie() {
      root = new TrieNode();
      endSymbol = '*';
    }

    public void add(String word) {
      TrieNode node = root;

      for (char letter : word.toCharArray()) {
        if (!node.children.containsKey(letter)) node.children.put(letter, new TrieNode());

        node = node.children.get(letter);
      }

      node.children.put(endSymbol, null);
      node.word = word;
    }
  }
}

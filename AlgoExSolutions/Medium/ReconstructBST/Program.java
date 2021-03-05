package AlgoExSolutions.Medium.ReconstructBST;

import java.util.*;

/**
 * * Reconstruct BST
 */
class Program {
  // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }

    public BST(int value, BST left, BST right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }

  static class TreeInfo {
    int idx;

    public TreeInfo(int idx) {
      this.idx = idx;
    }
  }

  private BST reconstructBst(ArrayList<Integer> nodes, int minValue, int maxValue, TreeInfo root) {
    if (root.idx == nodes.size()) return null;

    int rootValue = nodes.get(root.idx);

    if (rootValue < minValue || rootValue >= maxValue) return null;

    root.idx += 1;

    BST leftSubtree = reconstructBst(nodes, minValue, rootValue, root);
    BST rightSubtree = reconstructBst(nodes, rootValue, maxValue, root);

    return new BST(rootValue, leftSubtree, rightSubtree);
  }

  public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
    // Write your code here.
    return reconstructBst(
        preOrderTraversalValues, Integer.MIN_VALUE, Integer.MAX_VALUE, new TreeInfo(0));
  }
}

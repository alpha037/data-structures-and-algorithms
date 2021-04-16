package AlgoExSolutions.Medium.HeightBalancedBinaryTree;

// import java.util.*;

/**
 * * Height Balanced Binary Tree
 */
class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  /**
   * * TC: O(n)
   * * SC: O(h)
   */
  private int heightBalancedTreeHelper(BinaryTree root) {
    if (root == null) return 0;

    int leftTreeHeight = heightBalancedTreeHelper(root.left);
    // if (leftTreeHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

    int rightTreeHeight = heightBalancedTreeHelper(root.right);
    // if (rightTreeHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

    int difference = Math.abs(leftTreeHeight - rightTreeHeight);
    if (difference > 1) return Integer.MIN_VALUE;
    else return Math.max(leftTreeHeight, rightTreeHeight) + 1;
  }

  public boolean heightBalancedBinaryTree(BinaryTree tree) {
    // Write your code here.
    return heightBalancedTreeHelper(tree) != Integer.MIN_VALUE;
  }
}

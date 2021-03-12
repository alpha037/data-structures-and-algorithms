package AlgoExSolutions.Medium.BinaryTreeDiameter;

// import java.util.*;

/**
 * * Binary Tree Diameter
 */
class Program {
  // This is an input class. Do not edit.
  static class TreeInfo {
    int diameter;
    int height;

    public TreeInfo(int diameter, int height) {
      this.diameter = diameter;
      this.height = height;
    }
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  private TreeInfo binaryTreeDiameterHelper(BinaryTree root) {
    if (root == null) return new TreeInfo(0, 0);

    TreeInfo leftTreeInfo = binaryTreeDiameterHelper(root.left);
    TreeInfo rightTreeInfo = binaryTreeDiameterHelper(root.right);

    int currentHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);
    int maxSubtreeDiameter = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter);

    // Diameter always is the maximum
    // value of the three following
    // values:
    // 1. Diameter of the left subtree
    // 2. Diameter of the right subtree
    // 3. Longest path passing through the current node
    return new TreeInfo(
        Math.max(maxSubtreeDiameter, leftTreeInfo.height + rightTreeInfo.height), currentHeight);
  }

  public int binaryTreeDiameter(BinaryTree tree) {
    // Write your code here.
    return binaryTreeDiameterHelper(tree).diameter;
  }
}

package AlgoExSolutions.Easy.NodeDepths;

// import java.util.*;

/**
 * * Node Depths
 */
class Program {
  private static int nodeDepths(BinaryTree root, int depth) {
    if (root == null) return 0;

    return depth + nodeDepths(root.left, depth + 1) + nodeDepths(root.right, depth + 1);
  }

  public static int nodeDepths(BinaryTree root) {
    // Write your code here.
    if (root == null) return -1;

    return nodeDepths(root, 0);
  }

  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }
}

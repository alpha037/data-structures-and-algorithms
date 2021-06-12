package AlgoExSolutions.VeryHard.RightSiblingTree;

// import java.util.*;

/**
 * * Right Sibling Tree
 */
class Program {
  /**
   * * TC: O(n)
   * * SC: O(d)
   */
  public static BinaryTree rightSiblingTree(BinaryTree root) {
    rightSiblingTree(root, null, false);
    return root;
  }

  private static void rightSiblingTree(BinaryTree node, BinaryTree parent, boolean isLeftChild) {
    if (node == null) return;

    BinaryTree left = node.left, right = node.right;

    rightSiblingTree(left, node, true);

    if (parent == null) node.right = null;
    else {
      if (isLeftChild) node.right = parent.right;
      else if (parent.right == null) node.right = null;
      else node.right = parent.right.left;
    }

    rightSiblingTree(right, parent, false);
  }

  static class BinaryTree {
    int value;
    BinaryTree left = null;
    BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}

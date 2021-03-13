package AlgoExSolutions.Medium.FindSuccessor;

// import java.util.*;

/**
 * * Find Successor
 */
class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
    public BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  private BinaryTree leftMostChild(BinaryTree tree) {
    BinaryTree root = tree;

    while (root.left != null) root = root.left;

    return root;
  }

  public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
    // Write your code here.
    if (node.right != null) return leftMostChild(node.right);

    BinaryTree currentNode = node;
    BinaryTree ancestor = node.parent;

    // We keep traversing up the tree
    // until we've reached a point where
    // the current node is located in the
    // left subtree of a parent
    while (ancestor != null && ancestor.left != currentNode) {
      currentNode = ancestor;
      ancestor = ancestor.parent;
    }

    return ancestor;
  }
}

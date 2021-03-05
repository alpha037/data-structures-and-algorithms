package AlgoExSolutions.Medium.BSTTraversal;

import java.util.*;

/**
 * * BST Traversal
 */
class Program {
  private static void inOrderTraverseHelper(BST root, List<Integer> array) {
    if (root != null) {
      inOrderTraverseHelper(root.left, array);
      array.add(root.value);
      inOrderTraverseHelper(root.right, array);
    }
  }

  public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
    // Write your code here.
    inOrderTraverseHelper(tree, array);
    return array;
  }

  private static void preOrderTraverseHelper(BST root, List<Integer> array) {
    if (root != null) {
      array.add(root.value);
      preOrderTraverseHelper(root.left, array);
      preOrderTraverseHelper(root.right, array);
    }
  }

  public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
    // Write your code here.
    preOrderTraverseHelper(tree, array);
    return array;
  }

  private static void postOrderTraverseHelper(BST root, List<Integer> array) {
    if (root != null) {
      postOrderTraverseHelper(root.left, array);
      postOrderTraverseHelper(root.right, array);
      array.add(root.value);
    }
  }

  public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
    // Write your code here.
    postOrderTraverseHelper(tree, array);
    return array;
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}

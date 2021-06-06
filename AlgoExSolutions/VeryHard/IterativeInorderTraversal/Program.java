package AlgoExSolutions.VeryHard.IterativeInorderTraversal;

import java.util.function.Function;

/**
 * * Iterative In-Order Traversal
 */
class Program {
  /**
   * * TC: O(n)
   * * SC: O(1)
   */
  public static void iterativeInOrderTraversal(
      BinaryTree tree, Function<BinaryTree, Void> callback) {
    // Write your code here.
    BinaryTree currentNode = tree, previousNode = tree.parent;

    while (currentNode != null) {
      BinaryTree nextNode = null;
      if (previousNode == null || previousNode == currentNode.parent) {
        if (currentNode.left != null) nextNode = currentNode.left;
        else {
          callback.apply(currentNode);
          nextNode = currentNode.right == null ? currentNode.parent : currentNode.right;
        }
      } else if (previousNode == currentNode.left) {
        callback.apply(currentNode);
        nextNode = currentNode.right == null ? currentNode.parent : currentNode.right;
      }
      // previousNode == currentNode.right
      else nextNode = currentNode.parent;

      previousNode = currentNode;
      currentNode = nextNode;
    }
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;
    public BinaryTree parent;

    public BinaryTree(int value) {
      this.value = value;
    }

    public BinaryTree(int value, BinaryTree parent) {
      this.value = value;
      this.parent = parent;
    }
  }
}

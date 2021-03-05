package AlgoExSolutions.Medium.FindKthLargestValueInBST;

// import java.util.*;

/**
 * * Find Kth Largest Value In BST
 */
class Program {
  class Node {
    int value;
    int numberOfNodesVisited;

    public Node(int value, int numberOfNodesVisited) {
      this.value = value;
      this.numberOfNodesVisited = numberOfNodesVisited;
    }
  }

  // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  // private static void reverseInOrder(BST root, List<Integer> nodes, int k) {
  // 	if (root != null && k != nodes.size()) {
  // 		reverseInOrder(root.right, nodes, k);
  // 		nodes.add(root.value);
  // 		reverseInOrder(root.left, nodes, k);
  // 	}
  // }

  private void findKthLargestValueInBst(BST root, Node current, int k) {
    if (root == null || current.numberOfNodesVisited >= k) return;

    findKthLargestValueInBst(root.right, current, k);

    if (current.numberOfNodesVisited < k) {
      current.numberOfNodesVisited += 1;
      current.value = root.value;
      findKthLargestValueInBst(root.left, current, k);
    }
  }

  public int findKthLargestValueInBst(BST tree, int k) {
    // Write your code here.
    // List<Integer> nodes = new ArrayList<>();

    // reverseInOrder(tree, nodes, k);

    // return nodes.get(k - 1);

    Node current = new Node(-1, 0);

    findKthLargestValueInBst(tree, current, k);

    return current.value;
  }
}

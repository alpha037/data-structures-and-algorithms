package AlgoExSolutions.VeryHard.FlattenBinaryTree;

// import java.util.*;

/**
 * * Flatten Binary Tree
 */
class Program {
  /**
   * * TC: O(n)
   * * SC: O(d)
   */
  public static BinaryTree flattenBinaryTree(BinaryTree root) {
    // Write your code here.
    return flattenBinaryTreeHelper(root)[0];
  }

  private static BinaryTree[] flattenBinaryTreeHelper(BinaryTree root) {
    BinaryTree leftNode = null, rightNode = null;

    if (root.left == null) leftNode = root;
    else {
      BinaryTree[] lstNodes = flattenBinaryTreeHelper(root.left);
      connectNodes(lstNodes[1], root);
      leftNode = lstNodes[0];
    }

    if (root.right == null) rightNode = root;
    else {
      BinaryTree[] rstNodes = flattenBinaryTreeHelper(root.right);
      connectNodes(root, rstNodes[0]);
      rightNode = rstNodes[1];
    }

    return new BinaryTree[] {leftNode, rightNode};
  }

  private static void connectNodes(BinaryTree left, BinaryTree right) {
    left.right = right;
    right.left = left;
  }

  /**
   * * TC: O(n)
   * * SC: O(n)
   */
  // public static BinaryTree flattenBinaryTree(BinaryTree root) {
  // 	List<BinaryTree> nodes = getNodes(root);

  // 	for (int i = 1; i < nodes.size(); i++) {
  // 		BinaryTree leftNode = nodes.get(i - 1), rightNode = nodes.get(i);

  // 		leftNode.right = rightNode;
  // 		rightNode.left = leftNode;
  // 	}

  //   return nodes.get(0);
  // }

  // private static List<BinaryTree> getNodes(BinaryTree root) {
  // 	List<BinaryTree> nodes = new ArrayList<>();
  // 	getNodes(root, nodes);
  // 	return nodes;
  // }

  // private static void getNodes(BinaryTree root, List<BinaryTree> nodes) {
  // 	if (root != null) {
  // 		getNodes(root.left, nodes);
  // 		nodes.add(root);
  // 		getNodes(root.right, nodes);
  // 	}
  // }

  // This is the class of the input root. Do not edit it.
  static class BinaryTree {
    int value;
    BinaryTree left = null;
    BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}

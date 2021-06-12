package AlgoExSolutions.VeryHard.AllKindsOfNodeDepths;

// import java.util.*;

/**
 * * All Kinds of Node Depths
 */
class Program {
  /**
   * * [Most Optimized]
   *
   * * TC: O(n)
   * * SC: O(h)
   */
  public static int allKindsOfNodeDepths(BinaryTree root) {
    // Write your code here.
    return allKindsOfNodeDepths(root, 0);
  }

  private static int allKindsOfNodeDepths(BinaryTree root, int depth) {
    if (root == null) return 0;

    // Sum of all elements from 1 to depth
    int depthSum = (depth * (depth + 1)) / 2;

    // Either this or we can just keep on
    // adding the depth and passing it on
    // as a parameter

    return depthSum
        + allKindsOfNodeDepths(root.left, depth + 1)
        + allKindsOfNodeDepths(root.right, depth + 1);
  }

  /**
   * * [Optimized]
   *
   * * TC: O(n)
   * * SC: O(h)
   */
  // public static int allKindsOfNodeDepths(BinaryTree root) {
  //   return getTreeInfo(root).sumOfDepthsAtAllNodes;
  // }

  // private static TreeInfo getTreeInfo(BinaryTree node) {
  // 	if (node == null) return new TreeInfo(0, 0, 0);

  // 	TreeInfo lstInfo = getTreeInfo(node.left);
  // 	TreeInfo rstInfo = getTreeInfo(node.right);

  // 	int numberOfNodes = 1 + lstInfo.numberOfNodes + rstInfo.numberOfNodes;

  // 	int sumOfLeftDepths = lstInfo.sumOfDepths + lstInfo.numberOfNodes;
  // 	int sumOfRightDepths = rstInfo.sumOfDepths + rstInfo.numberOfNodes;
  // 	int sumOfDepths = sumOfLeftDepths + sumOfRightDepths;

  // 	int sumOfDepthsAtAllNodes = sumOfDepths + lstInfo.sumOfDepthsAtAllNodes +
  // 		rstInfo.sumOfDepthsAtAllNodes;

  // 	return new TreeInfo(
  // 		numberOfNodes, sumOfDepths, sumOfDepthsAtAllNodes
  // 	);
  // }

  // static class TreeInfo {
  // 	int numberOfNodes;
  // 	int sumOfDepths;
  // 	int sumOfDepthsAtAllNodes;

  // 	public TreeInfo(
  // 		int numberOfNodes, int sumOfDepths, int sumOfDepthsAtAllNodes
  // 	) {
  // 		this.numberOfNodes = numberOfNodes;
  // 		this.sumOfDepths = sumOfDepths;
  // 		this.sumOfDepthsAtAllNodes = sumOfDepthsAtAllNodes;
  // 	}
  // }

  /**
   * * [Brute Force] Iterative Solution
   *
   * * TC: O(n log(n))
   * * SC: O(h) space
   */
  // public static int allKindsOfNodeDepths(BinaryTree root) {
  // 	Stack<BinaryTree> stack = new Stack<>();
  // 	stack.add(root);
  // 	int totalNodeDepth = 0;

  // 	while (!stack.isEmpty()) {
  // 		BinaryTree node = stack.pop();
  // 		if (node == null) continue;

  // 		totalNodeDepth += nodeDepths(node, 0);

  // 		stack.push(node.left);
  // 		stack.push(node.right);
  // 	}

  //   return totalNodeDepth;
  // }

  /**
   * * [Brute Force]  Recursive Solution
   *
   * * TC: O(n log(n))
   * * SC: O(h) space
   */
  // 	public static int allKindsOfNodeDepths(BinaryTree root) {
  // 		if (root == null) return 0;

  // 		return nodeDepths(root, 0) +
  // 			allKindsOfNodeDepths(root.left) + allKindsOfNodeDepths(root.right);
  // 	}

  // private static int nodeDepths(BinaryTree node, int depth) {
  //   if (node == null) return 0;

  //   return depth + nodeDepths(node.left, depth + 1) + nodeDepths(node.right, depth + 1);
  // }

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

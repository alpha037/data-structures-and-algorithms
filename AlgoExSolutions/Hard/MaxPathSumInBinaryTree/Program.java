package AlgoExSolutions.Hard.MaxPathSumInBinaryTree;

// import java.util.*;

/**
 * * Max Path Sum In Binary Tree
 */
class Program {
  public static int maxPathSum(BinaryTree tree) {
    // Write your code here.
    return maxPathSumHelper(tree)[1];
  }

  /**
   * * TC: O(n)
   * * SC: O(log (n))
   */
  private static int[] maxPathSumHelper(BinaryTree root) {
    if (root == null) return new int[] {0, Integer.MIN_VALUE};

    int[] leftSumArray = maxPathSumHelper(root.left);
    int leftMaxSumAsBranch = leftSumArray[0], leftMaxPathSum = leftSumArray[1];

    int[] rightSumArray = maxPathSumHelper(root.right);
    int rightMaxSumAsBranch = rightSumArray[0], rightMaxPathSum = rightSumArray[1];

    int maxChildSumAsBranch = max(leftMaxSumAsBranch, rightMaxSumAsBranch);
    int maxSumAsBranch = max(maxChildSumAsBranch + root.value, root.value);
    int maxSumAsRootNode =
        max(leftMaxSumAsBranch + root.value + rightMaxSumAsBranch, maxSumAsBranch);
    int maxPathSum = max(leftMaxPathSum, rightMaxPathSum, maxSumAsRootNode);

    return new int[] {maxSumAsBranch, maxPathSum};
  }

  private static int max(int... nums) {
    int max = Integer.MIN_VALUE;
    for (int num : nums) max = Math.max(max, num);
    return max;
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}

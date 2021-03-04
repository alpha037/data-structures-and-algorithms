package AlgoExSolutions.Easy.FindClosestValueInBST;

// import java.util.*;

/**
 * * Find Closest Value In BST
 */
class Program {
  public static int findClosestValueInBstHelper(BST tree, int target, int closest) {
    if (tree == null) return closest;

    if (Math.abs(target - closest) > Math.abs(target - tree.value)) closest = tree.value;

    if (tree.value > target && tree.left != null)
      return findClosestValueInBstHelper(tree.left, target, closest);
    else if (tree.value < target && tree.right != null)
      return findClosestValueInBstHelper(tree.right, target, closest);

    return closest;
  }

  public static int findClosestValueInBst(BST tree, int target) {
    return findClosestValueInBstHelper(tree, target, tree.value);
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

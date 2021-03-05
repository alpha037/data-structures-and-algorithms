package AlgoExSolutions.Medium.MinHeightBST;

import java.util.*;

/**
 * * Min Height BST
 */
class Program {
  private static BST minHeightBst(List<Integer> array, int low, int high) {
    if (low > high) return null;

    int mid = low + (high - low) / 2;

    BST root = new BST(array.get(mid));

    root.left = minHeightBst(array, low, mid - 1);
    root.right = minHeightBst(array, mid + 1, high);

    return root;
  }

  public static BST minHeightBst(List<Integer> array) {
    // Write your code here.
    return minHeightBst(array, 0, array.size() - 1);
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
      left = null;
      right = null;
    }

    public void insert(int value) {
      if (value < this.value) {
        if (left == null) {
          left = new BST(value);
        } else {
          left.insert(value);
        }
      } else {
        if (right == null) {
          right = new BST(value);
        } else {
          right.insert(value);
        }
      }
    }
  }
}

package AlgoExSolutions.Medium.BSTConstruction;

// import java.util.*;

/**
 * * BST Construction
 */
class Program {
  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }

    public BST insert(int value) {
      // Write your code here.
      // Do not edit the return statement of this method.
      if (value < this.value) {
        if (left == null) {
          BST node = new BST(value);
          left = node;
        } else left.insert(value);
      } else {
        if (right == null) {
          BST node = new BST(value);
          right = node;
        } else right.insert(value);
      }

      return this;
    }

    public boolean contains(int value) {
      // Write your code here.
      if (this.value < value) {
        if (right == null) return false;
        else return right.contains(value);
      } else if (this.value > value) {
        if (left == null) return false;
        else return left.contains(value);
      }

      return true;
    }

    private int mininumValue() {
      if (left == null) return this.value;
      else return left.mininumValue();
    }

    private void remove(int value, BST root) {
      if (value < this.value) {
        if (left != null) left.remove(value, this);
      } else if (value > this.value) {
        if (right != null) right.remove(value, this);
      } else {
        if (left != null && right != null) {
          this.value = right.mininumValue();
          right.remove(this.value, this);
        } else if (root == null) {
          if (left != null) {
            this.value = left.value;
            right = left.right;
            left = left.left;
          } else if (right != null) {
            this.value = right.value;
            left = right.left;
            right = right.right;
          } else {
            // Single Node
          }
        } else if (root.left == this) root.left = left != null ? left : right;
        else if (root.right == this) root.right = left != null ? left : right;
      }
    }

    public BST remove(int value) {
      // Write your code here.
      // Do not edit the return statement of this method.
      remove(value, null);
      return this;
    }
  }
}

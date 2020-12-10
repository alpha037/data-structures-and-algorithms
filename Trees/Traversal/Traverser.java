package Trees.Traversal;

public class Traverser {

  // root -> left -> right
  public static void preOrder(Tree root) {
    if (root != null) {
      System.out.print(root.getNodeValue() + " ");
      preOrder(root.getLeftChild());
      preOrder(root.getRightChild());
    }
  }

  // left -> root -> right
  public static void inOrder(Tree root) {
    if (root != null) {
      inOrder(root.getLeftChild());
      System.out.print(root.getNodeValue() + " ");
      inOrder(root.getRightChild());
    }
  }

  // left -> right -> root
  public static void postOrder(Tree root) {
    if (root != null) {
      postOrder(root.getLeftChild());
      postOrder(root.getRightChild());
      System.out.print(root.getNodeValue() + " ");
    }
  }
}

class Tree {

  private int value;
  private Tree left;
  private Tree right;

  public Tree(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  public void insertLeft(Tree newNode) {
    if (this.left == null) this.left = newNode;
    else {
      newNode.left = this.left;
      this.left = newNode;
    }
  }

  public void insertRight(Tree newNode) {
    if (this.right == null) this.right = newNode;
    else {
      newNode.right = this.right;
      this.right = newNode;
    }
  }

  public Tree getLeftChild() {
    return this.left;
  }

  public Tree getRightChild() {
    return this.right;
  }

  public int getNodeValue() {
    return this.value;
  }

  public void setNodeValue(int value) {
    this.value = value;
  }
}

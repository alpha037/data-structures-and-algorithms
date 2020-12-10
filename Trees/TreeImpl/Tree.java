package Trees.TreeImpl;

public class Tree {

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

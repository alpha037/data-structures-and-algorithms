package Trees.BST;

public class BinarySearchTree {

  private TreeNode root;
  private int size;

  public enum TRAVERSE {
    PRE_ORDER,
    IN_ORDER,
    POST_ORDER
  }

  public BinarySearchTree() {
    this.root = null;
    this.size = 0;
  }

  // * ----- Getters -----

  public int size() {
    return this.size;
  }

  public TreeNode root() {
    return this.root;
  }

  // * ----- END -----

  // * ----- Private Helper Methods -----

  private TreeNode put(int key, String value, TreeNode current) {
    // Base case
    if (current == null) return new TreeNode(key, value);

    // if key is less than the current node key,
    // then keep on traversing the left subtree
    // recursively
    if (key < current.getKey()) current.left = put(key, value, current.left);

    // otherwise, if the key is greater than the
    // current node key, then keep on traversing
    // thr right subtree recursively
    else if (key > current.getKey()) current.right = put(key, value, current.right);

    // if the key already exists, then just
    // update the old value with the new one
    else current.setValue(value);

    return current;
  }

  private TreeNode get(int key, TreeNode current) {
    // Edge case
    if (current == null) return null;

    // Base case
    if (key == current.getKey()) return current;

    // Recursively traverse the left/right subtree,
    // if the key is less than/greater than the
    // current node key
    return key < current.getKey() ? get(key, current.left) : get(key, current.right);
  }

  private TreeNode findSuccessor(TreeNode node) {
    // This is because, the leftmost node
    // contains the minimum key according
    // to the BST property
    while (node.left != null) node = node.left;

    return node;
  }

  private TreeNode delete(int key, TreeNode current) {
    // Case 1: Node to be deleted has no children.
    // If the node has no children, then just make
    // node to be deleted null
    if (current.left == null && current.right == null) return null;

    // Case 2: Node to be deleted has only child.
    // If the node only has a left child, then
    // update the current node value with the
    // value of its left child
    if (current.right == null) return current.left;

    // If the node only has a right child, then
    // update the current node value with the
    // value of its right child
    if (current.left == null) return current.right;

    // Case 3: Node to be deleted has both the children.
    // If the node has both its children, then first find
    // the in-order successor of the node to be deleted.
    // The successor is the leftmost (minimum) node in
    // the right subtree of the node to be deleted.
    // This is because of the BST property. After that,
    // copy the successor's value into the node's (which
    // will be deleted) value and then delete the successor.
    TreeNode successor = findSuccessor(current.right);
    current.setKey(successor.getKey());
    current.setValue(successor.getValue());

    // We can further optimize this recursive call,
    // by keeping track of the successor's parent
    // in the findSuccessor(node) method.
    current.right = remove(successor.getKey(), current.right);

    /*
     TreeNode successorParent = current;
     TreeNode successor = findSuccessor(current.right);

     while (successor.left != null) {
       successorParent = successor;
       successor = successor.left;
     }

     NOTE:
       Since successor is always the left child of
       its parent so, we can safely make successor's
       right child as the left of its parent.
       If there is no successor, then we can
       just assign successor.right to
       successorParent.right

     if (successorParent != current)
       successorParent.left = successor.right;
     else
       successorParent.right = successor.right;

     current.setKey(successor.getKey());
     current.setValue(successor.getValue());
    */

    return current;
  }

  private TreeNode remove(int key, TreeNode current) {
    if (current == null) return null;

    if (key == current.getKey()) return delete(key, current);

    if (key < current.getKey()) {
      current.left = remove(key, current.left);
      return current;
    }

    current.right = remove(key, current.right);
    return current;
  }

  // Root -> Left -> Right
  private void preOrder(TreeNode node) {
    if (node != null) {
      System.out.println("Key: " + node.getKey() + " :: Value: " + node.getValue());
      preOrder(node.left);
      preOrder(node.right);
    }
  }

  // Left -> Root -> Right
  private void inOrder(TreeNode node) {
    if (node != null) {
      inOrder(node.left);
      System.out.println("Key: " + node.getKey() + " :: Value: " + node.getValue());
      inOrder(node.right);
    }
  }

  // Left -> Right -> Root
  private void postOrder(TreeNode node) {
    if (node != null) {
      postOrder(node.left);
      postOrder(node.right);
      System.out.println("Key: " + node.getKey() + " :: Value: " + node.getValue());
    }
  }

  // * ----- END -----

  // * ----- Instance Methods -----

  public void put(int key, String value) {
    size++;
    root = put(key, value, root);
  }

  public String get(int key) {
    return get(key, root).getValue();
  }

  public boolean containsKey(int key) {
    return get(key, root) != null;
  }

  public void remove(int key) {
    size--;
    root = remove(key, root);
  }

  public void traverse(TRAVERSE type) {
    switch (type) {
      case PRE_ORDER:
        System.out.println("\nTraversing in pre-order: \n");
        preOrder(root);
        break;

      case IN_ORDER:
        System.out.println("\nTraversing in in-order: \n");
        inOrder(root);
        break;

      case POST_ORDER:
        System.out.println("\nTraversing in post-order: \n");
        postOrder(root);
        break;

      default:
        System.out.println("Invalid type.");
    }
  }

  // * ----- END -----
}

// * ----- Auxillary Class -----

class TreeNode {

  private int key;
  private String value;
  TreeNode left;
  TreeNode right;

  public TreeNode(int key, String value) {
    this.key = key;
    this.value = value;
    left = null;
    right = null;
  }

  public int getKey() {
    return this.key;
  }

  public String getValue() {
    return this.value;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
// * ----- END -----

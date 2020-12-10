package Trees.Traversal;

public class TraverserTest {
  public static void main(String[] args) {
    Tree root = new Tree(10);

    // insert left subtree
    root.insertLeft(new Tree(40));
    root.insertLeft(new Tree(30));
    root.insertLeft(new Tree(20));

    // insert right subtree
    root.insertRight(new Tree(70));
    root.insertRight(new Tree(60));
    root.insertRight(new Tree(50));

    // Pre-order traversal
    System.out.println("\nPre-order traversal: ");
    Traverser.preOrder(root);

    // In-order traversal
    System.out.println("\n\nIn-order traversal: ");
    Traverser.inOrder(root);

    // Post-order traversal
    System.out.println("\n\nPost-order traversal: ");
    Traverser.postOrder(root);
  }
}

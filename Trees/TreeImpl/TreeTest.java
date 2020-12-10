package Trees.TreeImpl;

public class TreeTest {
  public static void main(String[] args) {
    Tree root = new Tree(10);

    root.insertLeft(new Tree(40));
    root.insertLeft(new Tree(30));
    root.insertLeft(new Tree(20));

    root.insertRight(new Tree(70));
    root.insertRight(new Tree(60));
    root.insertRight(new Tree(50));

    // root value -> 10
    System.out.println("Root -> " + root.getNodeValue());

    // left subtree values
    System.out.println("\nLeft Subtree: ");
    System.out.println(root.getLeftChild().getNodeValue());
    System.out.println(root.getLeftChild().getLeftChild().getNodeValue());
    System.out.println(root.getLeftChild().getLeftChild().getLeftChild().getNodeValue());

    // right subtree values
    System.out.println("\nRight Subtree: ");
    System.out.println(root.getRightChild().getNodeValue());
    System.out.println(root.getRightChild().getRightChild().getNodeValue());
    System.out.println(root.getRightChild().getRightChild().getRightChild().getNodeValue());
  }
}

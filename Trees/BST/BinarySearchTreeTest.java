package Trees.BST;

import Trees.BST.BinarySearchTree.TRAVERSE;

public class BinarySearchTreeTest {
  public static void main(String[] args) {

    BinarySearchTree tree = new BinarySearchTree();

    System.out.println("\nInserting items...");
    tree.put(50, "Alpha");
    tree.put(30, "Bravo");
    tree.put(20, "Charlie");
    tree.put(40, "Echo");
    tree.put(70, "Delta");
    tree.put(60, "Lima");
    tree.put(80, "Zulu");

    tree.traverse(TRAVERSE.IN_ORDER);

    // should be 7
    System.out.println("Size: " + tree.size());

    // Case 1 deletion.
    System.out.println("\nRemoving key: 20");
    tree.remove(20);
    tree.traverse(TRAVERSE.IN_ORDER);

    // Case 2 deletion.
    System.out.println("\nRemoving key: 30");
    tree.remove(30);
    tree.traverse(TRAVERSE.IN_ORDER);

    // Case 3 deletion.
    System.out.println("\nRemoving key: 50");
    tree.remove(50);
    tree.traverse(TRAVERSE.IN_ORDER);

    // should be 4
    System.out.println("Size: " + tree.size());

    // should be true
    System.out.println("\n" + tree.containsKey(80));

    // should be false
    System.out.println("\n" + tree.containsKey(30));
  }
}

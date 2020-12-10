package LinkedLists.DoublyLinkedList;

public class NodeTest {
  public static void main(String[] args) {
    Node<Integer> a = new Node<Integer>(10);
    Node<Integer> b = new Node<Integer>(20);
    Node<Integer> c = new Node<Integer>(30);

    a.next = b;

    b.prev = a;
    b.next = c;

    c.prev = b;

    System.out.println("\nFrom Node a: ");
    System.out.println(a.val); // 10
    System.out.println(a.next.val); // 20
    System.out.println(a.next.next.val); // 30

    System.out.println("\nFrom Node b: ");
    System.out.println(b.prev.val); // 10
    System.out.println(b.val); // 20
    System.out.println(b.next.val); // 30

    System.out.println("\nFrom Node c: ");
    System.out.println(c.prev.prev.val); // 10
    System.out.println(c.prev.val); // 20
    System.out.println(c.val); // 30
  }
}

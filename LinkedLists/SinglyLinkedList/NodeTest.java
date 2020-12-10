package LinkedLists.SinglyLinkedList;

public class NodeTest {
  public static void main(String[] args) {
    Node<Integer> a = new Node<Integer>(10);
    Node<Integer> b = new Node<Integer>(20);
    Node<Integer> c = new Node<Integer>(30);
    Node<Integer> d = new Node<Integer>(40);
    Node<Integer> e = new Node<Integer>(50);

    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;

    System.out.println(a.val); // 10
    System.out.println(a.next.val); // 20
    System.out.println(a.next.next.val); // 30
    System.out.println(a.next.next.next.val); // 40
    System.out.println(a.next.next.next.next.val); // 50
  }
}

package LinkedLists.Reverser;

public class ReverserTest {
  public static void main(String[] args) {
    Node a = new Node(10);
    Node b = new Node(20);
    Node c = new Node(30);
    Node d = new Node(40);

    a.next = b;
    b.next = c;
    c.next = d;

    System.out.println("\nBefore reversing...");
    System.out.println(a.val); // 10
    System.out.println(a.next.val); // 20
    System.out.println(a.next.next.val); // 30
    System.out.println(a.next.next.next.val); // 40
    // System.out.println(d.next.val); // null

    Reverser.reverse(a);

    System.out.println("\nAfter reversing...");
    System.out.println(d.val); // 40
    System.out.println(d.next.val); // 30
    System.out.println(d.next.next.val); // 20
    System.out.println(d.next.next.next.val); // 10
    // System.out.println(a.next.val); // null
  }
}

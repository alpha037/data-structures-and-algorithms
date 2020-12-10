package LinkedLists.NthToLast;

public class NthToLastTest {
  public static void main(String[] args) {
    Node a = new Node(10);
    Node b = new Node(20);
    Node c = new Node(30);
    Node d = new Node(40);
    Node e = new Node(50);

    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;

    // should be 40
    System.out.println(NthToLast.getNode(a, 2).val);

    // should be 50
    System.out.println(NthToLast.getNode(a, 1).val);

    // should be 40
    System.out.println(NthToLast.getNode(a, 5).val);

    // should be null
    // System.out.println(NthToLast.getNode(a, 6).val);

    // should be null
    System.out.println(NthToLast.getNode(null, 3).val);
  }
}

package LinkedLists.CycleChecker;

public class CycleCheckerTest {
  public static void main(String[] args) {
    Node a = new Node(10);
    Node b = new Node(20);
    Node c = new Node(30);

    a.next = b;
    b.next = c;
    c.next = a;

    // should be true
    System.out.println(CycleChecker.hasCycles(a));

    Node x = new Node(10);
    Node y = new Node(20);
    Node z = new Node(30);

    x.next = y;
    y.next = z;

    // should be false
    System.out.println(CycleChecker.hasCycles(x));
  }
}

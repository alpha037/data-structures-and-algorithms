package LinkedLists.Reverser;

public class Reverser {
  public static Node reverse(Node head) {

    Node prev = null, next = null;
    Node curr = head;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;

      prev = curr;
      curr = next;
    }

    return prev;
  }
}

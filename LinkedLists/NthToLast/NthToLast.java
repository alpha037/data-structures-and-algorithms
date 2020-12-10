package LinkedLists.NthToLast;

public class NthToLast {
  public static Node getNode(Node head, int n) {

    // * Edge Case
    if (head == null) return null;

    int length = 0;
    Node curr = head;

    while (curr != null) {
      length++;
      curr = curr.next;
    }

    // * Edge Cases
    if (length == n) return head;

    if (n > length) return null;

    curr = head;
    for (int i = 0; i < length - n; i++) curr = curr.next;

    return curr;
  }
}

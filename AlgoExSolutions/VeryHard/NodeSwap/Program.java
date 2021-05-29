package AlgoExSolutions.VeryHard.NodeSwap;

// import java.util.*;

/**
 * * Node Swap
 */
class Program {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  /**
   * * Iterative Approach
   *
   * * TC: O(n)
   * * SC: O(1)
   */
  public LinkedList nodeSwap(LinkedList head) {
    // Write your code here.
    if (head == null || head.next == null) return head;

    LinkedList dummy = new LinkedList(-1);
    LinkedList prevNode = dummy, first = head, second = head.next;

    while (second != null) {
      LinkedList nextNode = second.next;

      second.next = first;
      first.next = nextNode;
      prevNode.next = second;

      prevNode = first;
      first = nextNode;
      second = nextNode == null ? null : nextNode.next;
    }

    return dummy.next;
  }

  /**
   * * Recursive Approach
   *
   * * TC: O(n)
   * * SC: O(n)
   */
  // public LinkedList nodeSwap(LinkedList head) {
  // 	if (head == null || head.next == null) return head;

  // 	LinkedList nextNode = head.next;
  // 	head.next = nodeSwap(head.next.next);
  // 	nextNode.next = head;

  //   return nextNode;
  // }
}

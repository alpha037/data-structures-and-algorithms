package AlgoExSolutions.VeryHard.RearrangeLinkedList;

// import java.util.*;

/**
 * * Rearrange Linked List
 */
class Program {
  /**
   * * TC: O(n)
   * * SC: O(1)
   */
  public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
    // Write your code here.
    LinkedList smallerListHead = null, smallerListTail = null;
    LinkedList equalListHead = null, equalListTail = null;
    LinkedList largerListHead = null, largerListTail = null;
    LinkedList node = head;

    while (node != null) {
      if (node.value < k) {
        LinkedList[] list = growList(smallerListHead, smallerListTail, node);
        smallerListHead = list[0];
        smallerListTail = list[1];
      } else if (node.value > k) {
        LinkedList[] list = growList(largerListHead, largerListTail, node);
        largerListHead = list[0];
        largerListTail = list[1];
      } else {
        LinkedList[] list = growList(equalListHead, equalListTail, node);
        equalListHead = list[0];
        equalListTail = list[1];
      }

      LinkedList prevNode = node;
      node = node.next;
      prevNode.next = null;
    }

    LinkedList[] firstPair =
        connectList(smallerListHead, smallerListTail, equalListHead, equalListTail);
    LinkedList[] finalPair =
        connectList(firstPair[0], firstPair[1], largerListHead, largerListTail);

    return finalPair[0];
  }

  private static LinkedList[] growList(LinkedList head, LinkedList tail, LinkedList node) {
    LinkedList newHead = head, newTail = node;

    if (newHead == null) newHead = node;
    else if (tail != null) tail.next = newTail;

    return new LinkedList[] {newHead, newTail};
  }

  private static LinkedList[] connectList(
      LinkedList headOne, LinkedList tailOne, LinkedList headTwo, LinkedList tailTwo) {
    LinkedList newHead = headOne == null ? headTwo : headOne;
    LinkedList newTail = tailTwo == null ? tailOne : tailTwo;

    if (tailOne != null) tailOne.next = headTwo;

    return new LinkedList[] {newHead, newTail};
  }

  static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      next = null;
    }
  }
}

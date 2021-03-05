package AlgoExSolutions.Medium.SumofLinkedLists;

// import java.util.*;

/**
 * * Sum Of Linked Lists
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

  public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
    // Write your code here.
    LinkedList res = new LinkedList(-1), currNode = res;
    LinkedList l1 = linkedListOne, l2 = linkedListTwo;
    int sum = 0, carry = 0;

    while (l1 != null || l2 != null) {
      int value1 = l1 != null ? l1.value : 0;
      int value2 = l2 != null ? l2.value : 0;

      sum = carry + value1 + value2;

      currNode.next = new LinkedList(sum % 10);
      carry = sum / 10;

      l1 = l1 != null ? l1.next : null;
      l2 = l2 != null ? l2.next : null;
      currNode = currNode.next;
    }

    if (carry != 0) currNode.next = new LinkedList(carry);

    return res.next;
  }
}

package AlgoExSolutions.Hard.MergeLinkedList;

// import java.util.*;

/**
 * * Merge Linked List
 */
class Program {
  // This is an input class. Do not edit.
  public static class LinkedList {
    int value;
    LinkedList next;

    LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  /**
   * * Iterative Approach
   * * TC: O(m + n)
   * * SC: O(1)
   */
  public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
    // Write your code here.
    if (headOne == null) return headTwo;

    if (headTwo == null) return headOne;

    LinkedList p1 = headOne, p2 = headTwo;
    LinkedList res = null;

    while (p1 != null && p2 != null) {
      if (p1.value < p2.value) {
        res = p1;
        p1 = p1.next;
      } else {
        if (res != null) res.next = p2;
        res = p2;
        p2 = p2.next;
        res.next = p1;
      }
    }

    if (p1 == null) res.next = p2;

    if (p2 == null) res.next = p1;

    return headOne.value < headTwo.value ? headOne : headTwo;
  }

  /**
   * * Recursive Approach
   * * TC: O(m + n)
   * * SC:  O(m + n)
   */
  // public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
  //   // Write your code here.
  // 	if (headOne == null) return headTwo;

  // 	if (headTwo == null) return headOne;

  // 	if (headOne.value <= headTwo.value) {
  // 		headOne.next = mergeLinkedLists(headOne.next, headTwo);
  // 		return headOne;
  // 	}

  // 	headTwo.next = mergeLinkedLists(headOne, headTwo.next);
  //   return headTwo;
  // }
}

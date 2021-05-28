package AlgoExSolutions.VeryHard.LinkedListPalindrome;

// import java.util.*;

/**
 * * Linked List Palindrome
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
   * * Two Pointer Approach
   *
   * * TC: O(n)
   * * SC: O(1)
   */
  public boolean linkedListPalindrome(LinkedList head) {
    // Write your code here.
    LinkedList slow = head, fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    fast = reverse(slow);
    slow = head;

    while (fast != null) {
      if (slow.value != fast.value) return false;

      slow = slow.next;
      fast = fast.next;
    }

    return true;
  }

  private LinkedList reverse(LinkedList node) {
    LinkedList prevNode = null, nextNode = null;
    while (node != null) {
      nextNode = node.next;
      node.next = prevNode;

      prevNode = node;
      node = nextNode;
    }
    return prevNode;
  }

  /**
   * * Recursive Approach
   *
   * * TC: O(n)
   * * SC: O(n)
   */
  // public boolean linkedListPalindrome(LinkedList head) {
  //   return linkedListPalindrome(head, head).isPalindrome;
  // }

  // private LinkedListInfo linkedListPalindrome(
  // 	LinkedList head, LinkedList tail
  // ) {
  // 	if (tail == null) return new LinkedListInfo(head, true);

  // 	LinkedListInfo info = linkedListPalindrome(head, tail.next);
  // 	LinkedList currentHead = info.head;

  // 	boolean isPalindrome = info.isPalindrome && currentHead.value == tail.value;

  // 	return new LinkedListInfo(currentHead.next, isPalindrome);
  // }

  // public static class LinkedListInfo {
  // 	public LinkedList head;
  // 	boolean isPalindrome;

  // 	public LinkedListInfo(LinkedList head, boolean isPalindrome) {
  // 		this.head = head;
  // 		this.isPalindrome = isPalindrome;
  // 	}
  // }
}

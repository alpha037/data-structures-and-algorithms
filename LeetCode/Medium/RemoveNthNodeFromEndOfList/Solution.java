package LeetCode.Medium.RemoveNthNodeFromEndOfList;

/*
  19. Remove Nth Node From End of List

  Given the head of a linked list, remove the nth node from the end of the list and return its head.

  Follow up: Could you do this in one pass?

  Example 1:
  Input: head = [1,2,3,4,5], n = 2
  Output: [1,2,3,5]

  Example 2:
  Input: head = [1], n = 1
  Output: []

  Example 3:
  Input: head = [1,2], n = 1
  Output: [1]


  Constraints:
  The number of nodes in the list is sz.
  1 <= sz <= 30
  0 <= Node.val <= 100
  1 <= n <= sz
*/

class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) return null;

    /**
     * * Two pass approach
     */

    // int len = 0, count = 0;
    // ListNode dummy = new ListNode(-1), p = dummy;
    // dummy.next = head;

    // while (p.next != null) {
    //   ++len;
    //   p = p.next;
    // }

    // if (len == n)
    //   return new ListNode();

    // p = head;

    // while (p != null) {
    //   ++count;

    //   if (count == (len - n)) {
    //     p.next = p.next.next;
    //     break;
    //   }

    //   p = p.next;
    // }

    // return dummy.next;

    /**
     * * Single pass approach
     */
    ListNode dummy = new ListNode(-1);
    ListNode fast = dummy, slow = dummy;
    dummy.next = head;

    // Since, fast pointer has
    // to be n distance apart
    // from the slow pointer
    for (int i = 0; i < n; i++) fast = fast.next;

    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;

    return dummy.next;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    head = solution.removeNthFromEnd(head, 2);

    ListNode p = head;
    while (p != null) {
      System.out.print(p.val + " ");
      p = p.next;
    }
  }
}

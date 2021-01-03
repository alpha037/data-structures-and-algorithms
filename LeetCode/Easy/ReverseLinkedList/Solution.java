package LeetCode.Easy.ReverseLinkedList;

/*
  206. Reverse Linked List

  Reverse a singly linked list.

  Example:
  Input: 1->2->3->4->5->NULL
  Output: 5->4->3->2->1->NULL

  Follow up:
  A linked list can be reversed either iteratively or recursively. Could you implement both?
*/

// Definition for singly-linked list.
// Not needed in the actual code.
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
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;

    /**
     * * Recursive approach
     */

    // ListNode rest = reverseList(head.next);

    // head.next.next = head;
    // head.next = null;

    // return rest;

    /**
     * * Iterative approach
     */
    ListNode curr = head, prev = null, next = null;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;

      prev = curr;
      curr = next;
    }

    return prev;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    ListNode head = new ListNode(5);
    head.next = new ListNode(4);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(1);

    head = solution.reverseList(head);

    // should be 1 -> 2 -> 3 -> 4 -> 5
    ListNode p = head;
    while (p != null) {
      System.out.print(p.val + " ");
      p = p.next;
    }
  }
}

package LeetCode.Easy.RemoveLinkedListElements;

/*
  203. Remove Linked List Elements

  Remove all elements from a linked list of integers that have value val.

  Example:
  Input:  1->2->6->3->4->5->6, val = 6
  Output: 1->2->3->4->5
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
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) return null;

    ListNode dummy = new ListNode(), p = dummy;
    dummy.next = head;

    while (head != null) {
      if (head.val == val) p.next = head.next;
      else p = head;

      head = head.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next.next = new ListNode(6);

    head = solution.removeElements(head, 6);

    // should be 1 -> 2 -> 3 -> 4 -> 5
    ListNode p = head;
    while (p != null) {
      System.out.print(p.val + " ");
      p = p.next;
    }
  }
}

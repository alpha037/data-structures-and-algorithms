package LeetCode.Easy.RemoveDuplicatesFromSortedList;

/*
  83. Remove Duplicates from Sorted List

  Given a sorted linked list, delete all duplicates such that each element appear only once.

  Example 1:
  Input: 1->1->2
  Output: 1->2

  Example 2:
  Input: 1->1->2->3->3
  Output: 1->2->3
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
  public ListNode deleteDuplicates(ListNode head) {

    if (head == null) return null;

    if (head.next == null) return head;

    ListNode tracker = head;

    while (tracker.next != null) {
      if (tracker.val == tracker.next.val) tracker.next = tracker.next.next;
      else tracker = tracker.next;
    }

    return head;
  }

  public static void main(String[] args) {
    ListNode a = new ListNode(10);
    ListNode b = new ListNode(20);
    ListNode c = new ListNode(20);
    ListNode d = new ListNode(30);

    a.next = b;
    b.next = c;
    c.next = d;
    d.next = null;

    ListNode node = a;
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }

    System.out.println();

    Solution solution = new Solution();
    a = solution.deleteDuplicates(a);

    node = a;
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }
}

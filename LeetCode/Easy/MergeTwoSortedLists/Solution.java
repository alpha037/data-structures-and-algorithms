package LeetCode.Easy.MergeTwoSortedLists;

/*
21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.


Example 1:
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: l1 = [], l2 = []
Output: []

Example 3:
Input: l1 = [], l2 = [0]
Output: [0]

Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.
*/

// * Definition for singly-linked list.
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
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;

    if (l2 == null) return l1;

    // Recursive approach
    // if (l1.val < l2.val) {
    //   l1.next = mergeTwoLists(l1.next, l2);
    //   return l1;
    // }

    // l2.next = mergeTwoLists(l1, l2.next);
    // return l2;

    ListNode res = new ListNode();
    ListNode tail = res;

    while (true) {

      if (l1 == null) {
        tail.next = l2;
        break;
      }

      if (l2 == null) {
        tail.next = l1;
        break;
      }

      if (l1.val <= l2.val) {
        tail.next = l1;
        l1 = l1.next;
      } else {
        tail.next = l2;
        l2 = l2.next;
      }

      tail = tail.next;
    }

    return res.next;
  }
}

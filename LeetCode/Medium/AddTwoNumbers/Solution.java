package LeetCode.Medium.AddTwoNumbers;

/*
  2. Add Two Numbers

  You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

  You may assume the two numbers do not contain any leading zero, except the number 0 itself.


  Example 1:
  Input: l1 = [2,4,3], l2 = [5,6,4]
  Output: [7,0,8]
  Explanation: 342 + 465 = 807.

  Example 2:
  Input: l1 = [0], l2 = [0]
  Output: [0]

  Example 3:
  Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
  Output: [8,9,9,9,0,0,0,1]


  Constraints:
  The number of nodes in each linked list is in the range [1, 100].
  0 <= Node.val <= 9
  It is guaranteed that the list represents a number that does not have leading zeros.
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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) return null;

    if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

    ListNode head = new ListNode(-1);
    ListNode l3 = head;
    int carry = 0;

    while (l1 != null || l2 != null) {
      int firstVal = l1 != null ? l1.val : 0;
      int secondVal = l2 != null ? l2.val : 0;
      int res = firstVal + secondVal + carry;

      l3.next = new ListNode(res % 10);
      carry = res / 10;

      l1 = l1 != null ? l1.next : null;
      l2 = l2 != null ? l2.next : null;
      l3 = l3.next;
    }

    if (carry != 0) l3.next = new ListNode(carry);

    return head.next;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    ListNode l1 = new ListNode(9);
    l1.next = new ListNode(9);

    ListNode l2 = new ListNode(9);
    l2.next = new ListNode(9);
    l2.next.next = new ListNode(9);
    l2.next.next.next = new ListNode(9);
    l2.next.next.next.next = new ListNode(9);

    ListNode res = solution.addTwoNumbers(l1, l2);

    // should be 8 9 0 0 0 1
    while (res != null) {
      System.out.print(res.val + " ");
      res = res.next;
    }
  }
}

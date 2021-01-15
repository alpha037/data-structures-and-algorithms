package LeetCode.Medium.SwapNodesInPairs;

/*
  24. Swap Nodes in Pairs

  Given a linked list, swap every two adjacent nodes and return its head.


  Example 1:
  Input: head = [1,2,3,4]
  Output: [2,1,4,3]

  Example 2:
  Input: head = []
  Output: []

  Example 3:
  Input: head = [1]
  Output: [1]


  Constraints:
  The number of nodes in the list is in the range [0, 100].
  0 <= Node.val <= 100


  Follow up: Can you solve the problem without modifying the values in the list's nodes? (i.e., Only nodes themselves may be changed.)
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
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;

    /**
     * * Swapping values only
     */

    // ListNode p = head, q = head.next;
    // int temp = 0;

    // while (q != null) {
    //   temp = p.val;
    //   p.val = q.val;
    //   q.val = temp;

    //   p = p.next != null ? p.next.next : null;
    //   q = q.next != null ? q.next.next : null;
    // }

    // return head;

    /**
     * * Swapping actual nodes - Recursive approach
     */
    ListNode current = head;
    ListNode next = head.next;
    ListNode farNext = next.next;

    next.next = current;
    current.next = swapPairs(farNext);

    return next;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);

    head = solution.swapPairs(head);

    ListNode p = head;
    while (p != null) {
      System.out.print(p.val + " ");
      p = p.next;
    }
  }
}

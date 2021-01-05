package LeetCode.Easy.PalindromeLinkedList;

// import java.util.Stack;

/*
  234. Palindrome Linked List

  Given a singly linked list, determine if it is a palindrome.

  Example 1:
  Input: 1->2
  Output: false

  Example 2:
  Input: 1->2->2->1
  Output: true

  Follow up:
  Could you do it in O(n) time and O(1) space?
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
  public boolean isPalindrome(ListNode head) {
    if (head == null) return false;

    if (head.next == null) return true;

    /**
     * * Stack approach
     * * TC: O(n), SC: O(n)
     */

    // Stack<ListNode> stack = new Stack<>();

    // ListNode curr = head;
    // while (curr != null) {
    //   stack.push(curr);
    //   curr = curr.next;
    // }

    // curr = head;
    // while (!stack.isEmpty()) {
    //   if (curr.val != stack.pop().val)
    //     return false;

    //   curr = curr.next;
    // }

    // return true;

    /**
     * * Two-pointer approach
     * * TC: O(n), SC: O(1)
     */

    // First, get the midpoint
    // of the list
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // Then, reverse the list from
    // the midpoint
    ListNode curr = slow, next = null, prev = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;

      prev = curr;
      curr = next;
    }

    // Re-initialize the fast
    // pointer to the head and
    // the slow pointer to the
    // prev (end of the list)
    fast = head;
    slow = prev;

    // Check if fast and slow
    // pointers contain the
    // same value of not
    while (slow != null) {
      if (slow.val != fast.val) return false;

      slow = slow.next;
      fast = fast.next;
    }

    return true;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(1);

    // should be true
    System.out.println(solution.isPalindrome(head));

    head = new ListNode(1);
    head.next = new ListNode(2);

    // should be false
    System.out.println(solution.isPalindrome(head));
  }
}

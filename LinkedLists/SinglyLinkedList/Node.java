package LinkedLists.SinglyLinkedList;

public class Node<T> {

  // Generic Types
  T val;
  Node<T> next;

  public Node(T val) {
    this.val = val;
    this.next = null;
  }
}

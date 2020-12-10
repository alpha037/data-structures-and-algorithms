package LinkedLists.DoublyLinkedList;

public class Node<T> {

  // Generic Types
  T val;
  Node<T> prev;
  Node<T> next;

  public Node(T val) {
    this.val = val;
    this.prev = this.next = null;
  }
}

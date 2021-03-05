package AlgoExSolutions.Medium.LinkedListConstruction;

// import java.util.*;

/**
 * * Linked List Construction
 */

// Feel free to add new properties and methods to the class.
class Program {
  static class DoublyLinkedList {
    public Node head;
    public Node tail;

    public void setHead(Node node) {
      // Write your code here.
      if (head == null) {
        head = node;
        tail = node;
        return;
      }

      insertBefore(head, node);
    }

    public void setTail(Node node) {
      // Write your code here.
      if (tail == null) {
        setHead(node);
        return;
      }

      insertAfter(tail, node);
    }

    public void insertBefore(Node node, Node nodeToInsert) {
      // Write your code here.
      if (nodeToInsert == head && nodeToInsert == tail) return;

      remove(nodeToInsert);

      nodeToInsert.prev = node.prev;
      nodeToInsert.next = node;

      if (node.prev == null) head = nodeToInsert;
      else node.prev.next = nodeToInsert;

      node.prev = nodeToInsert;
    }

    public void insertAfter(Node node, Node nodeToInsert) {
      // Write your code here.
      if (nodeToInsert == head && nodeToInsert == tail) return;

      remove(nodeToInsert);

      nodeToInsert.prev = node;
      nodeToInsert.next = node.next;

      if (node.next == null) tail = nodeToInsert;
      else node.next.prev = nodeToInsert;

      node.next = nodeToInsert;
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
      // Write your code here.
      if (position == 1) {
        setHead(nodeToInsert);
        return;
      }

      int currentPos = 1;
      Node tracker = head;

      while (tracker != null && currentPos++ != position) tracker = tracker.next;

      if (tracker == null) {
        setTail(nodeToInsert);
        return;
      }

      insertBefore(tracker, nodeToInsert);
    }

    public void removeNodesWithValue(int value) {
      // Write your code here.
      Node nextNode = head;
      while (nextNode != null) {
        Node currNode = nextNode;
        nextNode = nextNode.next;

        if (currNode.value == value) remove(currNode);
      }
    }

    public void remove(Node node) {
      // Write your code here.
      if (node == head) head = head.next;

      if (node == tail) tail = tail.prev;

      removeNode(node);
    }

    private void removeNode(Node node) {
      if (node.prev != null) node.prev.next = node.next;

      if (node.next != null) node.next.prev = node.prev;

      node.prev = null;
      node.next = null;
    }

    public boolean containsNodeWithValue(int value) {
      // Write your code here.
      Node node = head;

      while (node != null && node.value != value) node = node.next;

      return node != null;
    }
  }

  // Do not edit the class below.
  static class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}

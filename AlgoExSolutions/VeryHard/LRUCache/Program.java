package AlgoExSolutions.VeryHard.LRUCache;

import java.util.*;

/**
 * * LRU Cache
 */

// Do not edit the class below except for the insertKeyValuePair,
// getValueFromKey, and getMostRecentKey methods. Feel free
// to add new properties and methods to the class.
class Program {
  static class LRUCache {
    int maxSize;
    Map<String, Node> map = new HashMap<>();
    DoublyLinkedList linkedList = new DoublyLinkedList();

    public LRUCache(int maxSize) {
      this.maxSize = maxSize > 1 ? maxSize : 1;
    }

    // * TC: O(1), SC: O(1)
    public void insertKeyValuePair(String key, int value) {
      // Write your code here.
      if (map.containsKey(key)) {
        updateMostRecentKey(key);
        map.get(key).value = value;
      } else {
        Node node = new Node(key, value);
        linkedList.setHead(node);
        map.put(key, node);

        if (map.size() > maxSize) updateLeastRecentKey();
      }
    }

    // * TC: O(1), SC: O(1)
    public LRUResult getValueFromKey(String key) {
      // Write your code here.
      LRUResult res = null;
      if (map.containsKey(key)) {
        updateMostRecentKey(key);
        res = new LRUResult(true, map.get(key).value);
      }
      return res;
    }

    // * TC: O(1), SC: O(1)
    public String getMostRecentKey() {
      // Write your code here.
      return linkedList.head.key;
    }

    private void updateMostRecentKey(String key) {
      Node node = map.get(key);
      linkedList.remove(node);
      linkedList.setHead(node);
    }

    private void updateLeastRecentKey() {
      String leastRecentKey = linkedList.tail.key;
      linkedList.remove(linkedList.tail);
      map.remove(leastRecentKey);
    }
  }

  static class LRUResult {
    boolean found;
    int value;

    public LRUResult(boolean found, int value) {
      this.found = found;
      this.value = value;
    }
  }

  static class DoublyLinkedList {
    Node head = null, tail = null;

    public void setHead(Node node) {
      if (head == null) {
        head = node;
        tail = node;
        return;
      }

      insertBefore(head, node);
    }

    private void insertBefore(Node node, Node nodeToInsert) {
      if (nodeToInsert == head && nodeToInsert == tail) return;

      remove(nodeToInsert);

      nodeToInsert.prev = node.prev;
      nodeToInsert.next = node;

      if (node.prev == null) head = nodeToInsert;
      else node.prev.next = nodeToInsert;

      node.prev = nodeToInsert;
    }

    public void remove(Node node) {
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
  }

  static class Node {
    String key;
    int value;
    Node prev = null, next = null;

    public Node(String key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}

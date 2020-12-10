package StacksAndQueues.Queue;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {

  private List<T> list;

  /**
   * Constructor for the Queue
   */
  public Queue() {
    this.list = new ArrayList<>();
  }

  /**
   * Pushes an item into the queue
   *
   * @param item : The element to be pushed into the queue
   */
  public void enqueue(T item) {
    this.list.add(item);
  }

  /**
   * Returns and removes the first item from the queue
   *
   * @return A T value containing the first item from the queue after removing it
   */
  public T dequeue() {
    return this.list.remove(0);
  }

  /**
   * Returns true if the queue is empty, otherwise false
   *
   * @return A boolean value determining if the queue is empty or not
   */
  public boolean isEmpty() {
    return this.list.isEmpty();
  }

  /**
   * The current size of the queue
   *
   * @return An integer value containing the current size of the queue
   */
  public int size() {
    return this.list.size();
  }

  @Override
  public String toString() {
    return this.list.toString();
  }
}

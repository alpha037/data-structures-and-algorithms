package StacksAndQueues.Deque;

import java.util.ArrayList;
import java.util.List;

public class Deque<T> {

  private List<T> list;

  /**
   * Constructor for the Deque
   */
  public Deque() {
    this.list = new ArrayList<>();
  }

  /**
   * Pushes an item into the front of the deque
   *
   * @param item : The element to be pushed into the deque
   */
  public void addFront(T item) {
    this.list.add(0, item);
  }

  /**
   * Pushes an item into the rear of the deque
   *
   * @param item : The element to be pushed into the deque
   */
  public void addRear(T item) {
    this.list.add(item);
  }

  /**
   * Returns and removes the first item from the front of the deque
   *
   * @return A T value containing the first item from the deque after removing it
   */
  public T removeFront() {
    return this.list.remove(0);
  }

  /**
   * Returns and removes the last item from the rear of the deque
   *
   * @return A T value containing the last item from the deque after removing it
   */
  public T removeRear() {
    return this.list.remove(this.list.size() - 1);
  }

  /**
   * Returns true if the deque is empty, otherwise false
   *
   * @return A boolean value determining if the deque is empty or not
   */
  public boolean isEmpty() {
    return this.list.isEmpty();
  }

  /**
   * The current size of the deque
   *
   * @return An integer value containing the current size of the deque
   */
  public int size() {
    return this.list.size();
  }

  @Override
  public String toString() {
    return this.list.toString();
  }
}

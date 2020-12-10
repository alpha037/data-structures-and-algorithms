package StacksAndQueues.QueueWithTwoStacks;

import java.util.Stack;

public class QueueWithTwoStacks<T> {

  private Stack<T> inStack;
  private Stack<T> outStack;

  public QueueWithTwoStacks() {
    this.inStack = new Stack<>();
    this.outStack = new Stack<>();
  }

  private void reverseOrder() {
    if (!this.outStack.isEmpty()) return;

    System.out.println("\nReversing the order...");

    for (int i = 0; i < inStack.size(); ) this.outStack.push(this.inStack.pop());
  }

  public void enqueue(T item) {
    this.inStack.push(item);
  }

  public T dequeue() {
    this.reverseOrder();
    return this.outStack.pop();
  }

  public boolean isEmpty() {
    return this.inStack.isEmpty() == this.outStack.isEmpty();
  }

  public int size() {
    return !this.inStack.isEmpty() ? this.inStack.size() : this.outStack.size();
  }
}

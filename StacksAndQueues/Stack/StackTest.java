package StacksAndQueues.Stack;

public class StackTest {
  public static void main(String[] args) {

    Stack<Integer> stack = new Stack<>();
    System.out.println("Stack created.");

    // should be 0
    System.out.println("\nSize of the stack: " + stack.size());

    System.out.println("\nPushing items into the stack...");
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
    stack.push(50);
    stack.push(60);
    stack.push(70);
    stack.push(80);

    // should be 8
    System.out.println("\nSize of the stack: " + stack.size());

    System.out.println("\nPopping items from the stack...");
    System.out.println(stack.pop()); // should be 80
    System.out.println(stack.pop()); // should be 70
    System.out.println(stack.pop()); // should be 60

    // should be 50
    System.out.println("\nTopmost item of the stack: " + stack.peek());

    // should be 5
    System.out.println("\nSize of the stack: " + stack.size());

    System.out.println("\nPopping some more items from the stack...");
    System.out.println(stack.pop()); // should be 50
    System.out.println(stack.pop()); // should be 40
    System.out.println(stack.pop()); // should be 30
    System.out.println(stack.pop()); // should be 20
    System.out.println(stack.pop()); // should be 10

    // should be true
    System.out.println("\nIs the stack empty? " + stack.isEmpty());
  }
}

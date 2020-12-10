package Recursion.Fibonacci;

import Recursion.Fibonacci.Fibonacci.TYPE;

public class FibonacciTest {
  public static void main(String[] args) {

    // should be 55
    System.out.println(TYPE.RECURSION + " -> " + Fibonacci.fibo(10, TYPE.RECURSION));

    // should be 55
    System.out.println(TYPE.MEMOIZATION + " -> " + Fibonacci.fibo(10, TYPE.MEMOIZATION));

    // should be 55
    System.out.println(TYPE.ITERATION + " -> " + Fibonacci.fibo(10, TYPE.ITERATION));
    System.out.println();

    // should be 1
    System.out.println(TYPE.RECURSION + " -> " + Fibonacci.fibo(1, TYPE.RECURSION));

    // should be 1
    System.out.println(TYPE.MEMOIZATION + " -> " + Fibonacci.fibo(1, TYPE.MEMOIZATION));

    // should be 1
    System.out.println(TYPE.ITERATION + " -> " + Fibonacci.fibo(1, TYPE.ITERATION));
    System.out.println();

    // should be 28657
    System.out.println(TYPE.RECURSION + " -> " + Fibonacci.fibo(23, TYPE.RECURSION));

    // should be 28657
    System.out.println(TYPE.MEMOIZATION + " -> " + Fibonacci.fibo(23, TYPE.MEMOIZATION));

    // should be 28657
    System.out.println(TYPE.ITERATION + " -> " + Fibonacci.fibo(23, TYPE.ITERATION));
    System.out.println();
  }
}

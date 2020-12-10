package Recursion.Factorial;

import Recursion.Factorial.Factorial.TYPE;

public class FactorialTest {
  public static void main(String[] args) {

    // should be 720
    System.out.println(Factorial.factorial(6, TYPE.RECURSIVE));

    // should be 720
    System.out.println(Factorial.factorial(6, TYPE.MEMOIZATION));

    // should be 5040 (should take less time as 6! is already calculated)
    System.out.println(Factorial.factorial(7, TYPE.MEMOIZATION));
  }
}

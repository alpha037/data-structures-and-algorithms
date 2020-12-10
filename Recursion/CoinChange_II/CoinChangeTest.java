package Recursion.CoinChange_II;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinChangeTest {
  public static void main(String[] args) {

    // should be 4
    System.out.println(CoinChange.numberOfWays(10, new ArrayList<>(Arrays.asList(1, 5, 10))));

    // should be 7
    System.out.println(CoinChange.numberOfWays(12, new ArrayList<>(Arrays.asList(1, 3, 7))));

    // should be 39
    System.out.println(CoinChange.numberOfWays(45, new ArrayList<>(Arrays.asList(1, 5, 10, 25))));

    // should be 9
    System.out.println(CoinChange.numberOfWays(23, new ArrayList<>(Arrays.asList(1, 5, 10, 25))));

    // should be 103
    System.out.println(CoinChange.numberOfWays(74, new ArrayList<>(Arrays.asList(1, 5, 10, 25))));
  }
}

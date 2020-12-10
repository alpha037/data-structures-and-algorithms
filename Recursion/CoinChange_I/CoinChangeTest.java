package Recursion.CoinChange_I;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinChangeTest {
  public static void main(String[] args) {

    // should be 1
    System.out.println(CoinChange.minCoinsRequired(10, new ArrayList<>(Arrays.asList(1, 5, 10))));

    // should be 4
    System.out.println(CoinChange.minCoinsRequired(12, new ArrayList<>(Arrays.asList(1, 3, 7))));

    // should be 3
    System.out.println(
        CoinChange.minCoinsRequired(45, new ArrayList<>(Arrays.asList(1, 5, 10, 25))));

    // should be 5
    System.out.println(
        CoinChange.minCoinsRequired(23, new ArrayList<>(Arrays.asList(1, 5, 10, 25))));

    // should be 8
    System.out.println(
        CoinChange.minCoinsRequired(74, new ArrayList<>(Arrays.asList(1, 5, 10, 25))));
  }
}

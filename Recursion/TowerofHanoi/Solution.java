package Recursion.TowerofHanoi;

/**
 * * Tower Of Hanoi problem using Recursion
 */
public class Solution {
  int numberOfMovements;

  public Solution() {
    numberOfMovements = 0;
  }

  public int getNumberOfMovements() {
    return numberOfMovements;
  }

  void solveTowerOfHanoi(char source, char helper, char destination, int n) {
    // Every time this method
    // is invoked, the number
    // of movements increases
    ++numberOfMovements;

    /**
     * Base Case.
     *
     * If the number of disc
     * is 1, then just move it
     * from the source rod to
     * the destination rod.
     */
    if (n == 1) {
      System.out.println("Move disc 1 from rod " + source + " to rod " + destination);
      return;
    }

    // Move n - 1 discs from the source
    // rod to the helper rod
    solveTowerOfHanoi(source, destination, helper, n - 1);

    // Then, move the nth disc from source
    // rod to destination rod
    System.out.println("Move disc " + n + " from rod " + source + " to rod " + destination);

    // Then, move the n - 1 discs from helper
    // rod to the destination rod
    solveTowerOfHanoi(helper, source, destination, n - 1);
  }

  public static void main(String args[]) {
    Solution solution = new Solution();

    solution.solveTowerOfHanoi('A', 'B', 'C', 2);

    System.out.println("\nTotal number of movements: " + solution.numberOfMovements);
  }
}

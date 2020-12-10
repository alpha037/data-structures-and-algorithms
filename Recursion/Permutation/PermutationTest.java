package Recursion.Permutation;

public class PermutationTest {
  public static void main(String[] args) {

    // should be ["abc", "acb", "bac", "bca", "cab", "cba"]
    System.out.println(Permutation.permute("abc").toString());
    Permutation.clearList();

    // should be ["dog", "dgo", "odg", "ogd", "gdo", "god"]
    System.out.println(Permutation.permute("god").toString());
    Permutation.clearList();
  }
}

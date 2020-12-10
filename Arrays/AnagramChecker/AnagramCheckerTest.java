package Arrays.AnagramChecker;

class AnagramCheckerTest {
  public static void main(String[] args) {

    // should be true
    System.out.println(AnagramChecker.isAnagram("public relations", "crap built on lies"));

    // should be true
    System.out.println(AnagramChecker.isAnagram("d og", "dog"));

    // should be true
    System.out.println(AnagramChecker.isAnagram("d og", "god"));

    // should be true
    System.out.println(AnagramChecker.isAnagram("clint eastwood", "old west action"));

    // should be false
    System.out.println(AnagramChecker.isAnagram("qq", "bb"));

    // should be false
    System.out.println(AnagramChecker.isAnagram("eh yo !", "yo ho!"));
  }
}

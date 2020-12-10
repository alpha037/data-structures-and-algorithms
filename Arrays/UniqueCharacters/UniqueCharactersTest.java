package Arrays.UniqueCharacters;

public class UniqueCharactersTest {
  public static void main(String[] args) {

    // should be true
    System.out.println(UniqueCharacters.isUnique(""));

    // should be false
    System.out.println(UniqueCharacters.isUnique("goo"));

    // should be true
    System.out.println(UniqueCharacters.isUnique("abcdef"));

    // should be true
    System.out.println(UniqueCharacters.isUnique(""));

    // should be true
    System.out.println(UniqueCharacters.isUnique(null));

    // should be false
    System.out.println(UniqueCharacters.isUnique("ABCDEFA"));
  }
}

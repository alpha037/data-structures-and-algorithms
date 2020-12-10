package Searching.HashingImpl;

public class HashTableTest {
  public static void main(String[] args) {

    HashTable map = new HashTable(10);

    map.put(1, "100");
    map.put(2, "200");
    map.put(3, "300");
    map.put(4, "400");

    // 10
    System.out.println("Size: " + map.size());

    // should be 200
    System.out.println("\nValue at key 2: " + map.get(2));

    // should be 400
    System.out.println("\nValue at key 4: " + map.get(4));

    // should be 400
    System.out.println("\nValue deleted: " + map.remove(4));

    // should be false
    System.out.println("\nContains key 4: " + map.containsKey(4));

    // should be true
    System.out.println("\nContains key 2: " + map.containsKey(2));

    // should be null
    System.out.println("\nValue at key 5: " + map.get(5));
  }
}

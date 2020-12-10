package Searching.HashingImpl;

import java.util.Arrays;

public class HashTable {

  private int size;
  private int[] slots;
  private String[] values;

  public HashTable(int size) {
    this.size = size;
    fillArrays();
  }

  // * ---- Getters ----

  public int size() {
    return this.size;
  }

  // * ---- Getters END ----

  // * ---- Private helper methods ----

  private void fillArrays() {
    slots = new int[size];
    values = new String[size];
    Arrays.fill(slots, 0);
    Arrays.fill(values, "");
  }

  private int hash(int key) {
    return key % size;
  }

  private int rehash(int oldHash) {
    return (oldHash + 1) % size;
  }

  // * ---- Private helper methods END ----

  // * ---- Public methods ----

  public void put(int key, String value) {
    int hash = hash(key);

    if (slots[hash] == 0) {
      slots[hash] = key;
      values[hash] = value;
    } else {
      int rehash = rehash(hash);
      while (slots[rehash] != 0 && hash != rehash) rehash = rehash(rehash);

      if (slots[rehash] == key) values[rehash] = value;
      else {
        slots[rehash] = key;
        values[rehash] = value;
      }
    }
  }

  public String get(int key) {
    int hash = hash(key);

    if (slots[hash] == key) return values[hash];

    int rehash = rehash(hash);
    while (rehash != hash && slots[rehash] != key) rehash = rehash(rehash);

    return slots[rehash] == key ? values[rehash] : null;
  }

  public String remove(int key) {
    int hash = hash(key);

    if (slots[hash] == key) {
      slots[hash] = 0;
      return values[hash];
    }

    int rehash = rehash(hash);
    while (rehash != hash && slots[rehash] != key) rehash = rehash(rehash);

    if (slots[rehash] != key) return null;

    slots[rehash] = 0;
    return values[rehash];
  }

  public boolean containsKey(int key) {
    int hash = hash(key);

    if (slots[hash] == key) return true;

    int rehash = rehash(hash);
    while (rehash != hash && slots[rehash] != key) rehash = rehash(rehash);

    return slots[rehash] == key;
  }
}
  // * ---- Public methods END ----

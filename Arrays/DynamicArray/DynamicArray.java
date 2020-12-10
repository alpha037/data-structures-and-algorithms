package Arrays.DynamicArray;

public class DynamicArray {

  /**
   * * Private data members
   */
  private int n;

  private int capacity;
  private int[] array;

  /**
   * Constructor used to build an empty DynamicArray
   */
  public DynamicArray() {
    super();
    this.n = 0;
    this.capacity = 1;
    this.array = this.makeArray(this.capacity);
  }

  /**
   * Constructor used to build a DynamicArray that has the specified initial
   * capacity.
   *
   * @param capacity : An integer denoting the initial capacity.
   */
  public DynamicArray(int capacity) {
    super();
    this.n = 0;
    this.capacity = capacity;
    this.array = this.makeArray(this.capacity);
  }

  /**
   * Method to get the current length of the array.
   *
   * @return An integer containing the current length of the array.
   */
  public int length() {
    return this.n;
  }

  /**
   * Method to append a new element at the end of the array.
   *
   * @param element : The new element to be appended.
   */
  public void add(int element) {
    if (this.n == this.capacity) this.resize(2 * this.capacity);

    this.array[this.n] = element;
    this.n++;
  }

  /**
   * Method to get an existing element in the array by index.
   *
   * @param index : The index of the element to be returned.
   * @return The existing element in the array by index.
   */
  public int get(int index) {
    if (!(index >= 0 && index < this.capacity))
      throw new ArrayIndexOutOfBoundsException(index + " is out of bounds.");

    return this.array[index];
  }

  /**
   * Private method to resize the array capacity.
   *
   * @param newCapacity : An integer denoting the new capacity of the array.
   */
  private void resize(int newCapacity) {
    int[] temp = this.makeArray(newCapacity);

    for (int i = 0; i < this.n; i++) temp[i] = this.array[i];

    this.array = temp;
    this.capacity = newCapacity;
  }

  /**
   * Private method to return an anonymous array of the specified capacity.
   *
   * @param capacity : An integer denoting the capacity of the array to be formed.
   * @return An anonymous array with the specified capacity.
   */
  private int[] makeArray(int capacity) {
    return new int[capacity];
  }
}

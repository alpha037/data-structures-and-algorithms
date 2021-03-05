package AlgoExSolutions.Medium.ArrayofProducts;

// import java.util.*;

/**
 * * Array Of Products
 */
class Program {
  public int[] arrayOfProducts(int[] array) {
    // Write your code here.
    if (array == null) return new int[] {};

    int currentProduct = 1, len = array.length;
    int[] res = new int[len];

    for (int i = 0; i < len; i++) {
      res[i] = currentProduct;
      currentProduct *= array[i];
    }

    currentProduct = 1;

    for (int i = len - 1; i >= 0; i--) {
      res[i] *= currentProduct;
      currentProduct *= array[i];
    }

    return res;
  }
}

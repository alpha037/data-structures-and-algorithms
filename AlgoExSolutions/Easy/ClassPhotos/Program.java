package AlgoExSolutions.Easy.ClassPhotos;

import java.util.*;

/**
 * * Class Photos
 */
class Program {

  public boolean classPhotos(
      ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
    // Write your code here.

    Collections.sort(redShirtHeights);
    Collections.sort(blueShirtHeights);

    int rSize = redShirtHeights.size(), bSize = blueShirtHeights.size();

    boolean redShirtFirst = redShirtHeights.get(rSize - 1) < blueShirtHeights.get(bSize - 1);

    if (redShirtFirst) {
      for (int i = rSize - 1; i >= 0; i--)
        if (redShirtHeights.get(i) >= blueShirtHeights.get(i)) return false;
    } else {
      for (int i = rSize - 1; i >= 0; i--)
        if (redShirtHeights.get(i) <= blueShirtHeights.get(i)) return false;
    }

    return true;
  }
}

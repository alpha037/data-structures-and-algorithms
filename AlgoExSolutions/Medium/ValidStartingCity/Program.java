package AlgoExSolutions.Medium.ValidStartingCity;

// import java.util.*;

/**
 * * Valid Starting City
 */
class Program {

  public int validStartingCity(int[] distances, int[] fuel, int mpg) {
    // Write your code here.
    int startingCityIdx = 0, minFuel = 0, milesTravelled = 0;

    for (int idx = 1; idx < distances.length; idx++) {
      milesTravelled += (mpg * fuel[idx - 1]) - distances[idx - 1];

      if (milesTravelled < minFuel) {
        minFuel = milesTravelled;
        startingCityIdx = idx;
      }
    }

    return startingCityIdx;
  }
}

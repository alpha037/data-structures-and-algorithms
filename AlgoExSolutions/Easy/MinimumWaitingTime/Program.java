package AlgoExSolutions.Easy.MinimumWaitingTime;

import java.util.*;

/**
 * * Minimum Waiting Time
 */
class Program {

  public int minimumWaitingTime(int[] queries) {
    // Write your code here.
    Arrays.sort(queries);
    int minWaitTime = 0, len = queries.length;

    for (int idx = 0; idx < len; idx++) minWaitTime += queries[idx] * (len - 1 - idx);

    return minWaitTime;
  }
}

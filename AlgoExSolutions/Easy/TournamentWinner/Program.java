package AlgoExSolutions.Easy.TournamentWinner;

import java.util.*;

/**
 * * Tournament Winner
 */
class Program {

  public String tournamentWinner(
      ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
    // Write your code here.
    HashMap<String, Integer> points = new HashMap<>();
    String winner = "";
    points.put(winner, 0);

    for (int i = 0; i < competitions.size(); i++) {
      String currentWinner =
          results.get(i) == 0 ? competitions.get(i).get(1) : competitions.get(i).get(0);

      points.put(currentWinner, points.getOrDefault(currentWinner, 0) + 3);

      if (points.get(winner) <= points.get(currentWinner)) winner = currentWinner;
    }

    return winner;
  }
}

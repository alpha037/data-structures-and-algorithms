package AlgoExSolutions.Medium.TaskAssignment;

import java.util.*;

/**
 * * Task Assignment
 */
class Program {
  private int getIndexOfTask(Map<Integer, List<Integer>> map, int task) {
    List<Integer> indices = map.get(task);
    int index = indices.remove(indices.size() - 1);
    map.put(task, indices);

    return index;
  }

  private Map<Integer, List<Integer>> mapTaskDurationToIndices(List<Integer> tasks) {
    Map<Integer, List<Integer>> map = new HashMap<>();

    for (int idx = 0; idx < tasks.size(); idx++) {
      if (!map.containsKey(tasks.get(idx))) map.put(tasks.get(idx), new ArrayList<>());

      map.get(tasks.get(idx)).add(idx);
    }

    return map;
  }

  public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
    // Write your code here.
    ArrayList<ArrayList<Integer>> assignments = new ArrayList<>();
    Map<Integer, List<Integer>> map = mapTaskDurationToIndices(tasks);
    List<Integer> current = new ArrayList<>();
    int start = 0, end = tasks.size() - 1;

    Collections.sort(tasks);

    while (k > 0 && start < end) {
      current.add(getIndexOfTask(map, tasks.get(start)));
      current.add(getIndexOfTask(map, tasks.get(end)));

      assignments.add(new ArrayList<>(current));

      current.clear();
      ++start;
      --end;
      --k;
    }

    return assignments;
  }
}

package AlgoExSolutions.Hard.TopologicalSort;

import java.util.*;

/**
 * * Topological Sort
 */
class Program {
  /**
   * * DFS Approach
   *
   * * TC: O(v + e)
   * * SC: O(v)
   */
  public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
    // Write your code here.
    return getOrderedJobs(createJobGraph(jobs, deps));
  }

  private static JobGraph createJobGraph(List<Integer> jobs, List<Integer[]> deps) {
    JobGraph graph = new JobGraph(jobs);
    for (Integer[] dep : deps) graph.addPrerequisite(dep[1], dep[0]);

    return graph;
  }

  private static List<Integer> getOrderedJobs(JobGraph graph) {
    List<Integer> orderedJobs = new ArrayList<>();
    List<JobNode> nodes = new ArrayList<>(graph.nodes);
    boolean hasCycle = false;

    while (nodes.size() > 0) {
      JobNode currentNode = nodes.remove(nodes.size() - 1);
      hasCycle = depthFirstTraversal(currentNode, orderedJobs);

      if (hasCycle) return new ArrayList<>();
    }

    return orderedJobs;
  }

  private static boolean depthFirstTraversal(JobNode node, List<Integer> orderedJobs) {
    if (node.isVisited) return false;

    if (node.isVisiting) return true;

    node.isVisiting = true;
    for (JobNode prerequisiteNode : node.prerequisites) {
      boolean hasCycle = depthFirstTraversal(prerequisiteNode, orderedJobs);

      if (hasCycle) return true;
    }

    node.isVisited = true;
    node.isVisiting = false;
    orderedJobs.add(node.job);
    return false;
  }

  static class JobGraph {
    List<JobNode> nodes;
    Map<Integer, JobNode> graph;

    public JobGraph(List<Integer> jobs) {
      nodes = new ArrayList<>();
      graph = new HashMap<>();
      for (int job : jobs) addNode(job);
    }

    public void addPrerequisite(int job, int prerequisite) {
      JobNode jobNode = getNode(job);
      JobNode prerequisiteNode = getNode(prerequisite);

      jobNode.prerequisites.add(prerequisiteNode);
    }

    private void addNode(int job) {
      graph.put(job, new JobNode(job));
      nodes.add(graph.get(job));
    }

    private JobNode getNode(int job) {
      if (!graph.containsKey(job)) addNode(job);

      return graph.get(job);
    }
  }

  static class JobNode {
    int job;
    List<JobNode> prerequisites;
    boolean isVisited;
    boolean isVisiting;

    public JobNode(int job) {
      this.job = job;
      prerequisites = new ArrayList<>();
      isVisited = false;
      isVisiting = false;
    }
  }
}

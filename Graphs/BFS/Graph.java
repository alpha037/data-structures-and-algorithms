package Graphs.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph<T> {

  private Map<T, List<T>> adjVertices;

  public Graph() {
    this.adjVertices = new HashMap<T, List<T>>();
  }

  public enum TYPE {
    ITERATIVE,
    RECURSIVE
  }

  public int size() {
    return this.adjVertices.size();
  }

  private void BFSRecursive(Queue<T> queue, Map<T, Boolean> visited) {
    if (queue.isEmpty()) return;

    T current = queue.poll();
    // visited[current] = true;
    visited.put(current, true);

    System.out.print(current + " ");

    Iterator<T> iter = adjVertices.get(current).listIterator();
    while (iter.hasNext()) {
      T v = iter.next();

      if (visited.get(v) == null || !visited.get(v)) {
        visited.put(v, true);
        queue.add(v);
      }
    }

    BFSRecursive(queue, visited);
  }

  private void BFSIterative(T start, Queue<T> queue, Map<T, Boolean> visited) {
    visited.put(start, true);
    queue.add(start);

    while (!queue.isEmpty()) {
      T current = queue.poll();
      System.out.print(current + " ");

      Iterator<T> iter = adjVertices.get(current).listIterator();
      while (iter.hasNext()) {
        T v = iter.next();

        if (visited.get(v) == null || !visited.get(v)) {
          visited.put(v, true);
          queue.add(v);
        }
      }
    }
  }

  public void addEdge(T v, T w) {
    adjVertices.putIfAbsent(v, new ArrayList<T>());
    adjVertices.get(v).add(w);
  }

  public void BFS(T key, TYPE type) {
    switch (type) {
      case RECURSIVE:
        Queue<T> queue = new LinkedList<T>();
        queue.add(key);
        BFSRecursive(queue, new HashMap<T, Boolean>());
        break;

      case ITERATIVE:
        BFSIterative(key, new LinkedList<T>(), new HashMap<T, Boolean>());
        break;
    }

    System.out.println("\n");
  }
}

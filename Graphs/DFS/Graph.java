package Graphs.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Graph<T> {

  private Map<T, List<T>> adjVertices;

  public Graph() {
    this.adjVertices = new HashMap<>();
  }

  public enum TYPE {
    ITERATIVE,
    RECURSIVE
  }

  public int size() {
    return this.adjVertices.size();
  }

  private void DFSRecursive(T key, Map<T, Boolean> visited) {
    visited.put(key, true);

    System.out.print(key + " ");

    Iterator<T> iter = adjVertices.get(key).listIterator();
    while (iter.hasNext()) {
      T v = iter.next();

      if (visited.get(v) == null || !visited.get(v)) DFSRecursive(v, visited);
    }
  }

  private void DFSIterative(T start, Map<T, Boolean> visited) {
    Stack<T> stack = new Stack<>();
    stack.push(start);

    while (!stack.isEmpty()) {
      T current = stack.pop();
      visited.put(current, true);
      System.out.print(current + " ");

      Iterator<T> iter = adjVertices.get(current).listIterator();
      while (iter.hasNext()) {
        T v = iter.next();
        if (visited.get(v) == null || !visited.get(v)) stack.push(v);
      }
    }
  }

  public void addEdge(T v, T w) {
    adjVertices.putIfAbsent(v, new ArrayList<>());
    adjVertices.get(v).add(w);
  }

  public void DFS(T key, TYPE type) {
    switch (type) {
      case RECURSIVE:
        DFSRecursive(key, new HashMap<T, Boolean>());
        break;

      case ITERATIVE:
        DFSIterative(key, new HashMap<T, Boolean>());
        break;
    }

    System.out.println("\n");
  }
}

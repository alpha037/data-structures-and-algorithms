package Graphs.AdjacencyListImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
  private Map<Vertex, List<Vertex>> adjVertices;

  public Graph() {
    this.adjVertices = new HashMap<>();
  }

  public void addVertex(String key) {
    adjVertices.putIfAbsent(new Vertex(key), new ArrayList<>());
  }

  public Vertex removeVertex(String key) {
    // Remove the vertex from all the values
    // of other vertices
    Vertex vertexToBeRemoved = new Vertex(key);
    adjVertices.values().forEach(vertices -> vertices.remove(vertexToBeRemoved));

    // Remove the vertex itself
    adjVertices.remove(vertexToBeRemoved);

    return vertexToBeRemoved;
  }

  public void addEdge(String key1, String key2) {
    Vertex v1 = new Vertex(key1);
    Vertex v2 = new Vertex(key2);

    // Add the vertices to each other's
    // list in order to show that there
    // is an edge between them
    adjVertices.get(v1).add(v2);
    adjVertices.get(v2).add(v1);
  }

  public void removeEdge(String key1, String key2) {
    Vertex v1 = new Vertex(key1);
    Vertex v2 = new Vertex(key2);

    List<Vertex> edges1 = adjVertices.get(v1);
    List<Vertex> edges2 = adjVertices.get(v2);

    // Remove the vertices
    // from each other's list
    if (edges1 != null) edges1.remove(v2);

    if (edges2 != null) edges2.remove(v1);
  }

  public List<Vertex> getVertices(String key) {
    return adjVertices.get(new Vertex(key));
  }

  public void displayVertices(String key) {
    List<Vertex> vertices = getVertices(key);

    if (vertices != null) vertices.forEach(vertex -> System.out.print(vertex.getKey() + " "));
    else System.out.print("No vertices present.");

    System.out.println("\n");
  }

  class Vertex {
    private String key;

    public Vertex(String key) {
      this.key = key;
    }

    public String getKey() {
      return this.key;
    }

    private Graph getOuterType() {
      return Graph.this;
    }

    @Override
    public String toString() {
      return "Key: " + key;
    }

    /**
     * Overriding hashCode() and equals()
     * is mandatory to work with collections
     */
    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;

      if (obj == null || obj.getClass() != this.getClass()) return false;

      Vertex vert = (Vertex) obj;
      return vert.key.equals(this.key);
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + getOuterType().hashCode();
      result = prime * result + ((key == null) ? 0 : key.hashCode());
      return result;
    }
  }
}

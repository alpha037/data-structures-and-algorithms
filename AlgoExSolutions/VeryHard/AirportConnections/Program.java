package AlgoExSolutions.VeryHard.AirportConnections;

import java.util.*;

/**
 * * Airport Connections
 */
class Program {
  /**
   * * TC: O(a * (a + r) + a + r + a log(a))
   * * SC: O(a * r)
   */
  public static int airportConnections(
      List<String> airports, List<List<String>> routes, String startingAirport) {
    // Write your code here.
    Map<String, AirportNode> airportGraph = createGraph(airports, routes);
    List<AirportNode> unreachableAirportNodes =
        getUnreachableAirportNodes(airports, airportGraph, startingAirport);
    markUnreachableConnections(airportGraph, unreachableAirportNodes);
    return getMinNumberOfNewRoutes(airportGraph, unreachableAirportNodes);
  }

  // TC: O(a + r), SC: O(a + r)
  private static Map<String, AirportNode> createGraph(
      List<String> airports, List<List<String>> routes) {
    Map<String, AirportNode> airportGraph = new HashMap<>();
    for (String airport : airports) airportGraph.put(airport, new AirportNode(airport));

    for (List<String> route : routes) {
      String src = route.get(0), dest = route.get(1);
      airportGraph.get(src).connections.add(dest);
    }
    return airportGraph;
  }

  // TC: O(a + r), SC: O(a)
  private static List<AirportNode> getUnreachableAirportNodes(
      List<String> airports, Map<String, AirportNode> airportGraph, String startingAirport) {
    Map<String, Boolean> visitedAirports = new HashMap<>();
    List<AirportNode> unreachableAirportNodes = new ArrayList<>();
    dfsAirports(startingAirport, airportGraph, visitedAirports);

    for (String airport : airports) {
      if (visitedAirports.containsKey(airport)) continue;
      AirportNode airportNode = airportGraph.get(airport);
      airportNode.isReachable = false;
      unreachableAirportNodes.add(airportNode);
    }
    return unreachableAirportNodes;
  }

  private static void dfsAirports(
      String airport, Map<String, AirportNode> airportGraph, Map<String, Boolean> visitedAirports) {
    if (visitedAirports.containsKey(airport)) return;
    visitedAirports.put(airport, true);

    for (String connection : airportGraph.get(airport).connections)
      dfsAirports(connection, airportGraph, visitedAirports);
  }

  // TC: O(a * (a + r)), SC: O(a)
  private static void markUnreachableConnections(
      Map<String, AirportNode> airportGraph, List<AirportNode> unreachableAirportNodes) {
    for (AirportNode airportNode : unreachableAirportNodes) {
      List<String> unreachableConnections = new ArrayList<>();
      dfsUnreachableConnections(
          airportNode.airport, airportGraph, unreachableConnections, new HashMap<>());
      airportNode.unreachableConnections = unreachableConnections;
    }
  }

  private static void dfsUnreachableConnections(
      String airport,
      Map<String, AirportNode> airportGraph,
      List<String> unreachableConnections,
      Map<String, Boolean> visitedAirports) {
    if (visitedAirports.containsKey(airport) || airportGraph.get(airport).isReachable) return;
    visitedAirports.put(airport, true);
    unreachableConnections.add(airport);

    for (String connection : airportGraph.get(airport).connections)
      dfsUnreachableConnections(connection, airportGraph, unreachableConnections, visitedAirports);
  }

  // TC: O(alog(a) + a + r), SC: O(1)
  private static int getMinNumberOfNewRoutes(
      Map<String, AirportNode> airportGraph, List<AirportNode> unreachableAirportNodes) {
    unreachableAirportNodes.sort(
        (a1, a2) -> a2.unreachableConnections.size() - a1.unreachableConnections.size());
    int minNumberOfNewRoutes = 0;

    for (AirportNode airportNode : unreachableAirportNodes) {
      if (airportNode.isReachable) continue;
      ++minNumberOfNewRoutes;
      for (String connection : airportNode.unreachableConnections)
        airportGraph.get(connection).isReachable = true;
    }

    return minNumberOfNewRoutes;
  }

  static class AirportNode {
    String airport;
    List<String> connections;
    boolean isReachable;
    List<String> unreachableConnections;

    public AirportNode(String airport) {
      this.airport = airport;
      connections = new ArrayList<>();
      isReachable = true;
      unreachableConnections = new ArrayList<>();
    }
  }
}

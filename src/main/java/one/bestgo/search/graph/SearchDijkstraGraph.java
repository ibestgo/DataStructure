package one.bestgo.search.graph;

import java.util.*;

// https://kheri.net/dijkstra-algorithm/
public class SearchDijkstraGraph {
  public static void main(String[] args) {
    WNode<String> a = createWeightedGraph();

    Map<WNode<String>, Integer> distances = getShortestDistanceFrom(a);
    System.out.println(distances);
  }

  private static Map<WNode<String>, Integer> getShortestDistanceFrom(WNode<String> start) {
    Map<WNode<String>, Integer> distances = new HashMap<>(); // to track distances to all other vertices
    distances.put(start, 0);

    Set<WNode<String>> visited = new HashSet<>();
    Set<WNode<String>> explored = new HashSet<>();

    visited.add(start); // #1 visit the start node.
    while(!visited.isEmpty()) {
      System.out.println("distances: "+distances);
      // #2 find the shortest node out of the prior node's unexplored nodes in visited.
      WNode<String> shortestNode = null;
      int shortest = 0;
      for(WNode<String> node : visited) {
        // calculate node weight
        int nodeWeight = getWeight(distances, node);
        if(shortestNode == null) {
          shortest = nodeWeight;
          shortestNode = node;
          continue;
        }

        if(nodeWeight < shortest) {
          shortest = nodeWeight;
          shortestNode = node;
        }
      }

      // #3 Explorer: Iterate shortestNode's neighbors.
      // If unexplored yet, add them to visited and update the lowest distance from the start node
      for(WNode<String> neighbor : shortestNode.getNeighbors()) {
        if(!explored.contains(neighbor)) {
          visited.add(neighbor);
          int neighborWeight = getWeight(distances, shortestNode) + shortestNode.getDistance(neighbor);
          int priorWeight = getWeight(distances, neighbor); // returns Integer.MAX_VALUE mostly
          if(neighborWeight < priorWeight) {  // if calculated-distance < known-distance
            distances.put(neighbor, neighborWeight);
          }
        }
      }

      // #4 now the shortest node is explored and the unexplored neighbors are in visited
      // since we done with the identified shortestNode, remove it from the visited.
      // while loops until visited is empty.
      visited.remove(shortestNode);
      explored.add(shortestNode);
    }

    return distances;
  }

  private static Integer getWeight(Map<WNode<String>, Integer> distances, WNode node) {
    return distances.containsKey(node)? distances.get(node) : Integer.MAX_VALUE;
  }

  private static WNode<String> createWeightedGraph() {
    WNode<String> a = new WNode<>("A");
    WNode<String> b = new WNode<>("B");
    WNode<String> c = new WNode<>("C");
    WNode<String> d = new WNode<>("D");
    WNode<String> e = new WNode<>("E");

    // since neighbor.connect(this, distance); commented in DNode,
    // there are lots duplicated connect.
    a.connect(b, 6);
    a.connect(d, 1);

    d.connect(a, 1);
    d.connect(b, 2);
    d.connect(e, 1);

    b.connect(d, 2);
    b.connect(a, 6);
    b.connect(e, 2);
    b.connect(c, 5);

    e.connect(d, 1);
    e.connect(b, 2);
    e.connect(c, 5);

    c.connect(b, 5);
    c.connect(e, 5);
    return a;
  }
}

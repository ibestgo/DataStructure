package one.bestgo.search.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Dijkstra node has the distance map that shows distance to neighbors.
public class WNode<T> {
  private T value;
  private Set<WNode<T>> neighbors;
  private Map<WNode<T>, Integer> distanceMap; // since this is a weighted graph

  public WNode(T value) {
    this.neighbors = new HashSet<>();  // prefer to initialize in ctor
    this.distanceMap = new HashMap<>();
    this.value = value;

  }

  // Note that we connect a neighbor with the distance!
  public WNode<T> connect(WNode<T> neighbor, Integer distance) {
    if(neighbor == null || neighbor == this) throw new IllegalArgumentException("");

    if(!neighbors.contains(neighbor)) {
      neighbors.add(neighbor);
      distanceMap.put(neighbor, distance);
      //neighbor.connect(this, distance); // Original has this. Should we?
      //maybe better as when we create a graph, no need duplicated connect calls.
    }
    return neighbor;
  }

  // Getters
  public T getValue() {
    return value;
  }

  public Set<WNode<T>> getNeighbors() {
    return neighbors;
  }

  // No need getDistanceMap() instead, we need this
  public Integer getDistance(WNode<T> neighbor) {
    return distanceMap.get(neighbor);
  }

  @Override
  public String toString() {
    return String.valueOf(this.value);
  }
}

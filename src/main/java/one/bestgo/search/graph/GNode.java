package one.bestgo.search.graph;

import java.util.LinkedList;

// GNode is same as TNode.
public class GNode<T> {
  private T value;
  private LinkedList<GNode<T>> neighbors = new LinkedList<>();
  // Original implementation used LinkedHashSet. But why? Seems like no reason

  public T getValue() {
    return value;
  }

  public LinkedList<GNode<T>> getNeighbors() {
    return neighbors;
  }

  public GNode(T value) {
    this.value = value;
  }

  public GNode<T> connect(GNode<T> neighbor) {
    if(neighbor == null || neighbor == this)  // can't connect to itself
      throw new IllegalArgumentException("Invalid");

    neighbors.add(neighbor);
    return neighbor;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}

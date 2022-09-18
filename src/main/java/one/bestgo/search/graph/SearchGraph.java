package one.bestgo.search.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

// https://kheri.net/breadth-first-search-bfs-algorithm-with-java-examples/
public class SearchGraph {
  public static void main(String[] args) {
    GNode<Integer> root = createGraph();

    Optional<GNode<Integer>> result = searchBfs(root, 7);
    if(result.isPresent())
      System.out.println("Success: "+result.get());
    else
      System.out.println("Not Found");
  }

  private static Optional<GNode<Integer>> searchBfs(GNode<Integer> root, Integer target) {
    ArrayDeque<GNode<Integer>> queue = new ArrayDeque<>();
    queue.add(root);

    Set<GNode<Integer>> visited = new HashSet<>();
    while(!queue.isEmpty()) {
      System.out.println("Queue: "+queue);
      GNode<Integer> node = queue.remove();
      visited.add(node);

      if(node.getValue() == target) // better is: if(node.getValue().equals(target))
        return Optional.of(node);

      for(GNode<Integer> neighbor : node.getNeighbors()) {
        if(!visited.contains(neighbor) && !queue.contains(neighbor))
          queue.add(neighbor);
      }
    }
    return Optional.empty();
  }

  private static GNode<Integer> createGraph() {
    GNode<Integer> root = new GNode<Integer>(1);
    GNode<Integer> two = root.connect(new GNode<Integer>(2));
    GNode<Integer> six = root.connect(new GNode<Integer>(6));
    GNode<Integer> third = root.connect(new GNode<Integer>(3));

    two.connect(new GNode<Integer>(4));
    two.connect(new GNode<Integer>(5));
    two.connect(six);

    third.connect(six);
    third.connect(new GNode<Integer>(7));
    return root;
  }

  // A node that has 6 should be the same node.
  // But multiple instances were created here.
  private static GNode<Integer> createGraphWrong() {
    GNode<Integer> root = new GNode<Integer>(1);
    GNode<Integer> two = root.connect(new GNode<Integer>(2));
    two.connect(new GNode<Integer>(4));
    two.connect(new GNode<Integer>(5));
    two.connect(new GNode<Integer>(6));

    root.connect(new GNode<Integer>(6));

    GNode<Integer> third = root.connect(new GNode<Integer>(3));
    third.connect(new GNode<Integer>(6));
    third.connect(new GNode<Integer>(7));
    return root;
  }
}

package one.bestgo.search.graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Optional;

// https://kheri.net/breadth-first-search-bfs-algorithm-with-java-examples/
public class SearchTree {
  public static void main(String[] args) {
    // Create a tree
    TNode<Integer> root = new TNode<>(1);
    TNode<Integer> child1 = root.addChild(2);
    child1.addChild(4);
    child1.addChild(5);
    TNode<Integer> child2 = root.addChild(3);
    child2.addChild(6);
    child2.addChild(7);

    Optional<TNode<Integer>> result = searchDfs(root, 7);
    if(result.isPresent())
      System.out.println("Success: "+result.get());
    else
      System.out.println("Not Found");
  }

  // Breadth First Search (BFS)
  private static Optional<TNode<Integer>> searchBfs(TNode<Integer> root, Integer searchValue) {
    ArrayDeque<TNode<Integer>> queue = new ArrayDeque<>();
    queue.add(root);

    int counter = 0;
    while(!queue.isEmpty()) {
      System.out.println("Iteration "+(++counter)+" Queue="+queue);
      TNode<Integer> node = queue.remove();
      if(searchValue == node.getValue())
        return Optional.of(node);

      //OR queue.addAll(node.getChildren());
      for(TNode<Integer> child : node.getChildren())
        queue.add(child);
    }
    return Optional.empty();
  }

  // Depth First Search (DFS)
  private static Optional<TNode<Integer>> searchDfs(TNode<Integer> root, Integer searchValue) {
    ArrayDeque<TNode<Integer>> stack = new ArrayDeque<>();
    stack.push(root);

    int counter = 0;
    while(!stack.isEmpty()) {
      System.out.println("Iteration "+(++counter)+" Stack="+stack);
      TNode<Integer> node = stack.pop();
      if(searchValue == node.getValue())
        return Optional.of(node);

      for(TNode<Integer> child : node.getChildren())
        stack.push(child);
    }
    return Optional.empty();
  }

  // Works but this is NOT BFS!!!
  private static Optional<TNode<Integer>> searchNested(TNode<Integer> root, Integer searchValue) {
    if(searchValue == root.getValue()) {
      return Optional.of(root);
    }

    Optional<TNode<Integer>> ret;
    LinkedList<TNode<Integer>> children = root.getChildren();
    for(TNode child : children) {
      ret = searchNested(child, searchValue);
      if(ret.isPresent()) return ret;
    }

    return Optional.empty();
  }
}


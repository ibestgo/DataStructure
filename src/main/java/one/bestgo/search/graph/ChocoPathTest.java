package one.bestgo.search.graph;

import java.util.*;

public class ChocoPathTest {
  public static void main(String[] args) {
    Node root = create();
    List<Node> paths = getLongestPath(root);

    int sum = 0;
    for(Node one: paths) sum += one.getValue();
    System.out.println(paths);
    System.out.println(sum);
  }

  private static List<Node> getLongestPath(Node start) {
    List<Node> paths = new ArrayList<>();
    paths.add(start);

    ArrayDeque<Node> queue = new ArrayDeque<>();
    queue.add(start);

    // NOT ACCURATE.
    while(!queue.isEmpty()) {
      Node node = queue.remove();
      int longest = 0;
      Node longestNode = null;
      for(Node child: node.getOutBounds()) {
        if(child.getValue() > longest) {
          longest = child.getValue();
          longestNode = child;
        }
      }

      if(longestNode != null) {
        paths.add(longestNode);
        queue.add(longestNode);
      }
    }
    return paths;
  }

  private static Node create() {
    Node a = new Node("A", 5);
    Node b = new Node("B", 1);
    Node c = new Node("C", 3);
    Node d = new Node("D", 7);
    Node e = new Node("E", 3);
    Node f = new Node("F", 4);
    Node g = new Node("G", 2);
    Node h = new Node("H", 100);
    Node i = new Node("I", 3);
    Node j = new Node("J", 9);
    a.connectTo(b);
    b.connectTo(c);
    b.connectTo(d);
    c.connectTo(e);
    d.connectTo(e);
    d.connectTo(g);
    e.connectTo(f);
    e.connectTo(h);
    f.connectTo(i);
    g.connectTo(h);
    h.connectTo(i);
    i.connectTo(j);
    return a;
  }
}

class Node {
  private String id;
  private int value;
  private Set<Node> outBounds;

  public Node(String id, int value) {
    this.id = id;
    this.value = value;
    this.outBounds = new HashSet<>();
  }

  public Node connectTo(Node toNode) {
    if(toNode == null || this == toNode) throw new IllegalArgumentException("");
    outBounds.add(toNode);
    return toNode;
  }

  public int getValue() {
    return value;
  }

  public Set<Node> getOutBounds() {
    return this.outBounds;
  }

  @Override
  public String toString() {
    return String.valueOf(id);
  }
}
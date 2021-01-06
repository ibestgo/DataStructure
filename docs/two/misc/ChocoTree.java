package com.bestgo.misc;

public class ChocoTree {
  public Node root;

  public int maxPathSum() {
    return maxPathSum(root, 0);
  }

  public int maxPathSum(Node node, int currentSum) {
    if(node == null) return 0;

    int value = currentSum + node.chocos;
    return node.chocos + Math.max(maxPathSum(node.down, value), maxPathSum(node.right, value));
  }

  public static class Node {
    int chocos;
    Node down, right;

    public Node(int chocos) {
      this.chocos = chocos;
    }
    public Node(int chocos, Node down, Node right) {
      this.chocos = chocos;
      this.down = down;
      this.right = right;
    }
  }
}

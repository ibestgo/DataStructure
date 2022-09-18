package one.bestgo;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  private static class Node {
    private int value;
    private Node right;
    private Node down;

    public Node(int value) {
      this.value = value;
    }

    @Override

    public String toString() { return String.valueOf(value); }
  }

  private static List<Node> paths = new ArrayList<>();

  public static void main(String[] args) {
    Node root = createBoard();
    System.out.println("max sweet: " + findMaxSweet(root));
    System.out.println(paths);
  }

  private static int findMaxSweet2(Node node) {
    Node current = node;
    int max = 0;
    while(!(current.right == null && current.down == null)) {

      if(current.right != null) {

      }

      // assign longest to the next current

    }
    return 0;
  }

  // Using nested is useful to find the value but hard to find the path
  private static int findMaxSweet(Node node) {
    if(node == null) return 0;  // base case

    int value = node.value;
    int maxFromRight = findMaxSweet(node.right);
    int maxFromDown = findMaxSweet(node.down);
    value += Math.max(maxFromRight, maxFromDown);

    return value;
  }

  private static Node createBoard() {
    Node root = new Node(5);
    Node one = new Node(1);
    Node three = new Node(3);
    Node seven = new Node(7);
    Node three2 = new Node(3);
    Node four = new Node(4);
    Node two = new Node(2);
    Node one2 = new Node(1);
    Node three3 = new Node(3);
    Node nine = new Node(9);
    root.down = one;
    one.right = three;
    one.down = seven;
    three.down = three2;
    seven.right = three2;
    seven.down = two;
    three2.right = four;
    three2.down = one2;
    four.down = three3;
    two.right = one2;
    one2.right = three3;
    three3.right = nine;
    return root;
  }

  private static Node createBoard2() {
    Node root = new Node(7);
    Node eight = new Node(8);
    Node ten = new Node(10);
    Node five = new Node(5);
    Node two = new Node(2);
    Node one = new Node(1);
    Node four = new Node(4);
    Node nine = new Node(9);
    Node one2 = new Node(1);
    Node two2 = new Node(2);
    root.down = eight;
    eight.right = ten;
    eight.down = five;
    ten.down = two;
    five.right = two;
    five.down = four;
    two.right = one;
    two.down = nine;
    one.down = one2;
    four.right = nine;
    nine.right = one2;
    one2.right = two2;
    return root;
  }
}

package one.bestgo.search.binary;

public class LowestCommonAncestor {
  public static void main(String[] args) {
    Node root = new Node(3);
    Node five = new Node(5);
    Node one = new Node(1);
    Node six = new Node(6);
    Node two = new Node(2);
    Node zero = new Node(0);
    Node eight = new Node(8);
    Node seven = new Node(7);
    Node four = new Node(4);
    root.left = five;
    root.right = one;
    five.left = six;
    five.right = two;
    one.left = zero;
    one.right = eight;
    two.left = seven;
    two.right = four;

    five.parent = root;
    one.parent = root;
    six.parent = five;
    two.parent = five;
    zero.parent = one;
    eight.parent = one;
    seven.parent = two;
    four.parent = two;

    System.out.println(lowestCommonAncestor(five, four));
    System.out.println(lowestCommonAncestor(five, root));
  }

  // time complexity: O(depthP+depthQ-depthLCA)
  // space complexity: O(1)
  private static Node lowestCommonAncestor(Node p, Node q) {
    if(p == null || q == null) throw new IllegalArgumentException("");
    if(p == q) return p;

    Node ptrP = p;
    Node ptrQ = q;

//    while (!(ptrP.parent == null && ptrQ.parent == null)) { // *** be careful
//      if(ptrP == ptrQ) {
//        break;
//      }
//      ptrP = ptrP.parent == null? q : ptrP.parent;
//      ptrQ = ptrQ.parent == null? p : ptrQ.parent;
//    }
    // OR
//    while (true) {
//      if(ptrP.parent == null && ptrQ.parent == null) break;
//      if(ptrP == ptrQ) break;
//      ptrP = ptrP.parent == null? q : ptrP.parent;
//      ptrQ = ptrQ.parent == null? p : ptrQ.parent;
//    }

    // OR
    while (ptrP != ptrQ) {
      if(ptrP.parent == null && ptrQ.parent == null) break;
      ptrP = ptrP.parent == null? q : ptrP.parent;
      ptrQ = ptrQ.parent == null? p : ptrQ.parent;
    }

    if(ptrP == ptrQ)
      return ptrP;
    else
      return null;
  }
}

class Node {
  public int value;
  public Node parent;
  public Node right;
  public Node left;

  public Node(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}

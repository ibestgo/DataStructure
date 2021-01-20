package one.bestgo.search.binary;


public class BinarySearchTreeTest {
  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    bst.add(7);
    bst.add(4);
    bst.add(9);

    System.out.println(bst.search(9));
    System.out.println(bst.search(10));

    bst.printInOrder();
  }
}

class BinarySearchTree {
  private class Node {
    int value;
    Node parent, left, right;

    public Node(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private Node root;
  public void add(int value) {
    insertNode(root, value);
  }

  private void insertNode(Node node, int value) {
    Node newNode = new Node(value);
    if(root == null) {
      root = newNode;
      return;
    }

    if(value < node.value && node.left == null) {
      node.left = newNode;
      newNode.parent = node;
    } else if (value >= node.value && node.right == null) {
      node.right = newNode;
      newNode.parent = node;
    } else {
      if(value < node.value)
        insertNode(node.left, value);
      else
        insertNode(node.right, value);
    }
  }

  public Node search(int value) {
    return search(root, value);
  }

  private Node search(Node node, int value) {
    if(node == null) return null;
    if(node.value == value) return node;
    Node rnode = null;

    if(value < node.value)
      rnode = search(node.left, value);
    else
      rnode = search(node.right, value);
    return rnode;
  }

  public void printInOrder() {
    if(root != null)
      printInOrder(root);
    else
      System.out.println("empty tree");
  }

  private void printInOrder(Node node) {
    if(node != null) {
      printInOrder(node.left);
      System.out.println(node.value);
      printInOrder(node.right);
    }
  }
}

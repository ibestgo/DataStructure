package com.bestgo.datastructure;

public class BST {
  private Node root;

  public void add(int data) {
    insertNode(root, data);
  }

  private void insertNode(Node node, int data) {
    Node newNode = new Node(data);
    if(node == null) {
      root = newNode;
    } else {
      // 2 cases newNode can be appended to either left or right directly (no need of nested calls)
      if(data < node.data && node.left == null) {
        node.left = newNode;
        newNode.parent = node;
      } else if(data >= node.data && node.right == null) {  // node.left can't be null as it is covered above.
        node.right = newNode;
        newNode.parent = node;

      // other cases where nested calls are needed.
      } else {
        if(data < node.data)
          insertNode(node.left, data);
        else
          insertNode(node.right, data);
      }
    }
  }

  public Node search(int data) {
    return search(root, data);
  }

  private Node search(Node node, int data) {
    if(node == null) return null;
    Node rnode = null;

    // case of no need of nested
    if(node.data == data) {
      rnode = node;
    // case of nested
    } else {
     if(data < node.data)
       rnode = search(node.left, data);
     else
       rnode = search(node.right, data);
    }

    return rnode;
  }

  public void printInOrder() {
    if(root != null) {
      printInOrder(root);
    } else {
      System.out.println("Nothing in the BST tree.");
    }
  }

  private void printInOrder(Node node) {
    if(node != null) {
      printInOrder(node.left);
      System.out.print(node.data + " - ");
      printInOrder(node.right);
    }
  }

  public void deleteTree() {
    deleteTree(root);
    root = null;  // otherwise root is still active reference.
  }

  // traverses tree in post order to to delete each and every node of the tree
  private void deleteTree(Node node) {
    if(node == null) return;

    // delete children first
    deleteTree(node.left);
    node.left = null;

    deleteTree(node.right);
    node.right = null;

    System.out.println("Deleting "+node.data);
    if(node == root) {
      // == means both variables point to the same object
      System.out.println("++++++ HAHAHHAAHA 2 +++++++++");
    }

    node = null;
    // ERROR; this didn't delete the node object. only node variable is null when node == root.
    // since root is another reference, the object won't be deleted unless there is no reference
    // to the object. So what's the right way of deleting an object?
  }

  public static class Node {
    int data;
    Node parent, left, right;

    public Node(int data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return "[data: "+data+"]";
    }
  }
}

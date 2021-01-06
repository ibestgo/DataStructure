package com.bestgo.datastructure;

public class LinkedList {
  private Node head;  // default initial value of all reference types is null by vm (only for class member)
  private int size;   // default initial value of int is 0 (only for class member)
  // for a variable in methods, you'll get an error that no value has been set when trying to read from it
  // without first assinging it a value.

  public LinkedList() {
    head = null;
    size = 0;
  }

  public int append(Node node) {
    if(node == null) new IllegalArgumentException("null node can't be appended");
    node.setNext(null);
    if(head == null) {
      head = node;
      size = 1;
    } else {
      Node last = _getLastNode();
      last.setNext(node);
      size++;
    }
    return size;
  }

  public Node search(Object data) {
    Node current = head;
    for(int i=0; i < size; i++) {
      if(current.getData().equals(data)) break;
      current = current.getNext();
    }
    return current;
  }

  public int getSize() { return size; }

  public Node get(int index) {
    if(index < 0 || index > size-1) {
      throw new IllegalArgumentException("invalid index");
    }

    Node rnode = head;
    if(index != 0) {
      for (int i=0; i < index; i++) {
        rnode = rnode.getNext();
      }
    }

    return rnode.clone();
  }

  public Node remove(int index) {
    if(index < 0 || index > size-1) {
      throw new IllegalArgumentException("invalid index");
    }

    Node rnode = null;

    return rnode;
  }

  @Override
  public String toString() {
    String rstr = "((Size:"+size+"))";

    Node current = head;
    for(int i=0; i < size; i++) {
      rstr += ("->"+current.toString());
      current = current.getNext();
    }

    return rstr;
  }

  private Node _getLastNode() {
    //Node last = null; // method variable must be initialized
    Node current = head;

    // better one: while(current.getNext() != null) { current = current.getNext(); }
    for(int i=0; i < size; i++) {
      if(current.getNext() == null) break;
      else {
        current = current.getNext();
      }
    }

    return current;
  }

  public static class Node {
    Object data;
    Node next;  // means detached node

    public Node(Object data) {
      if(data != null) this.data = data;
    }

    public Node(Object data, Node next) {
      if(data != null) {
        this.data = data;
        setNext(next);
      }
    }

    public Object getData() { return data; }
    public Node getNext() { return next; }
    public void setNext(Node node) {
      this.next = node;
    }

    @Override
    public String toString() {
      return "["+data+"]";
    }

    @Override
    public Node clone() {
      return new Node(this.data);
    }
  }
}

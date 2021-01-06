package one.bestgo.lib;

import java.util.NoSuchElementException;

public class BetterLinkedList {
  // it is accessed always from the linkedlist, there is no need to create Node as a public class.
  // hence make it as an inner private class. And now its private members like next can be access using dot notation
  private class Node {
    private int value;
    private Node next;

    public Node(int value) {   // since a node always requires a value
      this.value = value;
    }
  }

  private Node first;
  private Node last;

  public void addLast(int item) {
    var node = new Node(item);
    if(first == null)
      first = last = node;
    else {
      last.next = node;
      last = node;
    }
  }

  public void addFirst(int item) {
    var node = new Node(item);

    if(isEmpty()) {         // more readable than "first == null"
      first = last = node;
    } else {
      node.next = first;
      first = node;
    }
  }

  public int indexOf(int item) {
    int ix = 0;

    Node current = first;
    while(current != null) {  // "current != last" is WRONG as last isn't counted.
      if(current.value == item) return ix;
      current = current.next;
      ix++;
    }
    return -1;
  }

  public boolean contains(int item) {
//    Node current = first;     // looping pattern
//    while(current != null) {
//      current = current.next;
//    }

   // This is OK But
//    Node current = first;
//    while(current != null) {
//      if(current.value == item) return true;
//      current = current.next;
//    }
//    return false;

    // ### this is way better ###
    return indexOf(item) != -1;
  }

  public void removeFirst() {
    if(isEmpty()) // no entry
      throw new NoSuchElementException();

    // approach 1
    //first = first.next;   // works but BAD idea. Memory leak!

    // approach 2
    if(first == last) { // single entry
      first = last = null;
      return;
    }

    // 2+ entries
    var second = first.next;
    first.next = null;  // So this removed node can be garbage collected!
    first = second;
  }

  public void removeLast() {
    if(isEmpty())
      throw new NoSuchElementException();

    if(first == last) {
      first = last = null;
    }

    // BAD approach
//    Node preCurrent = first;
//    Node current = first.next;
//    while(current != null) {
//      if(current == last) {
//        // then preCurrent should be the last
//        last = preCurrent;
//        return;
//      }
//      preCurrent = current;
//      current = current.next;
//    }

    // better approach
    var prev = getPrevious(last);
    if(prev == null)
      throw new NoSuchElementException();

    last = prev;
    last.next = null;   // *** so the removed last node can be garbage collected.
  }

  private Node getPrevious(Node node) {
    var current = first;
    while(current != null) {
      if(current.next == node) return current;
      current = current.next;
    }
    return null;
  }

  private boolean isEmpty() {
    return first == null;
  }
}

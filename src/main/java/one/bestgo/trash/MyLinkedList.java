package one.bestgo.trash;

// BAD BAD Design. Look ar BetterLinkedList
public class MyLinkedList {
  private Node first;
  private Node last;

  public MyLinkedList() {
    last = new Node(-1, null);
    first = new Node(-1, last);
  }

  public void addFirst(int val) {
    Node one = new Node(val, null);
    if (first.getNext() == last) {
      one.setNext(last);
    } else {
      one.setNext(first.getNext());
    }
    first.setNext(one);
  }

  public void addLast(int val) {
    var next = first.getNext();  // Node next = first.getNext();
    Node lastNode = null;
    while (next != last) {
      lastNode = next;
      next = next.getNext();
    }

    if(lastNode == null) {
      addFirst(val);
    } else {
      Node one = new Node(val, last);
      lastNode.setNext(one);
    }
  }

  public void deleteFirst() {
    Node one = first.getNext();
    if(one != null) {
      first.setNext(one.getNext());
    }
  }

  public void deleteLast() {
    Node preOne = first;
    Node one = first.getNext();
    while(one != last) {
      Node next = one.getNext();
      if(next == last) {
        break;
      } else {
        preOne = one;
        one = next;
      }
    }

    if(one != last) {
      preOne.setNext(last);
    }
  }

  public boolean contains(int target) {
    boolean found = false;
    Node one = first.getNext();
    while(one != last) {
      if(target == one.getData()) {
        found = true;
        break;
      }
      one = one.getNext();
    }
    return found;
  }

  public int indexOf() {
    return -1;
  }

  public void print() {
    Node one = first.getNext();
    while(one != last) {
      System.out.println(one.getData()+", ");
      one = one.getNext();
    }
  }
}

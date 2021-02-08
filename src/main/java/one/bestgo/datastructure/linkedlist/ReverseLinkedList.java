package one.bestgo.datastructure.linkedlist;

/**
 * Given pointer to the head node of a linked list, the task is to reverse the linked list.
 * We need to reverse the list by changing the links between nodes.
 */
public class ReverseLinkedList {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add(2);
    list.add(3);
    list.add(4);
    list.print();
    System.out.println("Reversed:");
    list.reverse();
    list.print();
  }
}

class LinkedList {
  public class Node {
    private int value;
    private Node next;

    public Node(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private Node head;

  public void add(int value) {
    Node newNode = new Node(value);
    if(head == null) {
      head = newNode;
      return;
    }

    Node current = head;
    while(current != null) {
      if(current.next == null) {  // last node
        current.next = newNode;
        break;                    // *** forgot this line
      }
      current = current.next;
    }
  }

  public void reverse() {
    Node current = head;
    Node priorNode = null;
    Node nextNode = null;
    while(current != null) {
      nextNode = current.next;
      current.next = priorNode;
      priorNode = current;
      current = nextNode;
      if(current == null) head = priorNode; // ***
    }
  }

  public void print() {
    Node current = head;
    while(current != null) {
      System.out.println(current);
      current = current.next;
    }
  }
}

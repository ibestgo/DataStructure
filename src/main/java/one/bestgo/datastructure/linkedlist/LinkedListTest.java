package one.bestgo.datastructure.linkedlist;
import one.bestgo.trash.MyLinkedList;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListTest {

  public static void main(String[] args) {
    //usecase1();
    usecase2();
  }

  private static void usecase2() {
    BetterLinkedList list = new BetterLinkedList();
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    list.addFirst(5);
    //list.deleteLast();
    System.out.println("Contained 10? "+list.contains(10));

    //list.print();
  }

  private static void usecase1() {
    LinkedList list = new LinkedList(); // if generics is not used, any object can be added
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    list.addFirst(5);
    list.add(1, 7);
    list.set(1, 8);
    System.out.println(list.get(1));  // 8
    list.removeFirst();
    list.removeLast();
    list.remove(0);
    list.contains(10);  // true
    list.indexOf(10);
    list.size();
    System.out.println(list); // [10, 20]

    Integer[] nums = new Integer[list.size()];
    list.toArray(nums);
    System.out.println(Arrays.toString(nums));  // [10, 20]

    // didn't work as it wasn't defined as LinkedList<Integer>
//    int[] nums2 = list.stream().mapToInt(Integer::intValue).toArray();
//    System.out.println(nums2[0]);
  }
}


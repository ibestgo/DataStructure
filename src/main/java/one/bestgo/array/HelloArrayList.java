package one.bestgo.array;

import java.util.ArrayList;
import java.util.Arrays;

public class HelloArrayList {
  public static void main(String[] args) {
    usecase1();
  }

  private static void usecase1() {
    //ArrayList<> list = new ArrayList<Integer>();  // Error. see the right one below
    java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
    list.add(10);
    list.add(20);
    list.add(30);
    //list.set(3, 40);        // Error. set doesn't increase the length of the dynamic array.
    list.set(1, 25);
    System.out.println(list.get(1));  // 25
    list.remove(0);   // arg could be an index or value
    list.remove(Integer.valueOf(30)); // "new Integer(30)" -> deprecated
    System.out.println(list); // [25]
    System.out.println(list.indexOf(25)); // 0
    System.out.println(list.lastIndexOf(25)); // 0
    System.out.println(list.size());  // 1. Note that there is no length()

    Integer[] numbers = new Integer[list.size()];
    list.toArray(numbers);  // if smaller size is passed, new array will be allocated.
    System.out.println(Arrays.toString(numbers));  // [25]

    // how to convert to primitive int array?
    int[] nums = list.stream().mapToInt(Integer::intValue).toArray();
    //int[] nums = list.stream().mapToInt(i -> i).toArray();  // same as above
    System.out.println(nums[0]);  // 25
  }
}

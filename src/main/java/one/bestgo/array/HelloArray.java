package one.bestgo.array;

import one.bestgo.lib.MyArray;

import java.util.Arrays;

public class HelloArray {
  private static void usecase1() {
    int[] numbers = new int[3];
    System.out.println(numbers);                  // [I@5674cd4d
    System.out.println(Arrays.toString(numbers)); // [0, 0, 0]

    // numbers = { 10, 20, 30 };      // Error. array initializer can't be used here but when it is first time defined
    int[] numbers2 = { 10, 20, 30 };  // OK
    System.out.println(Arrays.toString(numbers2)); // [10, 20, 30]
  }

  private static void usecase2() {
    MyArray numbers = new MyArray(3);
    numbers.insert(10);
    numbers.insert(20);
    numbers.insert(30);
    numbers.insert(40);
    System.out.println("Removed Value: "+numbers.removeAt(3));
    System.out.println(numbers.indexOf(100));
    numbers.print();
  }

  public static void main(String[] args) {
    usecase1();
    usecase2();
  }
}

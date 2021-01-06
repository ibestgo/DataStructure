package com.bestgo.hello;

import java.util.Scanner;

public class HelloMain {

  public int sum(int a, int b) {
    if ((a == Integer.MAX_VALUE && b > 0) || (b == Integer.MAX_VALUE && a > 0)
        || (a == Integer.MIN_VALUE && b < 0) || (b == Integer.MIN_VALUE && a < 0)) {
      throw new IllegalArgumentException("Sum can't be larger than MAX or less than MIN value");
    }
    return a + b;
  }

  public void scannerExample() {
    System.out.print("Enter your age: ");
    Scanner sc = new Scanner(System.in);
    int age = sc.nextInt();
    System.out.println("Your age is "+age);
    sc.close();
  }

  public static void main(String[] args) {
    HelloMain main = new HelloMain();

    // 1)
    int result = main.sum(4, 5);
    System.out.println("Result: " + result);

    // 2)
    //main.scannerExample();
  }
}

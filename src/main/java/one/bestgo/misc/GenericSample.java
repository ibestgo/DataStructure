package one.bestgo.misc;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GenericSample {
  public static void main(String[] args) {
    TwoSet<String> ts1 = new TwoSet<>();
    ts1.add("baechul");

    TwoSet<Integer> ts2 = new TwoSet<>();
    ts2.add(5);

    TwoSet ts3 = new TwoSet();  // warning: raw use of parameterized class.
    ts3.add("abc");             // unchecked warning. not enough info for type-safety

    GenericTest3 test3 = new GenericTest3();
    test3.display("me");
  }
}

// Generic Classes
class TwoSet<T> {
  ArrayList<T> data;
  public TwoSet() {
    data = new ArrayList<>();
  }

  public void add(T one) {
    data.add(one);
  }
}

class GenericTest<T> {
  T data;
  public GenericTest(T data) {
    this.data = data;
  }
  public T getObject() {
    return data;
  }
}

class GenericTest2<T, U> {
  T obj1;
  U obj2;

  GenericTest2(T obj1, U obj2) {
    this.obj1 = obj1;
    this.obj2 = obj2;
  }
}

// Generic Functions
class GenericTest3 {
  public <T> void display(T data) {
    System.out.println(data.getClass().getName()+"="+data);
  }
}

class Stack<T> {
  private final T[] data;

//  public Stack(int size) {
//    if(size < 1) size = 100;
//    data = new T[size];   // Type parameter can't be instantiated directly.
//  }
  public Stack(Class<T> clazz, int size) {
    if(size < 1) size = 100;
    data = (T[])Array.newInstance(clazz, size);
  }

}


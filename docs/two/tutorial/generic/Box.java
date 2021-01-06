package com.bestgo.tutorial.generic;

/**
 * Generic version of the Box class.
 * @param <T> the type of the value being boxed
 */
public class Box<T> {
  private T t;

  public void set(T t) { this.t = t; }
  public T get() { return t; }
}

// Box<Integer> integerBox = new Box<Integer>();  // OR simply new Box<>() for java7+
// OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>(...));
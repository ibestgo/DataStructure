package com.bestgo.tutorial.generic;

// Generic Method
public class Util {

  public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
    return p1.getKey().equals(p2.getKey()) &&
        p1.getValue().equals(p2.getValue());
  }

  public <T extends Box> T save(T acd) {
    return null;
  }
}

/*
  Pair<Integer, String> p1 = new Pair<>(1, "apple");
  Pair<Integer, String> p2 = new Pair<>(2, "pear");
  boolean same = Util.<Integer, String>compare(p1, p2);
*/


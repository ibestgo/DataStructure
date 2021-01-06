package com.bestgo.hello;

public class MyBase {

  protected String toString(int[] org) {
    String ret = "[";
    for(int one: org) {
      ret += (one + ", ");
    }
    return (ret.endsWith(", "))? ret.substring(0, ret.length()-2) + "]" :  ret+"]";
  }

  protected String toString(long[] org) {
    String ret = "[";
    for(long one: org) {
      ret += (one + ", ");
    }
    return (ret.endsWith(", "))? ret.substring(0, ret.length()-2) + "]" :  ret+"]";
  }
}

package com.bestgo.misc;

public class MiscAlgorithms {

  public MiscAlgorithms() {}

  // 1 1 2 3 5 8
  public int[] fibonacci1(int size) {
    if(size < 1) {
      throw new IllegalArgumentException("size should be 1 or above");
    }

    int[] arrs = new int[size];
    for(int i=0; i<size; i++) {
      arrs[i] = getFibonacci1(i);
    }
    return arrs;
  }

  // or simply return as long.
  // this nested approach is not practical for the bigger size like 50+ as it takes too long time.
  protected int getFibonacci1(int index) {
    if(index == 0 || index == 1) return 1;

    int ret1 = getFibonacci1(index-2);
    int ret2 = getFibonacci1(index-1);
    long sum = ret1+ret2;
    if(sum > Integer.MAX_VALUE) {
      throw new RuntimeException("Output is beyond the valid integer range for "+index);
    }
    return ret1+ret2;
  }

  public int[] fibonacci2(int size) {
    if(size < 1) {
      throw new IllegalArgumentException("size should be 1 or above");
    }

    int[] arrs = new int[size];
    for(int i=0; i<size; i++) {
      arrs[i] = getFibonacci2(i);
    }
    return arrs;
  }

  // much better
  protected int getFibonacci2(int index) {
    if(index == 0 || index == 1) return 1;
    int ret = 0;
    int p1=1, p2=1;

    for(int i=2; i<=index; i++) {
      ret = p1+p2;
      p1 = p2;
      p2 = ret;
    }

    // if out of integer range
    if(ret<0) {
      throw new RuntimeException("Output is beyond the valid integer range for "+index);
    }
    return ret;
  }
}

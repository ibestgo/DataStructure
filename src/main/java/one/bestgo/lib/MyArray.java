package one.bestgo.lib;

public class MyArray {
  private int[] data;
  private int ptr = 0;  // ptr is actually count

  public MyArray(int length) {
    if(length < 0 || length > Integer.MAX_VALUE)
      throw new IllegalArgumentException("invalid arg passed");
    data = new int[length];
  }

  private void extend() {
    int[] newData = new int[data.length * 2];
    for(int i=0; i<data.length; i++)
      newData[i] = data[i];
    data = newData;
  }

  // shrink to half
  private void shrink() {
    int[] newData = new int[(int)(data.length * 0.5)];
    for(int i=0; i<ptr; i++)
      newData[i] = data[i];
    data = newData;
  }

  public void insert(int val) {
    if(ptr == data.length) {
      extend();
    }
    data[ptr++] = val;
  }
  public int removeAt(int ix) {
    if(ix < 0 || ix >= ptr)
      throw new IllegalArgumentException("invalid arg passed");
    int removedValue = data[ix];

//    for(int i= ix+1; i<data.length; i++)  // this works too but...
//      data[i-1] = data[i];
    for(int i= ix; i< ptr; i++)   // this would be better
      data[i] = data[i+1];

    ptr--;
    if(ptr < (int)(data.length * 0.25)) {
      // then shrink it to half
      shrink();
    }
    return removedValue;
  }

  // Best case: O(1)
  // Worst case: O(n)
  // this method of O(x) is from the worst case. Hence this method is O(n)
  public int indexOf(int val) {
    int ret = -1;
    for(int i=0; i<ptr; i++) {
      if(data[i] == val) {
        ret = i;    // or return i here w/o break.
        break;
      }
    }
    return ret;
  }

  public void print() {
    for(int i=0; i<ptr; i++) {
      System.out.println(data[i]);
    }
    //System.out.println(Arrays.toString(data));
  }
}

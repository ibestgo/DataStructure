package one.bestgo.misc;

public class FinalTest {
  public static void main(String[] args) {
    final int[] arr = {1, 2};
    arr[0] = 10;          // OK

    // arr = new int[5];  // ERROR as arr is defined as a final variable so it can't have another reference.
  }
}

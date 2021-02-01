package one.bestgo.datastructure.string;

public class ReverseString {
  public static void main(String[] args) {
    String[] strs = {"hello", "saja"};
    for(String str : strs) {
      System.out.println(reverse(str));
    }
  }

  private static String reverse(String str) {
    char[] chars = str.toCharArray();
    int m = chars.length/2;
    for(int i=0; i<m; i++) {
      swap(chars, i, chars.length-1-i);
    }
    return new String(chars);
  }

  private static void swap(char[] c, int i, int j) {
    if(i >= c.length || j >= c.length)
      throw new IllegalArgumentException("");
    char temp = c[j];
    c[j] = c[i];
    c[i] = temp;
  }
}

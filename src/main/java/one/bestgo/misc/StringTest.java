package one.bestgo.misc;

import java.util.Arrays;

public class StringTest {
  public static void main(String[] args) {
    String s1 = "haha";
    String s2 = s1;   // s2 is NOT a reference to s1 but s1 will be copied to s2.
    s1 = s1+" by kim";
    System.out.println(s1); // haha by kim
    System.out.println(s2); // haha

    // thread-safe
    StringBuffer buffer = new StringBuffer();
    buffer.append("haha");
    buffer.toString();

    // not thread-safe
    StringBuilder builder = new StringBuilder();
    builder.append("haha");
    builder.toString();

    System.out.println(s2.contentEquals(buffer));   // true
    System.out.println(s2.contentEquals(builder));  // true

    String str = "1) we aare the world";
    String[] words = str.split("\\s");
    System.out.println(Arrays.toString(words));  // [1), we, are, the, world]

    String[] ms = {
        "^1",         // false
        "^1(.*)",     // true
        "^1\\)(.*)",  // true
        ".*world$",   // true
        "(.*)world$", // true. better than the above one.
        "(.*)we\\s(a+)(.*)",  // true
    };

    for(String one: ms)
      System.out.println(str.matches(one));
  }
}

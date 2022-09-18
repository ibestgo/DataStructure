package one.bestgo.datastructure.string;

import java.util.Arrays;

public class AddIntegerString {
  public static void main(String[] args) {
    String num1 = "51";
    String num2 = "0";
    System.out.println(convertToInt(num1)+convertToInt(num2));
  }

  private static String addString(String num1, String num2) {
    if(num1 == null || num2 == null) throw new IllegalArgumentException("");
    int sum = convertToInt(num1) + convertToInt(num1);
    return String.valueOf(sum);
  }

  private static int convertToInt(String numStr) {
    if(numStr == null || numStr.isEmpty()) throw new IllegalArgumentException("");
    char[] chars = numStr.toCharArray();
    int[] ints = new int[chars.length];

    //char[] zeroChars = "0".toCharArray();
    for(int i=0; i<chars.length; i++) {
      //ints[i] = chars[i] - zeroChars[0];  // *** minus result of char/byte array will be integer
      ints[i] = chars[i] - '0'; // or simply
      if(ints[i] > 9 || ints[i] < 0)
        throw new IllegalArgumentException("");
    }

    int sum = 0;
    for(int i=0; i<ints.length; i++) {
      sum += ints[i] * Math.pow(10, (ints.length-1-i)); // ***
    }

    return sum;
  }

//  private static int convertToInt(String numStr) {
//    byte[] bytes = numStr.getBytes();
//    if(bytes == null || bytes.length == 0) throw new IllegalArgumentException("");
//    int[] ints = new int[bytes.length];
//
//    byte[] zeroBytes = "0".getBytes();
//    for(int i=0; i<bytes.length; i++) {
//      ints[i] = bytes[i] - zeroBytes[0];
//    }
//
//    int sum = 0;
//    for(int i=ints.length-1; i>=0; i--) {
//      sum += ints[i] * Math.pow(10, i);
//    }
//    return sum;
//  }
}

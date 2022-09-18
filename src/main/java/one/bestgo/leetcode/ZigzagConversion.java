package one.bestgo.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/zigzag-conversion
public class ZigzagConversion {

  // PASSED
  public String convert(String s, int numRows) {
    if(numRows == 1) return s;

    Map<Integer, StringBuilder> map = new HashMap<>();
    for(int i=0; i<numRows; i++) {
      map.put(i, new StringBuilder());
    }

    for(int i=0; i<s.length(); i++) {
      int u = (numRows-1)*2;
      int r = i % u;
      int m = (numRows-1);

      int key = r;
      if(r>m) {   // adjust key
        key = m - (r-m);
      }
      map.get(key).append(s.charAt(i));
    }

    String str = "";
    for(StringBuilder one : map.values()) {
      str += one.toString();
    }
    return str;
  }
}

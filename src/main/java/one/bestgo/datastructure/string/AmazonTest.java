package one.bestgo.datastructure.string;

import java.util.*;

public class AmazonTest {
  // Return the smallest substring of s2 that contains chars in s1.
  // s1: "abc"
  // s2: "ooaoobcr"
  // returns "aoobc"
  public static void main(String[] args) {
    String[][] strs = {
        //{"abc", "ooaoobr"},   // should print aoob
        //{"abc", "ooaoobcr"},  // should print aoobc
        {"tist", "this is a test string"}  // should print "t stri"
    };

    for(String[] row: strs) {
      List<String> list = getSmallestSubstrings3(row[0], row[1]);
      System.out.println(list); // [ooaoobc, oaoobc, aoobc] // they have all 3. Without Logic 1
      // need to have only smallest length: hence added Logic One
    }

    System.out.println(getSmallestSubstrings4("tist", "this is a test string"));
  }

  // return exactly and partially matched smallest ones. s1 is the pattern to search in s2
  private static List<String> getSmallestSubstrings(String s1, String s2) {
    int max = 0;
    List<String> list = new ArrayList<>();
    for(int i=0; i<s2.length(); i++) {
      for (int j = i+1; j<s2.length()+1; j++) { // or j=i okay but j=i+1 is better
        String subStr = s2.substring(i, j);
        int count = contains(subStr, s1);
        //System.out.println(subStr+": "+count);
        if(count > max) {
          list.clear();
          list.add(subStr);
          max = count;
        } else if(count == max) {
          // Logic 1: There are substr that has the same match length. Only smallest should remain
          Iterator<String> it = list.iterator();
          while(it.hasNext()) {
            String one = it.next();
            if(one.length() > subStr.length()) it.remove(); // *** NOT list.remove(one);
          }
          // list.add(subStr);  // **** NOOP! Not yet.
          if(list.isEmpty()) list.add(subStr);
          else { // [t stri, t strin] both are 4 but only smallest should remain, I added the following line
            if (list.get(0).length() == subStr.length()) list.add(subStr); // now "t strin" is not added!
          }
        }
      }
    }
    return list;
  }

  // return exactly matched smallest ones. s1 is the pattern
  private static List<String> getSmallestSubstrings2(String s1, String s2) {
    int min = Integer.MAX_VALUE;
    List<String> list = new ArrayList<>();
    for(int i=0; i<s2.length(); i++) {
      for (int j = i+1; j<s2.length(); j++) { // or j=i okay but j=i+1 is better
        String subStr = s2.substring(i, j);
        int count = contains(subStr, s1);
        //System.out.println(subStr+": "+count);
        if(count == s1.length()) {
          // now exactly matched. add only smallest substr
          if (list.isEmpty() || subStr.length() == min) {
            list.add(subStr);
            min = subStr.length();
          } else {
            if(subStr.length() < min) {
              list.clear();
              list.add(subStr);
              min = subStr.length();
            }
          }
        }
      }
    }
    return list;
  }

  /**
   * s1 = "tist"
   * s2 = "this is a test string"
   * [this, stri, strin] counted as 4 ...... BUT should be counted as 3!!!! Hence added Logic 2
   * "t stri" counted as 4, which is right.
   */
  private static int contains(String str, String target) {
    char[] s = str.toCharArray();
    char[] t = target.toCharArray();

    int[] map = new int[s.length];  // default value is 0
    int count = 0;

    for(int i=0; i<t.length; i++) {
      for(int j=0; j<s.length; j++) {
           if(map[j] != 1 && t[i] == s[j]) {
             count++;
             map[j] = 1;  // Logic 2: meaning used hence ignore
             break;
           }
      }
    }
    return count;
  }

  private static List<String> getSmallestSubstrings3(String pat, String str) {
    List<String> list = new ArrayList<>();

    char[] ss = str.toCharArray();
    char[] ps = pat.toCharArray();
    if (ss.length < ps.length) {
      System.out.println("No such window exists");
      return list;
    }

    Map<String, Integer> sm = new HashMap<>();
    Map<String, Integer> pm = new HashMap<>() {
      {
        for(char one : ps) {
          String key = String.valueOf(one);
          int value = get(key) == null? 1 : get(key) + 1;
          put(key, value);
        }
      }
    };

    int minLen = Integer.MAX_VALUE;
    int start = 0;
    int count = 0;
    for(int i=0; i<ss.length; i++) {
      String key = String.valueOf(ss[i]);
      int value = sm.get(key)==null? 1 : sm.get(key)+1;
      sm.put(key, value);

      if(pm.containsKey(key) && sm.get(key) <= pm.get(key)) count++;
      if(count == ps.length) {
        // found.: start ~ i
        while(pm.containsKey(String.valueOf(ss[start])) && (sm.get(String.valueOf(ss[start])) > pm.get(String.valueOf(ss[start])))) {
          String k = String.valueOf(ss[start]);
          if(pm.containsKey(k) && (sm.get(k) > pm.get(k))) sm.put(k, sm.get(k)-1);
          start++;
        }

        // check the smallest length: from start to i
        int len = (i-start)+1;
        if(len < minLen) {
          minLen = len;
          list.clear();
          list.add(str.substring(start, i));
        } else if(len == minLen) {
          list.add(str.substring(start, i));
        }
      }
    }
    return list;
  }

  // https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
  private static String getSmallestSubstrings4(String pat, String str) {
    int len1 = str.length();
    int len2 = pat.length();
    if (len1 < len2) {
      System.out.println("No such window exists");
      return "";
    }

    final int no_of_chars = 256;
    int hash_pat[] = new int[no_of_chars];
    int hash_str[] = new int[no_of_chars];

    // Store occurrence ofs
    // characters of pattern
    for (int i = 0; i < len2; i++)
      hash_pat[pat.charAt(i)]++;

    int start = 0, start_index = -1,
        min_len = Integer.MAX_VALUE;

    // Start traversing the string
    // Count of characters
    int count = 0;
    for (int j = 0; j < len1; j++) {
      // Count occurrence of characters of string
      hash_str[str.charAt(j)]++;

      // If string's char matches with pattern's char then increment count
      if (hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)]) count++;

      // If all the characters are matched
      if (count == len2) {
        // Try to minimize the window
        while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] || hash_pat[str.charAt(start)] == 0) {
          if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
            hash_str[str.charAt(start)]--;
          start++;
        }

        // update window size
        int len_window = j - start + 1;
        if (min_len > len_window) {
          min_len = len_window;
          start_index = start;
        }
      }
    }

    if (start_index == -1) {
      System.out.println("No such window exists");
      return "";
    }

    // Return substring starting from start_index and length min_len
    return str.substring(start_index, start_index + min_len);
  }
}

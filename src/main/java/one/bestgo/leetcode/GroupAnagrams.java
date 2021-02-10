package one.bestgo.leetcode;
import java.util.*;

// https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {
  public static void main(String[] args) {
    String[] strs = { "abc", "def", "bca", "ddddddg", "gdddddd" };
    //String[] strs = { "a" };
    //String[] strs = { };
    System.out.println(new GroupAnagrams().groupAnagrams(strs));
  }

  // Approach 2: Categorize by Count
  // Modified version of the last my version. Faster
  // Time: O(N*K)
  public List<List<String>> groupAnagramsKimBest(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    int[] counts = new int[26];

    for(String str: strs) {                     // O(N)
      Arrays.fill(counts, 0);               // 1) init table

      char[] chs = str.toCharArray();           // 2) fill in table
      for (int i = 0; i < chs.length; i++) {    // O(K)
        int x = chs[i] - 'a';
        counts[x] = counts[x] + 1;
      }

      // can be ignored in time complexity
      StringBuilder sb = new StringBuilder();   // 3) make the key out of the table
      for (int i = 0; i < counts.length; i++) {
        if (counts[i] > 0) {
          char ch = (char) ('a' + i);
          sb.append(ch);
          sb.append(counts[i]);
        }
      }
      String key = sb.toString();

      // 4) update the map
      if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
      map.get(key).add(str);
    }

    return new ArrayList(map.values());
  }

  // Categorize by Sorted String
  // Time:O(N * KlogK) - N: length of strs. K: max length of a str in strs.
  // The outer loop has complexity O(N)O(N)O(N) as we iterate through each string.
  // Then, we sort each string in O(KlogK) time.
  // Space: map so. O(N*K)
  public List<List<String>> groupAnagrams(String[] strs) {
    // Even empty strs case is also covered by the below main logic. Hence no need.
    if (strs.length == 0) return new ArrayList();
    List<List<String>> ret = new ArrayList<>();

    // Actually this case is covered by the main logic so not necessary
    // if(strs.length == 1 && strs[0].equals("")) {
    //     ret.add(new ArrayList());
    //     ret.get(0).add("");
    //     return ret;
    // }

    Map<String, List<String>> map = new HashMap<>();
    for(String str : strs) {
      char[] chs = str.toCharArray();
      //chs = Arrays.sort(chs);   // returns void.
      Arrays.sort(chs);
      String key = String.valueOf(chs);

      if(!map.containsKey(key)) map.put(key, new ArrayList<String>());
      map.get(key).add(str);
    }

    //return map.values(ret); // error: map.values() doesn't take param
    //return (List<List<String>>)map.values();  // error can't be casted this way
    //return ret.addAll(map.values());    // error. addAll() returns boolean
    //return new ArrayList<List<String>>(map.values()); // works but no need
    //return new ArrayList(map.values());   // YES. WORKED. OR
    ret.addAll(map.values());
    return ret;
  }

  // KIM#1: Passed but not efficient
  public List<List<String>> groupAnagramsKim(String[] strs) {
    List<List<String>> ret = new ArrayList<>();
    if(strs.length == 1 && strs[0] == "") {
      List<String> group = new ArrayList<>();
      group.add("");
      ret.add(group);
      return ret;
    }

    Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
    for(String one: strs) {
      char[] chs = one.toCharArray();
      Map<Character, Integer> key = new HashMap<>();
      for(int i=0; i<chs.length; i++) {
        if(key.get(chs[i]) == null) {
          key.put(chs[i], 1);
        } else {
          int n = key.get(chs[i]);
          key.put(chs[i], n+1);
        }
      }

      if(map.get(key) == null) {
        List<String> group = new ArrayList<>();
        group.add(one);
        map.put(key, group);
      } else {
        List group = map.get(key);
        group.add(one);
      }
    }

    // now covert the map to List<List<String>>
    for(Map<Character, Integer> key: map.keySet()) {
      ret.add(map.get(key));
    }
    return ret;
  }
}

package one.bestgo;

import java.util.HashSet;
import java.util.Set;

public class Helper {

  public boolean allUniqueBetter(String s, int start, int end) {
    Set<Character> set = new HashSet<>();
    for(int i=start; i<end; i++) {
      char ch = s.charAt(i);
      if(!set.add(ch)) return false;  // Set.add(obj) will return false if dup is passed.
    }
    return true;
  }

  public boolean allUnique(String s, int start, int end) {
    Set<Character> set = new HashSet<>();
    for (int i = start; i < end; i++) {
      Character ch = s.charAt(i);
      if (set.contains(ch)) return false;
      set.add(ch);
    }
    return true;
  }
}

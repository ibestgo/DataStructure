package one.bestgo.leetcode;
import java.util.*;

// https://leetcode.com/problems/combination-sum
public class CombinationSum {

  // WRONG: My Attempt. Didn't find all of them.
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Set<List<Integer>> ret = new HashSet<>();
    if(candidates.length == 1 && target/candidates[0] == 0) return new ArrayList();

    for(int x=0; x<candidates.length; x++) {
      int n = target/candidates[x];
      for(int y=1; y<=n; y++) {
        int r = target - (candidates[x] * y);
        // check if the array contains r

        if(r == 0) {    // found
          List<Integer> l = new ArrayList<Integer>();
          for(int i=0; i<n; i++) {
            l.add(candidates[x]);
          }
          Collections.sort(l);
          ret.add(l);
        } else {
          for(int i=0; i<candidates.length; i++) {
            if(r % candidates[i] == 0) {    // found
              int k = r/candidates[i];

              List<Integer> l = new ArrayList<Integer>();
              for(int j=0; j<y; j++) {                    /// *** NOT n
                l.add(candidates[x]);
              }

              for(int j=0; j<k; j++) {
                l.add(candidates[i]);
              }

              Collections.sort(l);
              ret.add(l);

              break;
            }
          }
        }
      }
    }

    return new ArrayList(ret);
  }
}

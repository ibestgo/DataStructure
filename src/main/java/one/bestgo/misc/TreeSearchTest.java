package one.bestgo.misc;

import java.util.*;

public class TreeSearchTest {

  public static void main(String[] args) {
//    int[] candidates = {3, 2, 5};
//    int target = 8;
//    List<List<Integer>> ret = new TreeSearchTest().combinationSum(candidates, target);
//    System.out.println(ret);


    int[] candidates = {4,4,2,1,4,2,2,1,3};
    int target = 6;
    List<List<Integer>> ret = new TreeSearchTest().combinationSum2(candidates, target);
    System.out.println(ret);
  }

  // https://leetcode.com/problems/combination-sum-ii
  // Must be correct BUT failed on time limit.
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Set<List<Integer>> ret = new HashSet<>();
    Arrays.sort(candidates);

    dsf(ret, candidates, target, new ArrayList<Integer>(), 0, 0);
    return new ArrayList(ret);
  }

  private void dsf(Set<List<Integer>> ret, int[] candidates, int target, List<Integer> comb, int sum, int stId) {
    if(sum > target) return;
    if(sum == target) {
      Collections.sort(comb);
      ret.add(new ArrayList(comb));
      return;
    }

    for(int i=stId; i<candidates.length; i++) {
      comb.add(candidates[i]);
      dsf(ret, candidates, target, comb, sum+candidates[i], i+1);
      comb.remove(comb.size()-1);
    }
  }

  // https://leetcode.com/problems/combination-sum/
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> ret = new ArrayList<>();
    dfs(ret, candidates, new ArrayList<Integer>(), 0, target);
    return ret;
  }

  public void dfs(List<List<Integer>> ret, int[] candidates, List<Integer> comb, int stIdx, int target) {
    int sum = sum(comb);
    if(sum > target) return;
    if(sum == target) {
      ret.add(new ArrayList(comb));   // **** be careful NOT ret.add(comb)
      return;
    }

    for(int i=stIdx; i<candidates.length; i++) {
      comb.add(candidates[i]);
      dfs(ret, candidates, comb, i, target);
      comb.remove(comb.size()-1);
    }
  }

  private int sum(List<Integer> comb) {
    int sum = 0;
    for(int one : comb) sum += one;
    return sum;
  }

  // better version
  public List<List<Integer>> combinationSumBetter(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> ret = new ArrayList<>();
    dfs(ret, candidates, new ArrayList<Integer>(), 0, 0, target);
    return ret;
  }

  public void dfs(List<List<Integer>> ret, int[] candidates, List<Integer> comb, int sum, int stIdx, int target) {
    if(sum > target) return;
    if(sum == target) {
      ret.add(new ArrayList(comb));   // **** be careful NOT ret.add(comb)
      return;
    }

    for(int i=stIdx; i<candidates.length; i++) {
      comb.add(candidates[i]);
      dfs(ret, candidates, comb, sum+candidates[i], i, target);
      comb.remove(comb.size()-1);
    }
  }
}

package one.bestgo.leetcode;

import java.util.*;

// https://leetcode.com/problems/3sum
public class ThreeSum {

  // passed
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ret = new ArrayList<>();
    if(nums.length < 3) return ret;
    Arrays.sort(nums);

    Map<String, List<Integer>> map = new HashMap<>();
    for(int i=0; i<nums.length-2; i++) {
      int x = i+1;
      int y = nums.length-1;
      while(x<y && x<nums.length-1) {
        if(nums[i]+nums[x]+nums[y] == 0) {
          String key = nums[i]+"#"+nums[x]+"#"+nums[y];
          if(!map.containsKey(key)) {
            map.put(key, new ArrayList<Integer>());
            map.get(key).add(nums[i]);
            map.get(key).add(nums[x]);
            map.get(key).add(nums[y]);
          }
        }

        int requiredSum = 0-nums[i];
        if(requiredSum > (nums[x]+nums[y]))
          x++;
        else
          y--;
      }
    }

    ret.addAll(map.values());
    System.out.println(ret);
    return ret;
  }

  // Failed due to time limitation
  public List<List<Integer>> threeSum2(int[] nums) {
    List<List<Integer>> ret = new ArrayList<>();
    if(nums.length < 3) return ret;

    Map<String, List<Integer>> map = new HashMap<>();
    for(int i=0; i<nums.length-2; i++) {
      for(int j=i+1; j<nums.length-1; j++) {
        for(int k=j+1; k<nums.length; k++) {
          if(nums[i]+nums[j]+nums[k] == 0) {
            int[] ss = {nums[i], nums[j], nums[k]};
            Arrays.sort(ss);
            String key = ss[0]+"#"+ss[1]+"#"+ss[2];

            if(!map.containsKey(key)) {
              map.put(key, new ArrayList<Integer>());
              map.get(key).add(nums[i]);
              map.get(key).add(nums[j]);
              map.get(key).add(nums[k]);
            }
          }
        }
      }
    }

    ret.addAll(map.values());
    System.out.println(ret);
    return ret;
  }
  // Failed due to time limitation
  public List<List<Integer>> threeSum1(int[] nums) {
    List<List<Integer>> ret = new ArrayList<>();
    if(nums.length < 3) return ret;

    for(int i=0; i<nums.length-2; i++) {
      for(int j=i+1; j<nums.length-1; j++) {
        for(int k=j+1; k<nums.length; k++) {
          if(nums[i]+nums[j]+nums[k] == 0) {
            List<Integer> l = new ArrayList<>();
            l.add(nums[i]);
            l.add(nums[j]);
            l.add(nums[k]);
            Collections.sort(l);
            //if(!ret.contains(1)) ret.add(l);

            boolean found = false;
            for(List<Integer> one: ret) {
              if(one.get(0) == l.get(0) &&
                  one.get(1) == l.get(1) &&
                  one.get(2) == l.get(2)) {
                found = true;
                break;
              }
            }
            if(!found) ret.add(l);
          }
        }
      }
    }

    System.out.println(ret);
    return ret;
  }
}

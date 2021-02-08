package one.bestgo.problems;

import java.util.*;

public class LRUCacheMine {

  // or create a your own class like MaxSizeHashMap
  private int capacity;
  private Map<Integer, Integer> data;
  private LinkedList<Integer> list;

  public static void main(String[] args) {
    LRUCacheMine cache = new LRUCacheMine(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1));   // 1
    cache.put(3, 3);
    System.out.println(cache.get(2));   // -1
    cache.put(4, 4);
    System.out.println(cache.get(1));   // -1
    System.out.println(cache.get(3));   // 3
    System.out.println(cache.get(4));   // 4
  }

  public LRUCacheMine(int capacity) {
    this.capacity = capacity;
    this.data = new HashMap<>();
    this.list = new LinkedList();
  }

  public int get(int key) {
    if(data.keySet().contains(key)) {
      list.remove((Object)key);
      list.addLast(key);
      return data.get(key);
    } else
      return -1;
  }

  public void put(int key, int value) {
    if(data.keySet().contains(key)) {
      data.put(key, value);
      list.remove((Object)key);
      list.addLast(key);
    } else {
      // add it
      if(data.size() == capacity) {
        Integer lruKey = list.remove(0);
        data.remove(lruKey);
      }
      data.put(key, value);
      list.addLast(key);
    }
  }
}

// TODO: need to review later
class MaxSizeHashMap<K, V> extends HashMap<K, V> {
  private final int capacity;

  public MaxSizeHashMap(int capacity) {
    this.capacity = capacity;
  }

  @Override
  public V put(K key, V value) {
    if(size() == capacity) return null;
    return super.put(key, value);
  }
}

/*
// from other's
public class Solution {
    int cap,start=0,end=0;
    Map<Integer,Integer> map=new HashMap<>();
    LinkedList<Integer> list=new LinkedList<>();
    public Solution(int capacity) {
        cap=capacity;
    }
    public int get(int key) {
        if(map.containsKey(key)) {
            list.remove(list.indexOf(key));
            list.addLast(key);
            return map.get(key);
        }return -1;
    }
    public void set(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
            list.remove(list.indexOf(key));
            list.addLast(key);
        }else if(map.size()<cap){
            map.put(key,value);
            list.addLast(key);
        }else{
            int get=list.removeFirst();
            map.remove(get);
            map.put(key,value);
            list.addLast(key);
        }
    }
}
 */

package one.bestgo.misc;

import java.util.*;

public class CollectionsTest {
  public static void main(String[] args) {

    Queue<Integer> queue = new ArrayDeque<>();

    // add/remove/element throwable versions
    System.out.println("usecase 1");
    queue.add(3);
    queue.add(4);
    queue.add(5);
    System.out.println(queue.remove()); // 3
    System.out.println(queue); //[4, 5]
    System.out.println(queue.element()); // 4. get at the head (first) but not remove
    System.out.println(queue); //[4, 5]
    queue.clear();

    // offer/poll/peek - non throwable versions
    System.out.println("usecase 2");
    queue.offer(3);
    queue.offer(4);
    queue.offer(5);
    System.out.println(queue); // [3,4,5]
    System.out.println(queue.peek()); // 3
    System.out.println(queue); // [3,4,5]
    System.out.println(queue.poll()); // 3
    System.out.println(queue); // [4,5]
    queue.clear();

    // stack
    System.out.println("Usecase 3: Stack");
    Deque<Integer> deque = (Deque<Integer>)queue;
    deque.push(3);
    deque.push(2);
    deque.push(1);
    System.out.println(deque.peek()); // 1
    System.out.println(deque.pop());  // 1
    System.out.println(deque); // [2,3]


    // TreeMap is a SortedMap
    SortedMap<Integer, Integer> tmap = new TreeMap<>();
    tmap.put(3,3);
    tmap.put(2,2);
    tmap.put(5,5);
    for(Integer key: tmap.keySet()) {
      System.out.println(">> "+key+": "+tmap.get(key));
    }

    ////
    int[] nums = {1,2,3,4,5,6,7,8,9,0};
    HashMap<Integer, Integer> map = new HashMap<>() {
      {
        for(int i : nums) put(i ,i);
      }
    };

    Map<Integer, Integer> smap = Collections.synchronizedMap(map);
    new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (smap) {
          Set<Integer> keys = map.keySet();
          Iterator<Integer> it = keys.iterator();
          while(it.hasNext()) {
            // foo(it.next());
          }
        }
      }
    }); // .start();


    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        Set<Integer> keys = map.keySet();
        //for(Integer key: keys) {
        //}
        // OR
        Iterator<Integer> it = keys.iterator();
        while(it.hasNext()) {
          Integer key = it.next();
          Integer value = map.get(key);
          map.put(key, value+10);
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        Set<Integer> keys = map.keySet();
        Iterator<Integer> it = keys.iterator();
        while(it.hasNext()) {
          Integer key = it.next();
          Integer value = map.get(key);
          System.out.println(key+":"+value);
        }
      }
    });

    t1.start();
    t2.start();
  }
}

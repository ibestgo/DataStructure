package one.bestgo.misc;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Example1 {
  public int size = 9;

  public static void main(String[] args) throws Exception {
    new Example1().test6();
  }

  public void test6() {
    int count = 1;
    Runnable action = new Runnable() {
      @Override
      public void run() {
        System.out.println("Runnable with captured variables: " + (size + count)); // 10
      }
    };

    new Thread(action).start();
  }

  public void test5() throws InterruptedException {
    char[] char1 = new char[150000000];
    String s = new String(char1);
    System.out.println("Size before GC: "+s.length());

    char1 = null;
    Thread.sleep(1000);
    System.out.println("Size after GC: "+s.length());


    StringBuilder sb = new StringBuilder(s);
  }

  public void test4() {
    char[] char1 = new char[150000000];
    String s = new String(char1);
    StringBuilder sb = new StringBuilder(s);
  }

  public void test3() throws InterruptedException {
    WeakReference<String> wr = new WeakReference<String>(new String("hello weak reference"));
    String str = wr.get();
    System.out.println("Before GC: "+str);

    // run the GC then wait some time for GC to work
    System.gc();
    Thread.sleep(20000);

    str = wr.get();
    System.out.print("After GC: ");
    if(str != null ) {
      // great the weak ref has not been garbage collected
      System.out.println(str);
    } else {
      // oops the weak ref was garbage collected... now I will have to create another one
      System.out.println("Null. GC collected");
    }
  }

  public void test2() {
    String[] strs = {"one", "two", "three", "four", "five"};
    List<String> list1 = new ArrayList<>();
    for(String msg: strs) {
      list1.add(msg);
    }

//    for(int i=0; i<list1.size(); i++) {
//      System.out.printf("%s\n", list1.get(i));
//    }

    strs = new String[] {"one", "two", "three"};
    List<String> list2 = new ArrayList<>();
    for(String msg: strs) {
      list2.add(msg);
    }

//    editlist1(list1);
//    editlist1(list1);

    editlist2(list1, list2);
    System.out.println(list1);
  }

  public void test1() {
    System.out.println("fact(5) = "+fact(5));
  }

  // Libraries
  public void editlist2(Collection<String> l1, Collection<String> l2) {
    for(String strToAvoid : l2) {
      if(l1.contains(strToAvoid)) l1.remove(strToAvoid);
    }
  }

  public void editlist1(Collection<String> l1) {
    Iterator<String> it = l1.iterator();
    while(it.hasNext()) {
      String val = it.next();
      System.out.println(val);
      if(val.equals("two")) {
        it.remove();
      }
    }
  }

  public long fact(long n) {
    if(n <= 1) {
      return 1;
    } else {
      return n * fact(n-1);
    }
  }
}

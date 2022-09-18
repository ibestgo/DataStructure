package one.bestgo.recursion;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;

public class Fibonacci {
  public static void main(String[] args) {
    for(int i=0; i<=6; i++) System.out.printf("%d, ", fibonacci(i));
    System.out.println("");
    for(int i=0; i<=6; i++) System.out.printf("%d, ", fibonacci2(i));
    System.out.println("");

    Instant t1 = Instant.now();
    System.out.print(fibonacci(45)+": ");   // took 5435 ms
    System.out.println(Duration.between(t1, Instant.now()).toMillis());

    t1 = Instant.now();
    System.out.print(fibonacci2(45)+": ");  // took 0 ms
    System.out.println(Duration.between(t1, Instant.now()).toMillis());
  }

  private static long fibonacci(int n) {
    if(n < 0) throw new IllegalArgumentException("");
    if(n < 2) return n;
    // 2+ cases
    return fibonacci(n-2) + fibonacci(n-1);
  }

  // using memorization
  private static HashMap<Integer, Long> map = new HashMap<>();
  private static long fibonacci2(int n) {
    if(n < 0) throw new IllegalArgumentException("");
    if(n < 2) return n;
    // 2+ cases\
    if(map.containsKey(n))
      return map.get(n);
    // then calculate
    long value = fibonacci2(n-2) + fibonacci2(n-1);
    map.put(n, value);
    return value;
  }
}

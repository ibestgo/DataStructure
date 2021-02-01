package one.bestgo.recursion;

public class Factorial {
  public static void main(String[] args) {
    System.out.println(factorial(10));
    printFun(3);
  }

  // In the recursive program, provide the base case and condition.
  // If it doesn't reach the base condition, a stack overflow error will happen!
  public static long factorial(long n) {
    if(n <= 1) return 1;  // Base condition

    return n * factorial(n-1);
  }

  // Print "3 2 1 1 2 3" when printFun(3)
  public static void printFun(int n) {
    if(n < 1) return;

    System.out.printf("%d ", n);
    printFun(n-1);
    System.out.printf("%d ", n);
  }
}

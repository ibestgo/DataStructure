package one.bestgo;

public class RevertedInteger {
  public static void main(String[] args) {
    int x = 123;
    int reverted=0;

    while(x > 0) {
      reverted = reverted*10 + x%10;
      x = x/10;
    }

    System.out.println(reverted);
  }
}

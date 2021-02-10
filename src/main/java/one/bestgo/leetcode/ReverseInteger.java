package one.bestgo.leetcode;

// https://leetcode.com/problems/reverse-integer/solution/
public class ReverseInteger {
  public static void main(String[] args) {
//    System.out.println(reverse(-123));
//    System.out.println(reverse(-120));
//    System.out.println(reverse(120));
    System.out.println(new ReverseInteger().reverse(1534236469));
  }

  // BEST!
  // Time: Sounds like O(n) where n is digits but leetcode says O(log(n) because We divided the input by 10 for every iteration,
  // Space: O(1)
  public int reverseKim(int x) {
    if(x>=-9 && x<=9) return x;
    int sign = (x<-9)? -1 : 1;
    x = x*sign;

    // now positive and at least 2 digits
    int reversed = 0;
    while(x > 0) {
      int r = x%10;
      if(reversed+(r/10) > Integer.MAX_VALUE/10) return 0;
      reversed = reversed*10 + r; // then safely multifly it
      x = x/10;
    }
    return sign * reversed;
  }

  // Official
  public int reverse(int x) {
    int rev = 0;
    while (x != 0) {
      int pop = x % 10;
      x /= 10;
      if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
      if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
      rev = rev * 10 + pop;
    }
    return rev;
  }

  public int reverseKim2(int x) {
    if(x >= -9 && x <= 9 ) return x;

    // make it positive for easiness.
    boolean negative = false;
    if(x < 0) {
      negative = true;
      x = -1 * x;
    }

    int reverted = 0;
    while(x > 0) {
      if(reverted > Integer.MAX_VALUE/10) return 0; // check before multiplying 10 in the below.
      reverted = reverted*10 + x%10;  // note that reverted*10 could go over the Integer max
      x = x/10;
    }

    return negative? -1*reverted : reverted;
  }

  // works but not efficient and slow.
  public int reverseOtherGuy(int x) {
    // use StringBuilder#reverse()
    // **** NOT new StringBuilder(Math.abs(x)) You have to use append
    String reversedStr = new StringBuilder().append(Math.abs(x)).reverse().toString();
    int reversed = 0;
    try {
      reversed = Integer.parseInt(reversedStr);
    } catch(Exception e) {
      return 0;
    }
    return (x<0)? -1*reversed : reversed;
  }
}

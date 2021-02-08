src/main/java
    Welcome to Facebook!

    This is just a simple shared plaintext pad, with no execution capabilities.

    When you know what language you would like to use for your interview,
    simply choose it from the dropdown in the top bar.

    Enjoy your interview!

/*
# Given an array of integers greater than zero, find if there is a way to
# split the array in two (without reordering any elements) such that the
# numbers before the split add up to the numbers after the split. If so,
# print the two resulting arrays.
#
# In [1]: can_partition([5, 2, 3])
# Output [1]: ([5], [2, 3])
# Return [1]: True
#
# In [2]: can_partition([2, 3, 2, 1, 1, 1, 2, 1, 1])
# Output [2]([2, 3, 2], [1, 1, 1, 2, 1, 1])
# Return [2]: True
#
# In [3]: can_partition([1, 1, 3])
# Return [3]: False
#
# In [4]: can_partition([1, 1, 3, 1])
# Return [4]: False
*/

// a = [5, 2, 3]
// vmstat -SM 15
public class Facebook {

  // space: O(1)
  // time: O(n^2)
  private static boolean solution(int[] a) {
    if (a.length < 2) return false;


    for (int i = 0; i < a.length - 1; i++) {
      int sum1 = 0;
      for (int k = 0; k <= i; k++) {
        sum1 += a[k];
      }

      int sum2 = 0;
      for (int k = i + 1; k < a.length; k++) {
        sum2 += a[k];
      }

      if (sum1 == sum2) return true;
    }
    return false;
  }
}
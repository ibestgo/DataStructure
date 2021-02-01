package one.bestgo;

import java.util.ArrayDeque;

// https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
  private static class ListNode {
    int val;
    ListNode next;
    ListNode() { }
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static void main(String[] args) {
  }

  // Passed.
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode root = null;

    int c = 0;  // carryover
    while(l1 != null || l2 != null) {
    // while(!(l1==null && l2==null)) { // worked but the above is better
      int v1 = (l1==null)? 0 : l1.val;
      int v2 = (l2==null)? 0 : l2.val;
      int sum = v1 + v2;
      int a = (sum+c)%10;
      c = (int)((sum+c)/10);

      ListNode node = new ListNode(a);
      if(root == null) {
        root = node;
        //appendToLast(root, node); // Error: root will still be null
      } else {
        appendToLast(root, node);
      }

      if(l1 != null) l1 = l1.next;
      if(l2 != null) l2 = l2.next;
    }

    // ### Demn Forgot this!
    if(c != 0) appendToLast(root, new ListNode(c));
    return root;
  }

  private void appendToLast(ListNode root, ListNode node) {
    // if(root == null) {
    //     root = node;     // Error. this root is a copied reference. not the same root
    //     return;          // of the caller
    // }
    ListNode current = root;
    while(current != null) {
      if(current.next == null) {
        current.next = node;
        break;
      }
      current = current.next;
    }
  }

  // FAILED: By me.
  public ListNode addTwoNumbersBAD(ListNode l1, ListNode l2) {
    ListNode current = null;

    long n1 = getNum(l1);
    long n2 = getNum(l2);
    long sum = n1+n2;
    System.out.println(">> "+n1);
    System.out.println(">> "+n2);

    String str = String.valueOf(sum);
    for(int i=0; i<str.length(); i++) {
      int val = (int)(str.charAt(i) - '0');
      ListNode node = new ListNode(val);
      if(i==0) current = node;
      else {
        node.next = current;
        current = node;
      }
    }

    return current;
  }

  private long getNum(ListNode l1) {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    ListNode current = l1;
    while(current != null) {
      stack.push(current.val);
      current = current.next;
    }

    long sum = 0;
    int len = stack.size();
    for(int i=0; i<len; i++) {
      sum += stack.pop()* Math.pow(10, (len-i)-1);
    }
    // int i = 0;
    // while(!stack.isEmpty()) {
    //     sum += stack.pop()* Math.pow(10, (stack.size()-i)-1);
    //     i++;
    // }
    return sum;
  }

  // Official Solution
  public ListNode addTwoNumbersSolution(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
      int x = (p != null) ? p.val : 0;
      int y = (q != null) ? q.val : 0;
      int sum = carry + x + y;
      carry = sum / 10;
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
      if (p != null) p = p.next;
      if (q != null) q = q.next;
    }
    if (carry > 0) {
      curr.next = new ListNode(carry);
    }
    return dummyHead.next;
  }
}



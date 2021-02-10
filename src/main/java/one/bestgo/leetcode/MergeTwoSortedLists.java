package one.bestgo.leetcode;

// https://leetcode.com/problems/merge-two-sorted-lists
public class MergeTwoSortedLists {
  private class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  // Passed
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null && l2 == null) return null;
    if(l1 == null) return l2;
    if(l2 == null) return l1;

    ListNode r = null;
    ListNode c = null;
    ListNode i = l1;
    ListNode j = l2;

    while(i != null && j != null) {
      ListNode node = null;
      if(i.val <= j.val) {
        node = new ListNode(i.val);
        i = i.next;
      } else {
        node = new ListNode(j.val);
        j = j.next;
      }

      if(c == null) {
        c = node;
        r = c;
      } else {
        c.next = node;
        c = c.next;   // ***
      }
    }

    while (i != null) {
      ListNode node = new ListNode(i.val);
      c.next = node;
      c = c.next;   // ***
      i = i.next;
    }

    while (j != null) {
      ListNode node = new ListNode(j.val);
      c.next = node;
      c = c.next;
      j = j.next;
    }

    return r;
  }
}

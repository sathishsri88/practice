package com.leetcode.linkedlist;

import org.junit.Test;

public class SwapPairs {
  private ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode curr = dummy;
    while (curr != null && curr.next != null) {
      ListNode temp = curr.next;
      curr.next = temp.next;
      temp.next = curr;
      curr = temp;
      curr = curr.next;
//      curr = temp.next.next;
    }
    return dummy.next;
  }

  private ListNode swapPairsTmp(ListNode head) {
    if ((head == null)||(head.next == null))
      return head;
    ListNode n = head.next;
    head.next = swapPairsTmp(head.next.next);
    n.next = head;
    return n;
  }

  @Test
  public void testSwapPairs() {
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
    final ListNode listNode = swapPairs(head);
    System.out.println(listNode);
  }

  @Test
  public void testSwapPairsTmp() {
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
    final ListNode listNode = swapPairsTmp(head);
    System.out.println(listNode);
  }
}

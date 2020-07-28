package com.java.leetcode.addTwoNumbers;

class Solution {
    public static void main(String[] args) {
        // 逆序存储的
        ListNode l1 = new ListNode(3);
        ListNode l1_1 = new ListNode(4);
        ListNode l1_2 = new ListNode(2);
        l1.next = l1_1;
        l1_1.next = l1_2;
        // 逆序存储的
        ListNode l2 = new ListNode(4);
        ListNode l2_1 = new ListNode(6);
        ListNode l2_2 = new ListNode(5);
        l2.next = l2_1;
        l2_1.next = l2_2;
        ListNode listNode = addTwoNumbers(l1, l2);
        ListNode pre = listNode;
        while (pre != null) {
            System.out.println(pre.val);
            pre = pre.next;
        }


    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;
        // 进位的值
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
            
        }
        if(carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
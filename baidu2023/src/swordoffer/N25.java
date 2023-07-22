package swordoffer;

import other.ListNode;

/**
 * 合并两个排序列表
 */
public class N25 {
    public static void main(String[] args) {

    }

    /**
     * 常规方法直接操作链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newHead = new ListNode(-1);
        ListNode current = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return newHead.next;
    }

    /**
     * 递归方式
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        return merge(l1, l2);
    }

    /**
     * 合并两个节点，并返回一个头节点；至于头结点的next，交给下一次递归
     */
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}

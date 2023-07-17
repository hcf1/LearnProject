package leetcode;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode p = reverseList(head);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
        System.out.println(isValid("([}}])"));
    }

    /**
     * 判断括号是否匹配
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        char[] c = s.toCharArray();
        if (c.length % 2 != 0) {
            return false;
        }
        char[] stack = new char[c.length];
        int stackLength = -1;
        for (char value : c) {
            if (value == '(') {
                stackLength++;
                stack[stackLength] = '(';
            } else if (value == '[') {
                stackLength++;
                stack[stackLength] = '[';
            } else if (value == '{') {
                stackLength++;
                stack[stackLength] = '{';
            } else if (value == ')' && stackLength >= 0) {
                if (stack[stackLength] != '(') {
                    return false;
                }
                stackLength--;
            } else if (value == ']' && stackLength >= 0) {
                if (stack[stackLength] != '[') {
                    return false;
                }
                stackLength--;
            } else if (value == '}' && stackLength >= 0) {
                if (stack[stackLength] != '{') {
                    return false;
                }
                stackLength--;
            }
        }
        return stackLength == -1;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head != null && head.next != null) {
            ListNode prev = null;
            ListNode curr = head;
            ListNode next;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
        }
        return head;
    }
}
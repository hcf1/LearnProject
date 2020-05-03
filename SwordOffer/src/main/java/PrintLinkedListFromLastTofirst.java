import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 从尾到头输出链表
 *
 * @author hasee
 */
public class PrintLinkedListFromLastTofirst {
    /**
     * 方法1：使用栈来反向输出。时间复杂度O(n)，空间复杂度O(n)
     */
    static void reverse1(ListNode node) {
        if (node != null && node.next != null) {
//            指向第一个节点
            node = node.next;
            ArrayDeque<Integer> stack = new ArrayDeque();
            while (node != null) {
                stack.push(node.value);
                node = node.next;
            }
            for (Integer value : stack) {
                System.out.println(value);
            }
        } else {
            return;
        }
    }

    /**
     * 方法2：修改链表结构，反转链表。时间复杂度O(n)，空间复杂度O(1)
     */

    static void reverse2(ListNode node) {
        ListNode head = node;
        if (node != null && node.next != null) {
            ListNode p;
            ListNode q;
            ListNode temp;
            p = node.next;
            q = node.next.next;
            temp = node.next.next.next;
//            设置尾部
            p.next = null;
            while (temp != null) {
                q.next = p;
                p = q;
                q = temp;
                temp = temp.next;
            }
//            头结点指向链表末尾
            head.next = q;
//            将最后一个节点的next指向倒数第二个
            q.next = p;
        } else {
            return;
        }
        while (head!= null&&head.next!=null) {
            head=head.next;
            System.out.println(head.value);
        }
    }

    /**
     * 方法3：递归遍历，本质上是利用了栈。时间复杂度O(n)，空间复杂度O(n)
     */
    static void reverse3(ListNode node) {
        if (node.next != null) {
            reverse3(node.next);
        } else {
            return;
        }
        System.out.println(node.next.value);
    }

    /**
     * 方法4：Collections.reverse(),将链表装入List，然后反转(第一个与最后一个交换,第二个与倒数第二个交换...)。时间复杂度O(n)，空间复杂度O(n)
     */
    static void reverse4(ListNode node) {
        if (node!=null&&node.next != null) {
            node=node.next;
            ArrayList<Integer> list = new ArrayList<Integer> ();
            while (node != null) {
                list.add(node.value);
                node= node.next;
            }
            Collections.reverse(list);
            for (Integer value : list) {
                System.out.println(value);
            }
        }
        return;
    }
    static class ListNode {
        int value;
        ListNode next;
    }
}

package other;

/**
 * 单链表两两交换
 */
public class SwapNode {
    public static void main(String[] args) {
        SwapNode swapNode = new SwapNode();
        ListNode head = swapNode.createNode(new int[]{1, 2, 3, 4});
        ListNode result = swapNode.swapPairs(head);
        swapNode.printNode(result);
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 创建链表
     */
    public ListNode createNode(int[] nums) {
        ListNode head = new ListNode(-1, null);
        ListNode curr = head;
        for (int n : nums) {
            curr.next = new ListNode(n, null);
            curr = curr.next;
        }
        return head.next;
    }

    /**
     * 输出链表
     */
    public void printNode(ListNode head) {
        while (head != null) {
            System.out.print(" " + head.val);
            head = head.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        // 空或者只有一个节点，不需要进行交换
        if (head == null || head.next == null) {
            return head;
        }
        // 第二个节点会被交换到头部，所以提前用头节点指向它
        ListNode newHead = head.next;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1 != null && p2 != null) {
            ListNode p3 = null;
            // 交换
            if (p1.next != null && p1.next.next != null && p1.next.next.next != null) {
                p3 = p1.next.next;
                p1.next = p1.next.next.next;
                p2.next = p1;
            } else if (p1.next != null && p1.next.next != null) {//说明只剩三个节点了
                p1.next = p1.next.next;
                p2.next = p1;
                break;
            } else {// 只剩两个节点
                p1.next = null;
                p2.next = p1;
                break;
            }
            // 移动指针
            p1 = p3;
            p2 = p1.next;
        }
        return newHead;
    }
}

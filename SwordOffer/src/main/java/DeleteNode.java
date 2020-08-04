import java.util.HashMap;
import java.util.HashSet;

/**
 * @author hasee
 */
public class DeleteNode {
    /**
     * 在 O(1) 时间内删除链表节点。在给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。
     * 思路：
     * 核心：当我们想删除一个节点时，并不一定要删除一个节点本身，可以先把下一个节点的内容复制出来覆盖被删除节点的内容，然后把下一个节点删除。
     * 如果该节点不是尾节点，那么可以直接将下一个节点的值赋给该节点，然后令该节点指向下下个节点，再删除下一个节点，时间复杂度为 O(1)。
     * 如果该节点是尾节点，就需要先遍历链表，找到节点的前一个节点，然后让前一个节点指向 null，时间复杂度为 O(N)。
     * 时间复杂度分析： 如果进行 N 次操作，那么需要操作节点的次数为 N-1+N=2N-1，其中 N-1 表示 N-1 个不是尾节点的每个节点以 O(1) 的时间复杂度
     * 操作节点的总次数，N 表示 1 个尾节点以 O(N) 的时间复杂度操作节点的总次数。(2N-1)/N 约等于 2，因此该算法的平均时间复杂度为 O(1)。
     */
    static class Problem1 {
        void deleteNode(Node1 head, Node1 toBeDelete) {
            if (head == null || toBeDelete == null || head.next == null) {
                return;
            }
            //要删除的节点非最后一个节点
            if (toBeDelete.next != null) {
                toBeDelete.value = toBeDelete.next.value;
                toBeDelete.next = toBeDelete.next.next;
            } else {
                Node1 p = head;
                while (p.next != toBeDelete) {
                    p = p.next;
                }
                p.next = p.next.next;
            }
        }
    }

    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     * 思路，利用set，时间复杂度O(n)，空间复杂度O(n)
     */
    static class Problem2 {
        void deleteRepeated(Node1 head) {
            Node1 p=head;
            if (head == null || head.next == null||head.next.next == null) {
                return;
            }
            head = head.next;
            HashSet<Integer> set = new HashSet<>();
            while (head!=null&&head.next != null) {
                set.add(head.value);
                if (set.contains(head.next.value)) {
                    head.next = head.next.next;
                    continue;
                }
                head = head.next;
            }
            head = p;
        }
    }

    static class Node1 {
        int value;
        Node1 next;

        Node1(int value) {
            this.value = value;
        }
    }
}

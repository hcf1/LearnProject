package exa;
/**
 * 将0->1->2->3转换成3->2->1->0，而且不适用二外空间
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        Node node = new Node(0);
        Node head = node;
        node.next = new Node(1);
        node = node.next;
        node.next = new Node(2);
        node = node.next;
        node.next = new Node(3);
        node = node.next;
        Node result = reverse(head);
        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }

    static Node reverse(Node node) {
        Node pre = node, p = node.next, next = node.next.next;
        while (p.next != null) {
            p.next = pre;
            pre = p;
            p = next;
            next = next.next;
        }
        p.next = pre;
        node.next = null;
        return p;
    }

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}

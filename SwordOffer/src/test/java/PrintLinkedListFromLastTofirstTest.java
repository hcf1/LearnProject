import org.jetbrains.annotations.NotNull;

class PrintLinkedListFromLastTofirstTest {
    public static void main(String[] args) {
//        PrintLinkedListFromLastTofirst.ListNode head = creatListNode();
//        PrintLinkedListFromLastTofirst.reverse4(head);
        /*正式批*/
//        PrintLinkedListFromLastTofirst.Reverse11.reverse(createNode());
        PrintLinkedListFromLastTofirst.reverse22(createNode());
    }

    /**
     * 正式批
     */
    private static PrintLinkedListFromLastTofirst.LinkNode createNode() {
        PrintLinkedListFromLastTofirst.LinkNode p;
        PrintLinkedListFromLastTofirst.LinkNode head = new PrintLinkedListFromLastTofirst.LinkNode(1);
        p = head;
        p.next = new PrintLinkedListFromLastTofirst.LinkNode(2);
        p = p.next;
        p.next = new PrintLinkedListFromLastTofirst.LinkNode(3);
        p = p.next;
        p.next = null;
        return head;
    }

    @NotNull
    private static PrintLinkedListFromLastTofirst.ListNode creatListNode() {
        PrintLinkedListFromLastTofirst.ListNode head = new PrintLinkedListFromLastTofirst.ListNode();
        PrintLinkedListFromLastTofirst.ListNode node = new PrintLinkedListFromLastTofirst.ListNode();
        head.next = node;
        node.value = 0;
        node.next = new PrintLinkedListFromLastTofirst.ListNode();
        node = node.next;
        node.value = 1;
        node.next = new PrintLinkedListFromLastTofirst.ListNode();
        node = node.next;
        node.value = 2;
        node.next = new PrintLinkedListFromLastTofirst.ListNode();
        node = node.next;
        node.value = 3;
        node.next = null;
        return head;
    }
}
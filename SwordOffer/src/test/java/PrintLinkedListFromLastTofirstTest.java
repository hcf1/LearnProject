import org.jetbrains.annotations.NotNull;

class PrintLinkedListFromLastTofirstTest {
    public static void main(String[] args) {
        PrintLinkedListFromLastTofirst.ListNode head = creatListNode();
        PrintLinkedListFromLastTofirst.reverse4(head);
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
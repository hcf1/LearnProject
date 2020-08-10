package main;

public class ReverseChain {
    public static void main(String[] args) {
        MyNode testNode = new MyNode(1);
        MyNode head = testNode;
        testNode.next = new MyNode(2);
        testNode = testNode.next;
        testNode.next = new MyNode(3);

        MyNode myNode = reverse(head);
        while (myNode != null) {
            System.out.println(myNode.value);
            myNode = myNode.next;
        }
    }

    public static MyNode reverse(MyNode node) {
        if (node == null) {
            return null;
        }
        MyNode pre, p, next;
        pre = node;
        p = pre.next;
        next = p.next;
        while (p != null) {
            p.next = pre;
            pre = p;
            p = next;
            if (next != null) {
                next = next.next;
            }
        }
        node.next = null;//头结点指向null
        return pre;
    }

    public static void addTowNumbers(MyNode list1, MyNode list2) {

    }
}

class MyNode {
    MyNode next;
    int value;

    MyNode(int value) {
        this.value = value;
    }
}

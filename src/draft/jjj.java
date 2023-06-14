package draft;

public class jjj {
    public static void main(String[] args) {
        Node node = new Node(0, new Node(1, null, null), new Node(2, null, null));//根节点
        node.left = new Node(0, new Node(3, null, null), new Node(4, null, null));//根节点
        node.right = new Node(0, new Node(5, null, null), new Node(6, null, null));//根节点
    }

    static void result(Node node) {
        Node head = node;
        if (head != null&&head.left != null&&head.right!=null) {
            tra(head);
        }
        else {
            //donothing
        }
    }

    static Node tra(Node head) {
        while (head != null) {

        }
        return head;
    }

    static class Node {
        int value;
        Node left, right;

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}

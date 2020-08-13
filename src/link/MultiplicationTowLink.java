package link;

public class MultiplicationTowLink {
    public static void main(String[] args) {
        MyNode link1 = createLink(new int[]{1, 2, 3});
        MyNode link2 = createLink(new int[]{4, 5});
        int result = multiplicationTwoLink(link1, link2);
        System.out.println(result);
    }

    static MyNode createLink(int[] list) {
        MyNode head, newNode;
        head = new MyNode(-1);
        newNode = head;
        for (int i : list) {
            newNode.next = new MyNode(i);
            newNode = newNode.next;
        }
        return head.next;
    }

    static MyNode reverseLink(MyNode head) {
        MyNode pre, p, next;
        pre = head;
        p = head.next;
        if (p == null) {
            return null;
        }
        next = head.next.next;
        while (p != null) {
            p.next = pre;
            pre = p;
            p = next;
            if (next != null) {
                next = next.next;
            }
        }
        head.next = null;
        head = pre;
        return head;
    }

    static int multiplicationTwoLink(MyNode node1, MyNode node2) {
        MyNode head1 = node1, head2 = node2,keepHead2;
        int length1 = 0, length2 = 0, length = 0, keepLength2;
        if (node1 == null || node2 == null) {
            return -1;
        }
        while (node1 != null) {
            length1++;
            node1 = node1.next;
        }
        while (node2 != null) {
            length2++;
            node2 = node2.next;
        }
        keepLength2 = length2;
        length = length1 + length2;
        head1 = reverseLink(head1);
        head2 = reverseLink(head2);
        keepHead2 = head2;
        int[] result = new int[length];
        length1--;
        length2--;
        keepLength2--;
        while (head1 != null) {
            while (head2 != null) {
                int multi = head1.val * head2.val;
                int sum = result[length1 + length2 + 1] + multi;//相乘后的值加原来的个位值
                result[length1 + length2 + 1] = sum % 10;
                result[length1 + length2] += sum / 10;
                length2--;
                head2 = head2.next;
            }
            length2 = keepLength2;
            head2 = keepHead2;
            length1--;
            head1 = head1.next;
        }
        int resultNum = 0;
        for (int i : result) {
            resultNum *= 10;
            resultNum += i;
        }
        return resultNum;
    }
}

class MyNode {
    MyNode next;
    int val;

    MyNode(int val) {
        this.val = val;
    }
}

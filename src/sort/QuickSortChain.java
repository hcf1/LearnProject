package sort;

public class QuickSortChain {
    public static void main(String[] args) {
        MyNode head = createChain(new int[]{3, 2, 1, 7, 5});
        MyNode tail, p = head;
        while (p.next != null) {
            p = p.next;
        }
        tail = p;
        MyNode result = quickSort(head, tail);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    private static MyNode createChain(int[] list) {
        MyNode head, newNode = new MyNode(-1);
        head = newNode;
        for (int i : list) {
            newNode.next = new MyNode(i);
            newNode = newNode.next;
        }
        return head.next;
    }

    static MyNode quickSort(MyNode left, MyNode right) {
        if (left.next== right) {
            if (left.val > right.val) {
                swap(left, right);
            }
        }
        else if (left != right) {
            MyNode partition = partition(left, right);
            quickSort(left, partition);
            quickSort(partition.next, right);
        }
            return left;
        }

    static MyNode partition(MyNode left, MyNode right) {
        MyNode i = left.next, j = left.next, pre = left;
        while (j != null && j != right) {
            if (j.val < left.val) {
                pre = i;
                swap(i, j);
                i = i.next;
            }
            j = j.next;
        }
        swap(pre, left);
        return pre;
    }

    private static void swap(MyNode i, MyNode j) {
        int temp = i.val;
        i.val = j.val;
        j.val = temp;
    }
}

class MyNode {
    MyNode next;
    int val;

    MyNode(int val) {
        this.val = val;
    }
}

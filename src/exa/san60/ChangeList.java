package exa.san60;

import java.util.Scanner;

/**
 * 给定一个1到N的排列P1到PN（N为偶数），初始时Pi=i（1≤i≤N），现在要对排列进行M次操作，每次操作为以下两种中一种：
 * ①将排列的第1个数移到末尾；
 * ②交换排列的第1个数与第2个数、第3个数与第4个数、...、第N-1个数与第N个数。
 * 求经过这M次操作后得到的排列。
 * <p>
 * 输入描述
 * 第一行包含两个整数N和M，2≤N，M≤105。
 * <p>
 * 第二行包含M个空格隔开的整数t1到tM，1≤ti≤2。若ti=1，则表示第i次操作为操作①；若ti=2，则表示第i次操作为操作②。
 * <p>
 * 输出描述
 * 输出N个空格隔开的整数，即经过M次操作后得到的排列。
 * <p>
 * 样例输入
 * 4 3
 * 1 2 1
 * 样例输出
 * 2 1 4 3
 * <p>
 * 提示
 * 排列变化过程为：{1 2 3 4}->{2 3 4 1}->{3 2 1 4}->{2 1 4 3}。
 *
 * 通过自测
 */
public class ChangeList {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int row = in.nextInt();
//        int[] list = new int[row];
//        for (int i = 0; i < row; i++) {
//            list[i] = i + 1;
//        }
//        int a = in.nextInt();
//        int[] target = new int[a];
//        int i = 0;
//        while (in.hasNext()) {
//            target[i] = in.nextInt();
//            i++;
//            if (i == a) {
//                break;
//            }
//        }
//        printList(list, target);
        printList(new int[]{1,2,3,4}, new int[]{1, 2, 1});
    }

    static MyNode createList(int[] list) {
        if (list == null) {
            return null;
        }
        MyNode head = new MyNode(-1);
        MyNode node = head;
        for (int i : list) {
            head.next = new MyNode(i);
            head = head.next;
        }
        return node;

    }

    static void printList(int[] list, int[] target) {
        MyNode head = createList(list);
        for (int i : target) {
            if (i == 1) {
                moveFirstToLast(head);
            } else if (i == 2) {
                swapNear(head);
            }
        }
        head = head.next;
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    private static void swapNear(MyNode head) {
        head = head.next;
        while (head != null && head.next != null) {
            swap(head, head.next);
            head = head.next.next;
        }
    }

    private static void swap(MyNode p1, MyNode p2) {
        int temp = p1.value;
        p1.value = p2.value;
        p2.value = temp;
    }

    private static void moveFirstToLast(MyNode head) {
        MyNode last = head;
        if (head.next == null) {
            return;
        }
        while (last.next != null) {
            last = last.next;
        }
        last.next = head.next;
        head.next = head.next.next;
        last.next.next = null;
    }
}

class MyNode {
    MyNode next;
    int value;

    MyNode(int value) {
        this.value = value;
    }
}

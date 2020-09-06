package exa.tencenter;

import java.util.Scanner;

/**
 * 给两个排序的链表，输出他们的公共子序列
 * 输入
 * 6
 * 6 5 4 3 2 1
 * 5
 * 6 5 3 2 1
 * 输出
 * 6 5 3 2 1
 */
public class FindCommonSubSequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length1 = in.nextInt();
        int[] list1 = new int[length1];
        int i = 0;
        while (in.hasNextInt()) {
            list1[i] = in.nextInt();
            i++;
            if (i == length1) {
                break;
            }
        }
        i = 0;
        int length2 = in.nextInt();
        int[] list2 = new int[length2];
        while (in.hasNextInt()) {
            list2[i] = in.nextInt();
            i++;
            if (i == length2) {
                break;
            }
        }
        MyNode node1 = createNode(list1);
        MyNode node2 = createNode(list2);
        printCommonSubSequence(node1,node2);
    }

    static void printCommonSubSequence(MyNode list1, MyNode list2) {
        while (list1 != null && list2 != null) {
            if (list1.value == list2.value) {
                System.out.printf("%d ",list1.value);
                list1 = list1.next;
                list2 = list2.next;
            } else if (list1.value < list2.value) {
                list2 = list2.next;
            }else{
                list1 = list1.next;
            }
        }
    }

    static MyNode createNode(int[] list) {
        MyNode newNode = new MyNode(-1);
        MyNode head=newNode;
        for (int i = 0; i < list.length; i++) {
            newNode.next = new MyNode(list[i]);
            newNode = newNode.next;
        }
        return head.next;
    }
}
class MyNode{
    MyNode next;
    int value;

    MyNode(int value) {
        this.value = value;
    }
}

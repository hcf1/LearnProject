package exa.meituan;

import java.util.*;

/**
 * 美团笔试，查找一个数的逆序数，且这个数是逆序数的4倍
 * 样例输入
 * 10000
 * 样例输出
 * 1
 * 2178 8712
 */
public class FindReverseNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        findReverse(in.nextInt());
    }

    static void findReverse(int number) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 1; i <= number/4; i++) {
            if (isReverse(i, i * 4)) {
                hashMap.put(i, i * 4);
            }
        }
        System.out.println(hashMap.size());
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            System.out.printf("%d %d", entry.getKey(), entry.getValue());
            System.out.println("");
        }
    }

    static boolean isReverse(int number1,int number2) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        while (number1 != 0) {
            list1.push(number1 % 10);
            number1 /= 10;
        }
        while (number2 != 0) {
            list2.offer(number2 % 10);
            number2 /= 10;
        }
        if (list1.size() != list2.size()) {
            return false;
        }
        while (!list1.isEmpty() && !list2.isEmpty()) {
            if (!list1.pop().equals(list2.poll())) {
                return false;
            }
        }
        return true;
    }
}

package exa.wangyi;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 输入一个字符串数组，每一个字符串表示一个单词
 * 一个单词出现的频率不低于1%为关键字，输出关键字的数量   70%
 */
public class FindKeyNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i = 0;
        String[] list = new String[n];
        while (in.hasNext()) {
            list[i] = in.next();
            i++;
            if (i >= n) {
                break;
            }
        }
        findKeyNumber(list);
    }

    static void findKeyNumber(String[] list) {
        int sum = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String s : list) {
            if (hashMap.containsKey(s)) {
                hashMap.replace(s, hashMap.get(s), hashMap.get(s) + 1);
            } else {
                hashMap.put(s, 1);
            }
        }
        float target = list.length + 0.0f;
        Collection<Integer> collection = hashMap.values();
        for (int c : collection) {
            if (c / target >= 0.01) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}

package slipWindow;

import java.util.Scanner;

/**
 * 输入多个字符串，查找Good子序列出现的次数,每个字符只能使用一次，字符顺序不能替换
 * 输入
 * Goo23good Gooddd
 * 输出
 * 2
 */
public class SubStringNums {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String a = in.next();
            System.out.println(a);
        }
        findSubString(new String[]{"G123","GoodoodGGoooddjfhjdGGooo3dkdggggGoood0123\\n"});
    }
    static void findSubString(String[] list) {
        char[] target = new char[]{'G', 'o', 'o', 'd'};
        int result = 0;
        int index = 0;
        for (String s : list) {
            int i = 0;
            while ( i < s.length()) {
                if (s.charAt(i) == target[index]) {
                    i++;
                    index++;
                }
                else {
                    i++;
                }
                if (index == 4) {
                    result++;
                    index = 0;
                }
            }
        }
        System.out.println(result);
    }
}

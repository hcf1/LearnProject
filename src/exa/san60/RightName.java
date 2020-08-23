package exa.san60;

import java.util.Scanner;

/**
 * 如果名字仅由 大小写英文字母 组成且长度不超过10，则我们认为这个名字是真实有效的，否则就判定为恶意填写问卷。
 * 请你判断出由多少有效问卷（只要名字是真实有效的，就认为问卷有效）。
 * 输入描述
 * 输入第一行包含一个正整数n，表示收到的问卷数量。(1<=n<=2000)
 * 接下来有n行，每行有一个由大小写英文字母，数字，下划线组成的字符串，分别表示一份问卷的名字，字符串长度不超过100。
 * 输出描述
 * 输出只有一个整数，表示有效问卷数量。
 * 样例输入
 * 5
 * BA
 * aOWVXARgUbJDG
 * OPPCSKNS
 * HFDJEEDA
 * ABBABBBBAABBBAABAAA
 * 样例输出
 * 3
 *
 * AC
 */
public class RightName {
    public static void main(String[] args) {
//        System.out.printf("%d %d %d %d", (int) 'a', (int) 'z', (int) 'A', (int) 'Z');
//        System.out.println("");

//        Scanner in = new Scanner(System.in);
//        int row = in.nextInt();
//        String[] list = new String[row];
//        int i = 0;
//        while (in.hasNext()) {
//            list[i]=in.next();
//            i++;
//            if (i == row) {
//                break;
//            }
//        }

        printRightName(new String[]{"BA", "aOWVXARgUbJDG", "OPPCSKNS", "HFDJEEDA", "ABBABBBBAABBBAABAAA"});
//        printRightName(list);
    }

    static void printRightName(String[] list) {
        boolean flag = false;
        int result = 0;
        char[] a;
        for (String s : list) {
            flag = false;
            if (s.length() <= 10 && s.length() > 0) {
                a = s.toCharArray();
                for (char c : a) {
                    if (c < 65 || c > 122 || (c > 90 && c < 97)) {
                        flag = true;//出现不合法字符
                        break;
                    }
                }
                if (!flag) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}

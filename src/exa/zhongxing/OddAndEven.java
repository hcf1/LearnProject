package exa.zhongxing;

import java.util.Scanner;

/**
 * 给一个字符串判断对应数字的奇偶
 */
public class OddAndEven {
    public static void main(String[] args) {
//        System.out.println(0xba);
//        System.out.println((int)'0');
//        oddOrEven(new String[]{"4B", "88", "21", "AA"});
        Scanner in = new Scanner(System.in);
        int row=in.nextInt();
        int i = 0;
        String[] target = new String[row];
        while (in.hasNext()) {
            target[i] = in.next();
            i++;
            if (i == row) {
                break;
            }
        }
        oddOrEven(target);
    }

    static int oddOrEven(String[] list) {
        for (String s : list) {
            boolean isTens = true;
            if (s.charAt(0) == '0') {//开头为0表示8进制
                System.out.println(Integer.parseInt(s)%2);
                continue;
            }
            for (int i = 0; i < s.length(); i++) {
                if (65 <= s.charAt(i) && s.charAt(i)<=90) {//含有大写字母表示是16进制
                    int result;
                    if (65 <= s.charAt(s.length() - 1) &&  s.charAt(s.length() - 1)<=90) {//最后一位是字母
                        result = (int) s.charAt(s.length() - 1) % 2 == 0 ? 1 : 0;
                    } else {//最后一位是数字
                        result = (int) s.charAt(s.length() - 1) % 2 == 0 ? 0 : 1;
                    }
                    System.out.println(result);
                    isTens = false;
                    break;
                }
            }
            if (isTens) {
                System.out.println(Integer.parseInt(s)%2);//十进制
            }
        }
        return 0;
    }
}

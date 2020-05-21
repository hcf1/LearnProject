/**
 * 输入数字 n，按顺序打印出从 1 最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 */
public class Print1ToMaxOfDigits {
    /**
     * 思路一：直接先求出最大值，然后从1遍历到最大值，时间复杂度O(10**n)
     * 注意：这其实是一个大数问题，当给的n很大时无法求解
     */
    void print1(int number) {
        long max = (long) Math.pow(10, number);
        for (int i = 1; i < max; ++i) {
            System.out.println(i);
        }
    }

    /**
     * 思路二：利用字符数组存储大数，每次遍历给字符数组加一。
     * 时间复杂度O(10**n)，空间复杂度O(n)
     */
    static class PrintByString {
        void printByString(int num) {
            if (num <= 0) {
                return;
            }
            char[] chars = new char[num];
            init(chars);
            while (increment(chars) == 0) {
                printString(chars);
                System.out.println("");
            }
        }

        /**
         * 每次执行将字符串表示的数字加1
         * 思路：直接在字符数组的最右边直接加1，如果字符变成了':'则说明需要进位，那么pos原来指向的位置设为'0',pos向左移一位并再在这一位上加1，
         * 之后再进行循环判断，直到遍历到不为':'的字符。如果遇到pos为-1；说明此次increment发生了溢出，直接返回-1；不进行输出。
         */
        int increment(char[] num) {
            int pos = num.length - 1;
            num[pos] = (char) ((int) num[pos] + 1);
            if (num[pos] != ':') {
                return 0;
            } else {
//                ':'表示'9'的后一个字符
                while (num[pos] == ':') {
                    if (pos == -1) {
                        return -1;
                    }
                    //  执行进位操作
                    num[pos] = '0';
                    pos--;
                    num[pos] = num[pos] = (char) ((int) num[pos] + 1);
                }
                return 0;
            }
        }

        void printString(char[] s) {
            for (int i = 0; i < s.length; ++i) {
                if (s[i] != '0') {
                    for (int j = i; j < s.length; j++) {
                        System.out.print(s[j]);
                    }
                    return;
                }
            }
        }

        /**
         * 将字符串内容全部初始化为0
         */
        void init(char[] chars) {
            for (int i = 0; i < chars.length; ++i) {
                chars[i] = '0';
            }
        }
    }

    /**
     * 思路三：依然使用字符数组存储大数，但使用回溯法进行0~9数字的全排列。
     * 相比第二个方法的优点：代码更短
     */
    static class PrintByBacktrackingAlgorithm {
        void printNumber(int n) {
            char[] number = new char[n];
            init(number);
            calculate(number, 0);
        }

        //递归
        void calculate(char[] chars, int n) {
            n++;
            if (n > chars.length - 1) {
                printString(chars);
                return;
            }
            for (int i = 0; i <= 9; i++) {
                chars[n] = (char) (i + 48);
                calculate(chars, n);
            }
        }

        void printString(char[] s) {
            for (int i = 0; i < s.length; ++i) {
                if (s[i] != '0') {
                    for (int j = i; j < s.length; j++) {
                        System.out.print(s[j]);
                    }
                    System.out.print("\n");
                    return;
                }
            }
        }

        void init(char[] chars) {
            for (int i = 0; i < chars.length; ++i) {
                chars[i] = '0';
            }
        }
    }

}

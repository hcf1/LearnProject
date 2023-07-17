package swordoffer;

/**
 * 二进制加法
 */
public class N2 {
    public static void main(String[] args) {
        System.out.println(add("1001", "1011"));
    }

    public static String add(String a, String b) {
        StringBuilder result = new StringBuilder();
        // 下标
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            char n1 = '0';
            char n2 = '0';
            if (i >= 0) {
                n1 = a.charAt(i);
            }
            if (j >= 0) {
                n2 = b.charAt(j);
            }
            if (n1 == '0' && n2 == '0') {
                if (carry > 0) {
                    result.append('1');
                    carry--;
                } else {
                    result.append('0');
                }
            } else if (n1 != n2) {
                if (carry > 0) {
                    result.append('0');
                } else {
                    result.append('1');
                }
            } else {
                if (carry > 0) {
                    result.append('1');
                } else {
                    result.append('0');
                    carry++;
                }
            }
            i--;
            j--;
        }
        if (carry == 1) {
            result.append('1');
        }
        return result.reverse().toString();
    }
}

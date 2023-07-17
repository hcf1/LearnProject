package leetcode;

/**
 * 两个字符串相加
 */
public class N415 {
    public static void main(String[] args) {
        System.out.println(addStrings("11","123"));
    }

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        int[] result = new int[Math.max(i, j) + 1];
        int k = result.length - 1;
        while (i >= 0 || j >= 0) {
            int temp = 0;
            if (i >= 0) {
                temp += (num1.charAt(i) - '0');
                i--;
            }
            if (j >= 0) {
                temp += (num2.charAt(j) - '0');
                j--;
            }
            temp += carry;
            result[k] = temp % 10;
            k--;

            carry = temp / 10;
        }
        StringBuilder s = new StringBuilder();
        if (carry > 0) {
            s.append(1);
        }
        for (int value : result) {
            s.append(value);
        }
        return s.toString();
    }
}

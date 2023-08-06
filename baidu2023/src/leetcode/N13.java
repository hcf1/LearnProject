package leetcode;

/**
 * 罗马数字转整数
 */
public class N13 {
    public static void main(String[] args) {
        System.out.println(new N13().romanToInt("LVIII"));
    }

    public int romanToInt(String s) {
        int index = 0;
        int result = 0;
        while (index < s.length()) {
            if (s.charAt(index) == 'I' && index + 1 < s.length() && s.charAt(index + 1) == 'V') {
                result += 4;
                index += 2;
            } else if (s.charAt(index) == 'I' && index + 1 < s.length() && s.charAt(index + 1) == 'X') {
                result += 9;
                index += 2;
            } else if (s.charAt(index) == 'X' && index + 1 < s.length() && s.charAt(index + 1) == 'L') {
                result += 40;
                index += 2;
            } else if (s.charAt(index) == 'X' && index + 1 < s.length() && s.charAt(index + 1) == 'C') {
                result += 90;
                index += 2;
            } else if (s.charAt(index) == 'C' && index + 1 < s.length() && s.charAt(index + 1) == 'D') {
                result += 400;
                index += 2;
            } else if (s.charAt(index) == 'C' && index + 1 < s.length() && s.charAt(index + 1) == 'M') {
                result += 900;
                index += 2;
            } else if (s.charAt(index) == 'I') {
                result += 1;
                index++;
            } else if (s.charAt(index) == 'V') {
                result += 5;
                index++;
            } else if (s.charAt(index) == 'X') {
                result += 10;
                index++;
            } else if (s.charAt(index) == 'L') {
                result += 50;
                index++;
            } else if (s.charAt(index) == 'C') {
                result += 100;
                index++;
            } else if (s.charAt(index) == 'D') {
                result += 500;
                index++;
            } else if (s.charAt(index) == 'M') {
                result += 1000;
                index++;
            }
        }
        return result;
    }
}

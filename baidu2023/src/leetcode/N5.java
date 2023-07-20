package leetcode;

/**
 * 最长回文字串
 */
public class N5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome2("aacabdkacaa"));
    }

    /**
     * 暴力法，直接遍历每一个字串，判断其是不是回文
     */
    public static String longestPalindrome(String s) {
        String result = String.valueOf(s.charAt(0));
        char[] cArray = s.toCharArray();
        int left = 0;
        int right = 0;
        while (left < s.length()) {
            right = left;
            while (right < s.length()) {
                if (isPalindrome(cArray, left, right) && right - left + 1 > result.length()) {
                    result = s.subSequence(left, right + 1).toString();
                }
                right++;
            }
            left++;
        }
        return result;
    }

    public static boolean isPalindrome(char[] target, int left, int right) {
        while (left < right) {
            if (target[left] == target[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 动态规划，由于如果 Si=Sj，那么 P(i,j)=P(i+1,j-1)，存储每一个已经算过的字串是否是回文，避免重复计算
     */
    public static String longestPalindrome1(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        char[] sArray = s.toCharArray();
        boolean[][] temp = new boolean[s.length()][s.length()];
        temp[0][0] = true;
        int l = 2;
        int[] max = new int[]{0, 0};

        while (l <= s.length()) {
            int left = 0;
            while (left + l - 1 < s.length()) {
                int right = left + l - 1;
                if (sArray[left] == sArray[right]) {
                    if (l <= 3) {
                        temp[left][right] = true;
                    } else {
                        temp[left][right] = temp[left + 1][right - 1];
                    }

                } else {
                    temp[left][right] = false;
                }
                if (temp[left][right] && right - left > max[1] - max[0]) {
                    max[0] = left;
                    max[1] = right;
                }
                left++;
            }
            l++;
        }
        return s.substring(max[0], max[1] + 1);
    }

    /**
     * 扩展法，从 i，i 或 i，i+1 向两边扩展，如果 S(left)!=S(right)，可得出S(left-1)!=S(right+1)，所以可以避免遍历多余的子串
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = findMaxTarget(s, i, i);
            String s2 = findMaxTarget(s, i, i + 1);
            int maxLength = Math.max(s1.length(), s2.length());
            if (maxLength > result.length()) {
                result = s1.length() > s2.length() ? s1 : s2;
            }
        }
        return result;
    }

    public static String findMaxTarget(String s, int left, int right) {
        if (left < 0 || right >= s.length()) {
            return "";
        }
        char[] sArray = s.toCharArray();
        int[] max = new int[]{left, left};
        while (left >= 0 && right < sArray.length) {
            if (sArray[left] == sArray[right]) {
                if (right - left > max[1] - max[0]) {
                    max[0] = left;
                    max[1] = right;
                }
            } else {
                break;
            }
            left--;
            right++;
        }
        return s.substring(max[0], max[1] + 1);
    }
}

package slipWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 * 示例：
 * 输入：S = "ADOBECODEBANC", T = "ABC"
 * 输出："BANC"
 */
public class MinimumWindowSubString {
    public static void main(String[] args) {
        System.out.println(minWindow("edeaf", "da"));
    }

    static String minWindow(String S, String T) {
        if (S.length() < T.length()) {
            return "";
        }
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        HashMap<Character, Integer> target = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int start = 0, minLength = Integer.MAX_VALUE;
        for (char c : t) {//给目赋值
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        while (right < S.length()) {
            window.put(s[right], window.getOrDefault(s[right], 0) + 1);
            while (isValid(target, window) && left <= right) {//缩减范围
                if (right - left + 1 < minLength) {
                    start = left;
                    minLength = right - left + 1;
                }
                window.put(s[left], window.get(s[left]) - 1);
                left++;
            }
            right++;
        }
        if (minLength != Integer.MAX_VALUE) {
            return S.substring(start, start + minLength);
        }
        return "";
    }

    private static boolean isValid(HashMap<Character, Integer> target, HashMap<Character, Integer> window) {//判断当前子串是否满足要求
        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            if (window.getOrDefault(entry.getKey(), 0) < entry.getValue()) {//窗口里面的值小于目标需要的值
                return false;
            }
        }
        return true;
    }

    /*别人的滑动窗口，耗时7ms，我的耗时125ms*/
    public static String minWindow1(String s, String t) {
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }
        //用来统计t中每个字符出现次数
        int[] needs = new int[128];
        //用来统计滑动窗口中每个字符出现次数
        int[] window = new int[128];

        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;

        String res = "";

        //目前有多少个字符
        int count = 0;

        //用来记录最短需要多少个字符。
        int minLength = s.length() + 1;

        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch]++;
            if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                count++;
            }

            //移动到不满足条件为止
            while (count == t.length()) {
                ch = s.charAt(left);
                if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                    count--;
                }
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);

                }
                window[ch]--;
                left++;

            }
            right++;

        }
        return res;
    }
}

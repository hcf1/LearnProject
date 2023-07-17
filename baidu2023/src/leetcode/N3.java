package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符串的最长字串
 */
public class N3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aabaab!bb"));
        System.out.println(lengthOfLongestSubstring2("aabaab!bb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set<Character> compareArray = new HashSet<>();
        int result = 0;
        int first = 0;
        while (first < s.length()) {
            compareArray.clear();
            compareArray.add(s.charAt(first));
            for (int second = first + 1; second < s.length(); second++) {
                if (compareArray.contains(s.charAt(second))) {
                    break;
                }
                compareArray.add(s.charAt(second));
            }
            result = Math.max(compareArray.size(), result);
            System.out.println(compareArray);
            first++;
        }
        return result;
    }

    /**
     * 解法2，滑动窗口
     * 以 (a)bcabcbb开始的最长字符串为 (abc)abcbb
     * 以 a(b)cabcbb开始的最长字符串为 a(bca)bcbb
     * 以 ab(c)abcbb开始的最长字符串为 ab(cab)cbb
     * 以 abc(a)bcbb开始的最长字符串为 abc(abc)bb
     * 以 abca(b)cbb开始的最长字符串为 abca(bc)bb
     * 以 abcab(c)bb开始的最长字符串为 abcab(cb)b
     * 以 abcabc(b)b开始的最长字符串为 abcabc(b)b
     * 以 abcabcb(b)开始的最长字符串为 abcabcb(b)
     * <p>
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/227999/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set<Character> compareArray = new HashSet<>();
        int result = 0;
        int first = 0;
        int second =0;
        while (first < s.length()) {
            if (first >= 1) {
                compareArray.remove(s.charAt(first - 1));
            }
            compareArray.add(s.charAt(first));
            if (second == first) {
                second++;
            }
            while (second < s.length()) {
                if (compareArray.contains(s.charAt(second))) {
                    break;
                }
                compareArray.add(s.charAt(second));
                second++;
            }
            result = Math.max(compareArray.size(), result);
            System.out.println(compareArray);
            first++;
        }
        return result;
    }
}

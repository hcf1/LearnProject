/**
 * 自己解题,非递归模式
 * @author hasee
 */
public class Match {
    boolean match(char[] str, char[] pattern) {
        int p = 0, i = 0;
        if (str == null || pattern == null) {
            return false;
        }
        if (str.length == 0 || pattern.length == 0) {
            if (str.length == 0) {
                if (pattern.length == 0) {
                    return true;
                } else if (pattern.length == 2 && pattern[1] == '*') {
                    return true;
                } else {
                    return false;
                }
            } else if (pattern.length == 0) {
                return false;
            }
        }
        for (; i < str.length; ) {
            if (p >= pattern.length) {
                break;
            }
            if (str[i] == pattern[p] || pattern[p] == '.') {
                p++;
                i++;
            } else if (pattern[p] == '*') {
                //aab匹配a*b
                if (pattern[p - 1] == str[i] || pattern[p - 1] == '.') {
                    for (; i < str.length; i++) {
                        if (pattern[p - 1] == str[i] || pattern[p - 1] == '.') {
                            if (i == str.length - 1) {
                                int j = p - 1;
                                if (p == pattern.length-1&&i==str.length - 1&&pattern[p]=='*') {
                                    return true;
                                }
                                p++;
                                while (p < pattern.length-1) {
                                    if (pattern[j] == pattern[p] || pattern[j] == '.') {
                                        p++;
                                    } else {
                                        p++;
                                        p++;
                                    }
                                }
                            }
                        } else {
                            if (p+1<pattern.length&&pattern[p + 1] == str[i]) {
                                p++;
                                i++;
                                break;
                            } else {
                                return false;
                            }
                        }
                    }
                    i--;
                }
                //ab匹配a*b
                else {
                    p++;
                }
            }
            //bc匹配a*bc
            else if (pattern[p] != str[i]) {
                if ((p + 2 < pattern.length) && (pattern[p + 1] == '*')) {
                    p++;
                    p++;
                } else {
                    return false;
                }
            }

        }
        if (p == pattern.length && i == str.length) {
            return true;
        } else if (p == pattern.length && i <str.length) {
            return false;
        } else if (i == str.length && pattern[p] == '*') {
            return true;
        } else if (i == str.length && pattern.length == p + 2 && pattern[p + 1] == '*') {
            return true;
        } else if (i == str.length && pattern.length == p + 2 && pattern[p] == '*') {
            return true;
        }
        return false;
    }
}

/**
 * 用递归的思想解决，对于一次判断有以下情况：
 * <p>
 * 当模式中的第二个字符不是“*”时：
 * <p>
 * 如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
 * 如果字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
 * 当模式中的第二个字符是“*”时：
 * <p>
 * 如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。
 * 如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
 * 模式后移2字符，相当于x*被忽略；
 * 字符串后移1字符，模式后移2字符；
 * 字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
 */
class MatchRecursion {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern, 0, 0);

    }

    public boolean matchCore(char[] str, char[] pattern, int i, int j) {
        // 终止条件
        if (i == str.length && j == pattern.length) {
            return true;
        }
        // 当模式不足以配置字符串时
        if (i < str.length && j == pattern.length) {
            return false;
        }
        // 当模式中的第二个字符是“*”时：
        if (j + 1 < pattern.length && pattern[j + 1] == '*') {
            // 如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式
            if (i != str.length && pattern[j] == str[i] || (pattern[j] == '.' && i != str.length)) {
                return
                        // 字符串后移1字符，模式后移2字符
                        matchCore(str, pattern, i + 1, j + 2)
                                // 字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位
                                || matchCore(str, pattern, i + 1, j)
                                // 模式后移2字符，相当于x*被忽略
                                || matchCore(str, pattern, i, j + 2);
            } else {
                return matchCore(str, pattern, i, j + 2);
            }

        }
        // 如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的
        if ((i != str.length && str[i] == pattern[j]) || (pattern[j] == '.' && i != str.length)) {
            return matchCore(str, pattern, i + 1, j + 1);
        }
        // 如果字符串第一个字符和模式中的第一个字符相不匹配，直接返回false
        return false;
    }
}

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串 "+100","5e2","-123","3.1416" 和 "-1E-16" 都表示数值。但是 "12e","1a3.14","1.2.3","+-5" 和 "12e+4.3" 都不是。
 *
 * @author hasee
 */
public class IsNumeric {
    /**
     * 直接利用正则表达式
     */
    boolean isNumeric(char[] str) {
        if (str == null) {
            return false;
        }
        String REGEX = "[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(String.valueOf(str));
        return matcher.matches();
//        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}

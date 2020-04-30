
/**
 * 将字符串中所有空格替换成 %20
 * @author hasee
 */
public class ReplaceSpace {
     static void replaceSpace(StringBuilder string) {
        //计算字符串中需要被替换的空格数
        int spaceNumber = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                spaceNumber++;
            }
        }
        //设置字符串长度
        int p1 = string.length() - 1;
        string.setLength(string.length() + 2 * spaceNumber);
        int p2 = string.length() - 1;
        //开始替换，两个指针向前遍历
        int replaced=0;
        while (replaced < spaceNumber) {
            if (string.charAt(p1) == ' ') {
                string.setCharAt(p2, '0');
                p2--;
                string.setCharAt(p2, '2');
                p2--;
                string.setCharAt(p2, '%');
                p1--;
                p2--;
                replaced++;
            } else {
                string.setCharAt(p2, string.charAt(p1));
                p1--;
                p2--;
            }
        }
    }
}

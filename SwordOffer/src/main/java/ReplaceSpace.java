
/**
 * 将字符串中所有空格替换成 %20
 *
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
        int replaced = 0;
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

    static class ReplaceSpace1 {
        static void replace(StringBuilder stringBuilder) {
            char space = ' ';
            int spaceNum = 0;
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (stringBuilder.charAt(i) == space) {
                    spaceNum++;
                }
            }
            //从后向前将每一个空格替换成%20
            int pOld = stringBuilder.length()-1;//注意长度，下标等于长度减1
            stringBuilder.setLength(stringBuilder.length() + spaceNum * 2);
            int pNew = stringBuilder.length()-1;
            int replaced = 0;
            while (replaced<spaceNum) {
                if (stringBuilder.charAt(pOld) == space) {
                    stringBuilder.setCharAt(pNew, '0');
                    pNew--;
                    stringBuilder.setCharAt(pNew, '2');
                    pNew--;
                    stringBuilder.setCharAt(pNew, '%');
                    pNew--;
                    replaced++;
                } else {
                    stringBuilder.setCharAt(pNew, stringBuilder.charAt(pOld));
                    pNew--;
                    pOld--;
                }
            }
        }
    }
}

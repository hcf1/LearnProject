package other;

/**
 * 去除字符数组中多余的空格，并将其首字母大写
 * 时间复杂度 n，空间复杂度 1
 * "    HeLlo        word ！    "
 * "Hello Word ！               "
 */
public class RemoveBlank {
    public static void main(String[] args) {
        System.out.println(trim(new char[]{' ', 'H', 'e', 'L', 'l', 'o', ' ', ' ', 'w', 'o', 'r', 'd', ' ', ' '}));
    }

    public static char[] trim(char[] a) {
        int p = 0;
        boolean isFirstWord = true;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == ' ') {
                if (i >= 1 && i < a.length - 1 && a[i + 1] != ' ') {
                    p++;
                    isFirstWord = true;
                }
            } else {
                a[p] = a[i];
                a[i] = ' ';
                // 如果是小写需要转为大写
                if (isFirstWord) {
                    if (a[p] >= 97 && a[p] <= 122) {
                        a[p] -= 32;
                    }
                    isFirstWord = false;
                } else {
                    if (a[p] <= 90 && a[p] >= 65) {
                        a[p] += 32;
                    }
                }
                p++;
            }
        }
        return a;
    }

    public static void toUpperCase(char[] a) {

    }
}

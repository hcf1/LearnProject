package exa;

import java.util.Scanner;

public class KedaxunfeiFindInt {
    public static void main(String[] args) {
        String list;
        Scanner in = new Scanner(System.in);
        list = in.next();
        char[] chars = new char[list.length()];
        list.getChars(0, list.length(), chars, 0);
        findInt(chars);
    }

    static void findInt(char[] string) {
        boolean flag = true;
        for (int i = 0; i < string.length; i++) {
            if (48 <= string[i] && string[i] <= 57) {
                System.out.printf("%c", string[i]);
            }
            if (flag && string[i] == '-' && i + 1 < string.length) {
                if (49 <= string[i + 1] && string[i + 1] <= 57) {
                    System.out.printf("%c", string[i]);
                    flag = false;
                }
            }
        }
    }
}

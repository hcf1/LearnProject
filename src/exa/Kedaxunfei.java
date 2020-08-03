package exa;

import java.util.Scanner;

public class Kedaxunfei {
    public static void main(String[] args) {
        int[] list = new int[8];
        int i = 0;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            list[i] = in.nextInt();
            if (i == 7) {
                break;
            }
            i++;
        }
//        list = new int[]{0, 0, 4, 3, 0, 1, 5, 4};
        System.out.println(crosspoint(list));
    }

    static int crosspoint(int[] list) {
        int[] list2 = new int[]{list[0], list[3], list[2], list[1], list[4], list[7], list[6], list[5]};
        if (list[0] < list[2] && list[2] < list[6] && list[1] < list[3] && list[3] < list[7]) {
            return 1;
        }
        if (list[4] < list[0] && list[0] < list[6] && list[5] < list[1] && list[1] < list[7]) {
            return 1;
        }
        if (list2[0] < list2[4] && list2[4] < list2[2] && list2[3] < list2[5] && list2[5] < list2[1]) {
            return 1;
        }
        if (list2[0] < list2[6] && list2[6] < list2[2] && list2[3] < list2[7] && list2[7] < list2[1]) {
            return 1;
        }
        return 0;

    }
}

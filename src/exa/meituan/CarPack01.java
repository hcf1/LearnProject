package exa.meituan;

import java.util.Scanner;

/**
 * 输入描述
 * 输入第一行包含三个整数n，a，b，分别表示公司的车辆数量和A，B两地订单所需数量,保证a+b<=n。(1<=n<=2000)
 * <p>
 * 接下来有n行，每行两个正整数x，y，分别表示该车完成A地任务的利润和B地任务的利润。
 * <p>
 * 输出描述
 * 输出仅包含一个正整数，表示公司最大获得的利润和。
 * 样例输入
 * 5 2 2
 * 4 2
 * 3 3
 * 5 4
 * 5 3
 * 1 5
 * 样例输出
 * 18
 */
public class CarPack01 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int aNum, bNum;
//        int length = in.nextInt();
//        aNum = in.nextInt();
//        bNum = in.nextInt();
//        int[] list1 = new int[length];
//        int[] list2 = new int[length];
//        int i = 0;
//        while (in.hasNextLine()) {
//            list1[i] = in.nextInt();
//            list2[i] = in.nextInt();
//            i++;
//            if (i == length) {
//                break;
//            }
//        }
//        System.out.println(findMaxMoney(list1, list2, aNum, bNum));
        System.out.println(findMaxMoney(new int[]{4,3,5,5,1}, new int[]{2,3,4,3,5}, 2, 2));
    }

    static int findMaxMoney(int[] list1, int[] list2, int aNum, int bNum) {
        int[][][] dp = new int[list1.length+1][aNum + 1][bNum + 1];
        int[][] flag = new int[list1.length + 1][2];//记录分配第k个车前，a、b已经被分配的个数
        for (int i = 1; i <= list1.length; i++) {
            for (int j = 1; j <= aNum; j++) {
                dp[i][j][0] = findMax(list1,i);
                flag[i][0] = 1;
            }
        }
        for (int i = 1; i <= list2.length; i++) {
            for (int j = 1; j <= bNum; j++) {
                dp[i][0][j] = findMax(list2, i);//分发第一个车
                flag[i][1] = 1;
            }
        }
        for (int k = 2; k <= list1.length; k++) {//从第二个开始发，第一个手动发
            for (int i = 1; i <= aNum; i++) {
                for (int j = 1; j <= bNum; j++) {
                    if (k >= i + j) {//当前车辆数足够a、b分配
                        int iNum = dp[k - 1][i][j - 1] + list1[k - 1];
                        int jNum = dp[k - 1][i - 1][j] + list2[k - 1];
                        int num = dp[k - 1][i - 1][j - 1];
                        if (flag[k-1][0] <= i && flag[k-1][0] <= j) {
                            if (iNum > jNum && iNum > num) {
                                dp[k][i][j] = iNum;
                                flag[k][0]++;
                            } else if (jNum > iNum && jNum > num) {
                                dp[k][i][j] = jNum;
                                flag[k][1]++;
                            }else{
                                dp[k][i][j] = num;
                            }
                        } else if (flag[k-1][0] <= i) {
                            if (iNum > num) {
                                dp[k][i][j] = iNum;
                                flag[k][0]++;
                            } else {
                                dp[k][i][j] = num;
                            }
                        }else if (flag[k-1][1] <= j) {
                            if (jNum > num) {
                                dp[k][i][j] = jNum;
                                flag[k][1]++;
                            } else {
                                dp[k][i][j] = num;
                            }
                        }
                    } else {//不进行分配
                        dp[k][i][j] = Math.max(dp[k][i - 1][j - 1], Math.max(dp[k][i][j - 1], dp[k][i - 1][j]));
                    }
                }
            }
        }
        return dp[list1.length][aNum][bNum];
    }

    private static int findMax(int[] list, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < end; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        return max;
    }
}

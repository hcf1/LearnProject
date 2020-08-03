package exa;

import java.util.Scanner;

public class Pinduoduo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int targetDistance = in.nextInt();
        int choice = in.nextInt();
        if (targetDistance < 0 || targetDistance > 600) {
            return;
        }
        if (choice < 1 || choice > 100) {
            return;
        }
        int[] stepDistances = new int[choice];
        int i = 0;
        while (in.hasNextInt()) {
            stepDistances[i] = in.nextInt();
            i++;
            if (i == choice) {
                break;
            }
        }
        reachDestination(targetDistance, stepDistances);
    }

    static void reachDestination(int targetDistance, int[] stepDistances) {//targetDistance值为0时代表到达目的地
        int backTimes = 0;
        if (targetDistance == 0) {
            System.out.println("paradox");
            return;
        }
        for (int stepDistance : stepDistances) {//原题是N次筛子之前，不包括最后一次，即如果是最后一次筛子到达终点，也不能输出paradox
            if (targetDistance - stepDistance == 0) {
                System.out.println("paradox");
                return;
            }
            if (targetDistance - stepDistance > 0) {//还未到达
                targetDistance -= stepDistance;
            } else {//需要回退
                targetDistance = stepDistance - targetDistance;
                backTimes++;
            }
        }
        System.out.println(targetDistance + " " + backTimes);
    }
}

package exa.wangyi;

import java.util.HashMap;
import java.util.Scanner;

public class FrogJump {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i = 0;
        int[] list = new int[n];
        while (in.hasNextInt()) {
            list[i] = in.nextInt();
            i++;
            if (i >= n) {
                break;
            }
        }
        findWays(list);
    }

    static void findWays(int[] list) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.put(3, 4);
        for (int target : list) {
            for (int i = 3; i <= target; i++) {
                hashMap.put(i, hashMap.get(i - 1) + hashMap.get(i - 2) + hashMap.get(i - 3));
            }
        }
        for (int i = 0; i < list.length; i++) {
            System.out.println(hashMap.get(list[i]) % 10007);
        }
    }
}

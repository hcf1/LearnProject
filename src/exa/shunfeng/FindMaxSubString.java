package exa.shunfeng;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 港口新到了n个货物，工人们需要将它们通过货车运送到公司。货物会先后到达港口，第i个到达港口的货物是第i号，
 * 价值是a[i]。现在有k辆货车，每辆货车可以将编号连续的货物一起运输，容量无限，运输费用为该车货物价值的和的平方，
 * 每辆车必须装载货物。你是运输货车公司的老板，你想在赚大钱的同时降低每辆车装载货物数以控制成本。请问最大的运输费用是多少，
 * 以及在费用最大时装载货物最多的货车至少需要装载多少货物。
 * <p>
 * 输入描述
 * 第一行两个数n,k。
 * 接下来n个数a[]，第i个数为a[i]。
 * 输出描述
 * 两个数，第一个数表示最大运输费用，第二个数表示此时运输货物最多的货车最少需要装载的货物数量。
 * <p>
 * 样例输入
 * 6 3
 * 0 0 1 1 0 0
 * 样例输出
 * 4 2
 * 思路：滑动窗口
 * 货物数量-车总数+1=滑动窗口大小，求窗口内数字和的最大值的平方
 */
public class FindMaxSubString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int goods = in.nextInt();
        int cars = in.nextInt();
        int[] list = new int[goods];
        int i = 0;
        while (in.hasNextInt()) {
            list[i] = in.nextInt();
            i++;
            if (i == goods) {
                break;
            }
        }
//         findMax(new int[]{0, 0, 1, 1, 0, 0}, 3);
        findMax(list, cars);
    }

    static void findMax(int[] list, int carNumber) {
        int windowLength = list.length - carNumber + 1;
        int left = 0;
        int right = 0;
        int sum = 0;
        int max = 0;
        int goods = windowLength;
        HashMap<Integer, Integer> hashMap = new HashMap<>();//sum,start
        while (right - left + 1 <= windowLength) {
            sum += list[right];
            right++;
            max = sum;
            hashMap.put(sum, left);
        }
        right--;
        while (right < list.length) {
            sum -= list[left];
            left++;
            right++;
            if (right < list.length) {
                sum += list[right];
                if (sum > max) {
                    max = sum;
                    hashMap.put(sum, left);
                }
            } else {
                break;
            }
        }
        int start = hashMap.get(max);
        while (start < list.length && list[start] == 0) {
            goods--;
            start++;
        }
        System.out.printf("%d %d",max*max,goods);
    }
}

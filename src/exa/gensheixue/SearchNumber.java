package exa.gensheixue;
import java.util.Scanner;
/**
 * 给定一个已排序的数组和一个目标值，如果在数组里面找到这个值则返回下标，如果没有，则返回该值插入数组后的位置下标。时间复杂度需要<=O(log n)
 * 输入描述
 * 第一行输入一串整数，代表一个已排序的数组
 * <p>
 * 第二行输入一个整数，代表目标值
 * <p>
 * 输出描述
 * 输出一行，包含一个整数，代表目标值在数组中位置的下标
 * 样例输入
 * 4
 * 1 3 5 6
 * 5
 * 样例输出
 * 2
 * 思路：二分查找
 */
public class SearchNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] list = new int[length];
        int i = 0;
        while (in.hasNextInt()) {
            list[i] = in.nextInt();
            i++;
            if (i == length) {
                break;
            }
        }
        int target = in.nextInt();
        findIndex(list, target);
//        findIndex(new int[]{1,3,5,6},4);
    }

    static void findIndex(int[] list, int target) {
        int left = 0, right = list.length - 1, mid = 0;
        while (right - left > 1) {
            mid = (left + right) >> 1;
            if (target < list[mid]) {
                right = mid;
            } else if (target > list[mid]) {
                left = mid;
            } else {
                System.out.println(mid);
                return;
            }
        }
        if (list[left] == target) {
            System.out.println(left);
            return;
        }
        if (list[right] == target) {
            System.out.println(right);
            return;
        }
        System.out.println(left + 1);
    }
}


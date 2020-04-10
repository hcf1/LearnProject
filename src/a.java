import java.util.Scanner;

public class a {
    private int getTwo(int a, int b) {
        if (b == 0) {
            return a;
        }
        int temp = a % b;
        return getTwo(b, temp);
    }

    public static void main(String[] args) {
        int n = 0, flag = 0, d = -1, least = 999999, less = 999999, temp = 0;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] arr = new int[n], arr1 = new int[n - 1];
        while (flag < arr.length) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            arr[flag] = in.nextInt();
            flag++;
        }
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i + 1] - arr[i];
            if (arr1[i] <= 0) {
                break;
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] < least) {
                least = arr1[i];
                temp = i;
            }
        }
        arr1[temp] = 999999;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] < less) {
                less = arr1[i];
            }
        }
        a b = new a();
        if (least <= 0 || less <= 0) {
            System.out.println(-1);
        } else
            System.out.println(b.getTwo(less, least));
    }
}
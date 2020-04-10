import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        int n = 5, m = 3, k = 50;
////        Scanner in = new Scanner(System.in);
//        int[] a = {50, 60, 77, 99, 7};
//        int max = 0, flag = 0, sum = 0;
//        for (int i = 1; i <= m; i++) {//每天都查找一遍
//            for (int j = 0; j < a.length; j++) {//使用简单排序找出当天鸡最多的鸡场
//                if (a[j] > max) {
//                    max = a[j];
//                    flag = j;
//                }
//            }
//            for (int q = 0; q < a.length; q++) {//每天改变鸡数量
//                a[q] += k;
//            }
//            a[flag] /= 2;//取出最多鸡场的鸡
//        }
//        for (int q = 0; q < a.length; q++) {//使用简单排序找出当天鸡最多的鸡场
//            sum += a[q];
//        }
//        System.out.println(sum);

//        int n=0,p=0,max=0,flag=0;
//        Scanner scanner = new Scanner(System.in);
//        n=scanner.nextInt();
//        int[] r = new int[n];
//        for(int i=0;i<r.length;i++) {
//            r[i] = scanner.nextInt();
//        }
//        scanner.close();
//        //求出最大递增1的序列长度
//        for (int i=0;i<r.length;i++){
//            for (int j=i;j<r.length;j++){
//                p=r[i];
//                if (r[j]==p+1){
//                    p++;
//                    flag++;
//                }
//            }
//            if (max<flag){
//                max=flag;
//            }
//        }
//        if (n==1)
//            flag=1;
//        System.out.println(n-flag);

//        int n = 0, max = 0;
//        Scanner scanner = new Scanner(System.in);
//        n = scanner.nextInt();
//        int[] r = new int[n];
//        for (int i = 0; i < r.length; i++) {
//            r[i] = scanner.nextInt();//被砍去树木的集合
//        }
//        r.sort
//        scanner.close();
//        for (int i = 1; i <= 99; i=i+2) {
//            for (int j = 0; j < r.length; j++) {
//                if (i!=r[j]){
//                    n++;
//                }
//                else {
//                    if (max<n){
//                        max=n;
//                    }
//                    n=0;
//                }
//            }
//            for (int j = 0; j < r.length; j++) {
//                if (i!=r[j+1]){
//                    n++;
//                }
//                else {
//                    if (max<n){
//                        max=n;
//                    }
//                    n=0;
//                }
//            }
//        }
//        System.out.println(n);
    }
}

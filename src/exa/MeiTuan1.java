package exa;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author hcf
 * Description:
 * 美团笔试题，要求k个人去买n件商品(商品分为A类和B类)，如果商品中含有是A类，则所买的商品中最便宜的商品打五折。
 * 如果不含A类，则这个人买的商品都不打折
 */
public class MeiTuan1 {
    public static void main(String[] args) {
        //n表示商品数，k表示人数
        int n = 0, k = 0;
        float num = 0;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        ArrayList<Float> A = new ArrayList<Float>();
        ArrayList<Float> B = new ArrayList<Float>();
        int i = 0;
        while (i < n) {
            float p = in.nextInt();
            float t = in.nextInt();
            if (t == 1) {
                A.add(p);
            } else {
                B.add(p);
            }
            i++;
        }
        //如果人数大于等于A类商品数，最低价格=A类商品总价/2+B类商品总价
        if (k >= n) {
            for (float a : A) {
                num += a / 2;
            }
            for (float b : B) {
                num += b;
            }
            System.out.println(String.format("%.2f", num));
            return;
        } else {
            //否则最贵的前k-1个A类打五折，然后在剩下的全部A类和B类中取一个最小数打五折，再加上剩下的全部原价商品
            //从大到小排序
            A.sort(((o2, o1) -> (int) (o1.floatValue() - o2.floatValue())));
            int An = A.size();
            int diff = n = k;
            for (int j = 0; j < k - 1; j++) {
                num += A.get(j) / 2;
            }
            //加上最小一位A类或最小B类的二分之一
            B.sort(((o1, o2) -> (int) (o1.floatValue() - o2.floatValue())));
            if (B.get(0) < A.get(An - 1)) {
                for (int j = k - 1; j < A.size(); j++) {
                    num += A.get(j);
                }
                for (float b : B) {
                    num += b;
                }
                num -= B.get(0)/2;
            } else {
                for (int j = k - 1; j < A.size(); j++) {
                    num += A.get(j);
                }
                num -= A.get(An - 1) / 2;
                for (float b : B) {
                    num += b;
                }
            }

            System.out.println(String.format("%.2f", num));
            return;
        }
    }
}

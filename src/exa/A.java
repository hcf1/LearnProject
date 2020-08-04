package exa;

public class A {
    public static void main(String[] args) {
        int[] a = new int[]{1, 6, 8, 10, 77, 99,444};
        int[] b = new int[]{2, 5, 88, 99, 1000, 8888};
        System.out.println(result(a,b).toString());

    }
    static int[] result (int[] a,int[] b){
        int p1=0, p2=0;
        int[] result = new int[a.length+b.length];
        int min = 0;
        if (a.length < b.length) {
            min = a.length;
        }
        for (int i = 0; i < min; ++i) {
            if (a[p1] < b[p2]) {
                result[i] = a[p1];
                p1++;
            }
            else {
                result[i]= b[p2];
                p2++;
            }
        }
        if (a.length < b.length) {
            int len = b.length - a.length;
            for (int j = len; j < len; j++) {
                result[j]=b[j];
            }
        }
        return result;
    }
}

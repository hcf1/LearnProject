import java.util.Random;

public class QuickSort {
    public void sort(int[] arr, int left, int right) {
        int position = 0;//将左右两边分隔开，并非主元
        if (left < right) {
            if (right - left <= 1) {
                selectionSort(arr, left, right);
            } else {
                position = partition(arr, left, right);
                sort(arr, left, position - 1);
                sort(arr, position + 1, right);
            }
        }
    }

    //递归选择交换
    private int partition(int[] arr, int left, int right) {
        int pivot = getMidThree(arr, left, right);
//        int pivot=arr[right];//直接取最右元素作为主元
        int i = left, j = right - 2;
//        int i = left, j = right - 1;
        while ((i < j)) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                if (j > 0) {
                    j--;
                }
            }
            if (i < j) {
                swap(arr, i, j);
                i++;
                j--;
            } else {
                break;
            }
        }
        if (i > j) {
            swap(arr, i, right - 1);//将i和主元进行交换
        }
//            swap(arr, i, right);
        return i;
    }

    //    交换两个数
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //     返回主元的值，顺便将比主元大的值放在了最右边，将主元放在right-1，只需比较前right-2
    private int getMidThree(int[] arr, int left, int right) {
        int mid = (right + left) / 2;
        if (arr[left] > arr[mid]) {
            swap(arr, left, mid);
        }
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        if (arr[mid] > arr[right]) {
            swap(arr, mid, right);
        }
        swap(arr, right - 1, mid);
        return arr[right - 1];
    }

    //    设置cutOff为10000，当数组长度小于此值时进行简单选择排序
    private void selectionSort(int[] arr, int left, int right) {
        int n = 0, min = 0, p = 0;
        for (int i = left; i <= right - 1; i++) {//最后一个数没必要再进行比较
            n = arr[i];
            min = n;
            for (int j = i; j <= right; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    p = j;
                }
            }
            swap(arr, i, p);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        long startT = 0, endT = 0;
        int n = 1000000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(1000000);
        }
//        for (int i=0;i<n;i++){
//            System.out.println(i+"->"+arr[i]);
//        }
        QuickSort quickSort = new QuickSort();
        startT = System.currentTimeMillis();
        quickSort.sort(arr, 0, arr.length - 1);
        endT = System.currentTimeMillis();
//        for (int i = 0; i < n; i++) {
//            System.out.println(i + "->" + arr[i]);
//        }
        System.out.println(endT - startT);

    }
}
//当cutOff为10的时候效率最高，给100万排序只需要150ms左右
//快排1000:0.2ms,1000,0:2ms,1000,00:20ms,100万：200ms
//选择1000:3ms，1000,0:60ms,1000,00:6000ms
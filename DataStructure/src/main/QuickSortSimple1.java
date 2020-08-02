package main;

public class QuickSortSimple1 {
    public static void sortWrap(int[] list) {
        if (list == null || list.length == 0) {
            return;
        }
        sort(list, 0, list.length - 1);
    }

    static void sort(int[] list, int left, int right) {
        if (right - left == 0) {
            return;
        }
        if (right - left > 1) {
            int pivot = partition(list, left, right);
            sort(list, left, pivot - 1);
            sort(list, pivot + 1, right);
        }
        if (right - left == 1) {
            if (list[left] > list[right]) {
                swap(list, left, right);
            }
        }
    }

    static private int partition(int[] list, int left, int right) {
        int pos = right;
        int posNum = list[pos];
        right--;
        while (left < right) {
            while (list[left] <= posNum) {
                left++;
            }
            while (left < right && list[right] >= posNum) {
                right--;
            }
            if (left < right) {
                swap(list, left, right);
            }
        }
        swap(list, left, pos);
        return left;
    }

    static private void swap(int[] list, int left, int right) {
        int tempt = list[right];
        list[right] = list[left];
        list[left] = tempt;
    }
}

package main;

public class QuickSortSimple {
    public static void sortWrap(int[] list) {
        sort(list,0,list.length-1);
    }
    public static void sort(int[] list, int left, int right) {
        if (list != null && right - left > 1) {
            int pivot = partition(list, left, right);
            sort(list, left, pivot - 1);
            sort(list, pivot + 1, right);
        } else if (list != null && right - left == 1) {
            swap(list, left, right);
        }
    }

    private static int partition(int[] list, int left, int right) {//这里主元默认每次选最右边的数
        int pivotPos = right;
        int pivotNum = list[pivotPos];
        right--;
        while (left < right) {
            while (list[left] < pivotNum) {
                left++;
            }
            while (left < right && list[right] > pivotNum) {
                right--;
            }
            if (left < right) {
                swap(list, left, right);
            }
        }
        swap(list, left, pivotPos);
        return left;
    }

    private static void swap(int[] list, int pos1, int pos2) {
        int temporary = list[pos1];
        list[pos1] = list[pos2];
        list[pos2] = temporary;
    }
}

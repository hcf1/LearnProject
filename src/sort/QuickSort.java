package sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] list = new int[]{6, 4, 2, 7, 8, 9, 1};
        quickSort(list);
        for (int i : list) {
            System.out.printf(String.valueOf(i));
        }
    }

    public static void quickSort(int[] list) {
        if (list != null && list.length > 0) {
            sortCore(list, 0, list.length - 1);
        }
    }

    private static void sortCore(int[] list, int left, int right) {
        if (right - left < 1) {
            return;
        }
        if (right - left > 1) {
            int pivot = partition(list, left, right);
            sortCore(list, left, pivot - 1);
            sortCore(list, pivot + 1, right);
        }
        if (right - left == 1) {
            if (list[left] > list[right]) {
                swap(list, left, right);
            }
        }
    }

    private static int partition(int[] list, int left, int right) {
        int pivotPos = right;
        int pivotNum = list[pivotPos];
        while (left < right) {
            while (left < right && list[left] <= pivotNum) {
                left++;
            }
            while (right > 0 && left < right && list[right] >= pivotNum) {
                right--;
            }
            if (left < right) {
                swap(list, left, right);
            }
        }
        swap(list, left, pivotPos);
        return left;
    }

    private static void swap(int[] list, int left, int right) {
        int tempt = list[left];
        list[left] = list[right];
        list[right] = tempt;
    }
}

package sort;

public class QuickSortSimpleWay {
    public static void main(String[] args) {
        for (int i : quickSort(new int[]{1, 2, 5, 3, 6, 23, 4}, 0, 6)) {
            System.out.println(i);
        }
    }

    static int[] quickSort(int[] list, int left, int right) {
        if (right - left >= 1) {
            int partition = partition(list, left, right);
            quickSort(list, left, partition - 1);
            quickSort(list, partition + 1, right);
        }
        return list;
    }

    static int partition(int[] list, int left, int right) {
        int pivot = list[left];
        int i = left, j = left;
        while (j <= right) {
            if (list[j] < pivot) {
                i++;
                swap(list, i, j);
            }
            j++;
        }
        swap(list, left, i);
        return i;
    }

    private static void swap(int[] list, int left, int right) {
        int temp = list[left];
        list[left] = list[right];
        list[right] = temp;
    }
}

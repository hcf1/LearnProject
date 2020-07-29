public class SortAges {
    int[] sortAges(int[] list) {
        if (list == null) {
            return null;
        }
        int max=0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        int[] bullet = new int[max+1];//注意
        for (int num : list) {
            bullet[num]++;
        }
        int k = 0;
        for (int i = 0; i < bullet.length; i++) {
            for (int j = bullet[i]; j > 0; j--) {
                list[k] = i;
                k++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        for (int i : new SortAges().sortAges(new int[]{6, 6, 8, 1, 2, 3, 3, 3, 4, 4, 5, 5})) {
            System.out.printf(String.valueOf(i));
        }
    }
}

package Instance;

import java.util.HashMap;
import java.util.LinkedList;

public class A {
    int getMonet(int[] list) {
        int max = Integer.MIN_VALUE;
        int sum=0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            if (hashMap.containsKey(i)) {
                sum = hashMap.get(i);
                if (sum > max) {
                    max = sum;
                }
                sum = 0;
                continue;
            }
            for (int j = i; j < list.length;) {
                sum += list[j];
                j++;
                j++;
            }
            hashMap.put(i, sum);
            if (sum > max) {
                max = sum;
            }
            sum = 0;
        }
        return max;
    }
}

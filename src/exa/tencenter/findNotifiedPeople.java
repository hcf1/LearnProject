package exa.tencenter;

import java.util.*;

/**
 * 最开始通知0，和0同组的都会被通知到，递归通知，统计所有被通知到的人。
 * 50是总人数，5是小组数，2表示一个小组中有两个人，1 2是这两个人的编号
 * 输入
 * 50 5
 * 2 1 2
 * 5 10 11 12 13 14
 * 2 0 1
 * 2 49 2
 * 4 6 7 8 2
 * 输出
 * 7
 * 通知了 0 1 2 6 7 8 49 一共7个人
 */
public class findNotifiedPeople {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int members = in.nextInt();
        int groups = in.nextInt();
        ArrayList<int[]> list = new ArrayList<>();
        HashMap<Integer, LinkedList<Integer>> idAndGroups = new HashMap<>();
        int i = 0;

        while (in.hasNextInt()) {
            int j = 0;
            int groupLength = in.nextInt();
            int[] temp=new int[groupLength];
            while (in.hasNextInt()){
                temp[j] = in.nextInt();
                LinkedList<Integer> temptList = idAndGroups.get(temp[j]);
                if (temptList == null) {
                    temptList = new LinkedList<>();
                }
                temptList.add(i);
                idAndGroups.put(temp[j],temptList);
                j++;
                if (j == groupLength) {
                    break;
                }
            }
            list.add(temp);
            i++;
            if (i == groups) {
                break;
            }
        }
        countNotifiedPeople(list, idAndGroups);
    }

    static void countNotifiedPeople(ArrayList<int[]> list, HashMap<Integer,LinkedList<Integer>> idAndGroups) {
        HashSet<Integer> result =new HashSet<>();
        LinkedList<Integer> groups = new LinkedList<>();
        HashSet<Integer> record = new HashSet<>();
        if (idAndGroups.get(0) == null) {
            System.out.println(0);
            return;
        }
        for (int groupId : idAndGroups.get(0)) {
            groups.offer(groupId);
        }
        while (!groups.isEmpty()) {
            int groupId = groups.poll();
            for (int member : list.get(groupId)) {
                result.add(member);
            }
            for (int group : idAndGroups.get(groupId)) {
                if (record.contains(group)) {
                } else {
                    record.add(group);
                    groups.offer(group);
                }
            }
        }
        System.out.println(result.size());
    }
}

import java.util.HashMap;

/**
 * 输入二叉树的前序和中序遍历顺序，构建此二叉树
 *
 * @author hasee
 */
public class ReBuildBinaryTree {
    /**
     * 将中序数组放入map，可以根据前序数组值查询对应的中序数组坐标
     */
    static HashMap<Integer, Integer> map = new HashMap();
    /**
     * 前序序列
     */
    static int position = -1;
    static int[] Array;

    static void reBuilder(int[] firstArray, int[] midArray) {
        Array = firstArray;
        for (int i = 0; i < midArray.length; i++) {
            map.put(midArray[i], i);
        }
        Node head = build(-1, 0, firstArray.length - 1);
        System.out.println(head);
    }

    /**
     * 思路：采用划分左右子树的方式，递归创建二叉树。从下向上构建二叉树。时间复杂度O(n)，空间复杂度O(n)
     * 初始化节点时用成员变量position指定当前遍历的前序数组的下标；为了保证划分子树的正确性，让递归子函数保存flag(子树区间).
     * flag为递归函数的局部变量
     */
    private static Node build(int flag, int left, int right) {
        if (left < right) {
            position++;
            flag++;
            Node head = new Node(Array[position]);
            head.left = build(position, left, map.get(Array[flag]) - 1);
            head.right = build(position, map.get(Array[flag]) + 1, right);
            return head;
        } else if (left == right) {
            position++;
            return new Node(Array[position]);
        } else {
            return null;
        }
    }

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }
}

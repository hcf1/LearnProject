package tree;

import java.util.LinkedList;

public class BinaryTree2 {
    public static void main(String[] args) {
        TreeNode2 treeNode2= createTree(new int[]{1, 2, 3, 4, 5, 6}, 0);
        DFS(treeNode2);
    }

    static TreeNode2 createTree(int[] list,int index) {
        if (index < list.length) {
            TreeNode2 newNode = new TreeNode2(list[index]);
            newNode.left = createTree(list, index * 2 + 1);
            newNode.right = createTree(list, index * 2 + 2);
            return newNode;
        } else return null;
    }

    static void preTraverse(TreeNode2 treeNode2 ) {
        System.out.println(treeNode2.val);
        preTraverse(treeNode2.left);
        preTraverse(treeNode2.right);
    }
    static void midTraverse(TreeNode2 treeNode2 ) {
        preTraverse(treeNode2.left);
        System.out.println(treeNode2.val);
        preTraverse(treeNode2.right);
    }
    static void lastTraverse(TreeNode2 treeNode2 ) {
        preTraverse(treeNode2.left);
        preTraverse(treeNode2.right);
        System.out.println(treeNode2.val);
    }

    static void DFS(TreeNode2 treeNode2) {
        if (treeNode2 == null) {
            return;
        }
        LinkedList<TreeNode2> linkedList = new LinkedList<>();
        linkedList.push(treeNode2);
        while (!linkedList.isEmpty()) {
            TreeNode2 node2 = linkedList.pop();
            System.out.println(node2.val);
            if (node2.right != null) {
                linkedList.push(node2.right);
            }
            if (node2.left != null) {
                linkedList.push(node2.left);
            }
        }
    }
    static void BFS(TreeNode2 treeNode2) {
        if (treeNode2 == null) {
            return;
        }
        LinkedList<TreeNode2> linkedList = new LinkedList<>();
        linkedList.offer(treeNode2);
        while (!linkedList.isEmpty()) {
            TreeNode2 node2 = linkedList.poll();
            System.out.println(node2.val);
            linkedList.offer(node2.left);
            linkedList.offer(node2.right);
        }
    }


}
class TreeNode2{
    TreeNode2 left, right;
    int val;

    TreeNode2(int val) {
        this.val = val;
    }
}

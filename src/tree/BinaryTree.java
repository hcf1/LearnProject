package tree;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.LinkedList;

public class BinaryTree {
    private static TreeNode root;

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        root=binaryTree.creatCompleteBinaryTree(root, new int[]{1, 2, 3, 4, 5}, 0);
        binaryTree.BFS(root);
    }

    TreeNode creatCompleteBinaryTree(TreeNode node, int[] arr, int index) {
        if (index >= arr.length) {
            return node;
        }
        TreeNode newNode = new TreeNode(arr[index]);
        node=newNode;
        node.left=creatCompleteBinaryTree(node.left, arr, index * 2 + 1);
        node.right=creatCompleteBinaryTree(node.right, arr, index * 2 + 2);
        return node;
    }

    void BFS(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList();
        list.offer(root);
        while (!list.isEmpty()) {
            TreeNode treeNode = list.poll();
            System.out.println(treeNode.value);
            if (treeNode.left != null) {
                list.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                list.offer(treeNode.right);
            }
        }
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }
}
